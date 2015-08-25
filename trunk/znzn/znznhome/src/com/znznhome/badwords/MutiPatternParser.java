/**   
 * @Title: MutiPatternParser.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:19:39 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

import java.util.Vector;

import com.znznhome.util.CommonUtil;

/**
 * @Description 无法过滤和检测单个字；
 * 				keyWords和realKeyWords的区别：keyWords是只要文本中出现了关键词列表中的词，就算一个是一个keyWords
 * 				realKeyWords是，将所有keyWords和关键词列表中的关键词组合进行比较，（列表中的一行），匹配的才算真正keyWords。
 * 				测试文本：”中国人民政府是共产党的政府，不是我们的。祝你妈生日快乐；是傻B“
 * 				关键词列表：
 * 					共产党 是傻B
 * 					你妈
 * 					政府
 * 					人 2B
 * @author lxd
 * @date 2012-10-2 下午09:19:39
 * @version V1.3.1
 */

public class MutiPatternParser {

	
	/** @Fields HEXIEWORD: 用于替换的关键词*/
	public static final String HEXIEWORD = "[河蟹]";

	private boolean initFlag = false;

	/** @Fields maxIndex: 2的16次方*/
	private int maxIndex = (int) java.lang.Math.pow(2, 16);

	private int shiftTable[] = new int[maxIndex];

	/** @Fields hashTable: 装关键词  Vector是什么： 同步的ArrayList*/
	public Vector<AtomicPattern> hashTable[] = new Vector[maxIndex];

	private UnionPatternSet tmpUnionPatternSet = new UnionPatternSet();

	/**
	 * @Description 把空格分隔的keywords，且分开，分别封装成Pattern，存到UnionPattern里面，
	 *              再将UnionPattern存到UnionPatternSet里面； keywords写在文本文件中，每个关键词用空格隔开，可以有多行；
	 * @author lxd
	 * @param keyWord
	 * @param level
	 * @return
	 */
	public boolean addFilterKeyWord(String keyWord, int level) {
		
		if (initFlag == true)
			return false;
		
		// 每行关键词，存成一个unionPattern
		UnionPattern unionPattern = new UnionPattern();

		// 原代码只能由一个空格来拆分，多余的空格则被认为是关键词，所以做下列处理，压缩空格。
		String keyWordsComp = CommonUtil.compressionSpaces(keyWord);
		String[] strArray = keyWordsComp.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			Pattern pattern = new Pattern(strArray[i]);
			AtomicPattern atomicPattern = new AtomicPattern(pattern);
			unionPattern.addNewAtomicPattrn(atomicPattern);
			unionPattern.setLevel(level);
			atomicPattern.setBelongUnionPattern(unionPattern);
		}
		
		// 所有行的关键词（所有unionPattern），都存到tmpUnionPatternSet中
		tmpUnionPatternSet.addNewUnionPattrn(unionPattern);
		return true;
	}

	/**
	 * @Description 检测当前字符是否合法，中文、英文、数字合法；
	 * @author lxd
	 * @param ch
	 *            待检测字符
	 * @return
	 */
	private boolean isValidChar(char ch) {
		if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
			return true;
		if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
			return true;// 简体中文汉字编码
		return false;
	}

	/**
	 * @Description 原始代码中的方法
	 * @author lxd
	 * @param content
	 *            需要匹配的内容（文章内容）
	 * @param levelSet
	 *            级别
	 * @return
	 */
	public String parse(String content, Vector<Integer> levelSet) {
		Vector<AtomicPattern> aps = getAllKeyWords(content);
		parseAtomicPatternSet(aps, levelSet);
		return content;
	}
	
	 
	/** 
	 * @Description 原始代码的parse()方法中提炼出来的；
	 * 				按照关键词列表，获取文本中出现的关键词，返回所有关键词，文本中重复出现的关键词将被记录多次；
	 * @author lxd
	 * @param content 文本
	 * @return  
	 */
	public Vector<AtomicPattern> getAllKeyWords(String content) {
		
		if (initFlag == false)
			init();
		
		// 装检查出来的关键词，检测到几个装几个，可能有重复，例如文本中出现了两个‘政府’，则两个“政府“都会被装到aps中
		Vector<AtomicPattern> aps = new Vector<AtomicPattern>();
		
		// 不符合要求的字符过滤掉
		String preContent = preConvert(content);
		
		// 将文本中的关键词装到aps中
		for (int i = 0; i < preContent.length();) {
			
			// 一个一个字符的取；
			char checkChar = preContent.charAt(i);
			//System.out.println("checkChar -- " + checkChar);
			//System.out.println("checkChar to in -- " + (int) checkChar);
			//
			if (shiftTable[checkChar] == 0) {
				Vector<AtomicPattern> tmpAps = new Vector<AtomicPattern>();
				//System.out.println("preContent -- " + preContent);
				//System.out.println("preContent.substring(0, i + 1) -- "
						//+ preContent.substring(0, i + 1));
				
				/*
				 * 例如，检测到“府”字，发现有关键字时，会将文本截取成“中国人民政府”，然后去与hashTable[府]中装的所有关键字去匹配
				 * 这里hashTable[府]只装了一个“政府”，其实还可以装“大名府”...任何以“府”结尾的词；
				 * 比对的时候，会取出么一个关键词，从文本末尾截取等长的词进行比对，例如比对“政府”的时候，截取两个字“政府”，比对“大名府”
				 * 的时候，截取“民政府”进行比对；
				 */
				tmpAps = findMathAps(preContent.substring(0, i + 1), hashTable[checkChar]);
				aps.addAll(tmpAps);
				i++;
			} else
				i = i + shiftTable[checkChar];
		}
		return aps;
	}

	/**
	 * @Description 包含敏感词返回true
	 * @author lxd
	 * @param content
	 *            文本
	 * @param levelSet
	 *            敏感词级别
	 * @return
	 */

	public boolean includeRealKeyWords(String content, Vector<Integer> levelSet) {
		
		Vector<AtomicPattern> allKeyWords = getAllKeyWords(content);
		parseAtomicPatternSet(allKeyWords, levelSet);
		if (levelSet.size() > 0)
			return true;
		return false;
	}

	/**
	 * @Description 将真正的关键词，装到realBadWords里面，供替换使用，例如 ”共产党 是猪“两个关键词在文章中都出现了，则”共产党“和”是猪“
	 *              都会被替换，而如果仅出现了”共产党“，则不替换。
	 *              返回需要替换掉的关键词、已去掉重复词语；
	 * @author lxd
	 * @param content
	 * @param levelSet
	 * @param realBadWords
	 * @return
	 */

	public Vector<AtomicPattern> getSingleRealKeyWords(String content, Vector<Integer> levelSet) {
		
		//获取所有的组合关键词
		Vector<AtomicPattern> realKeyWords = getRealKeyWords(content, levelSet);
		
		//去重
		return removeDuplicates(realKeyWords);
	}
	
	 

	  	
	 
	/** 
	 * @Description 
	 * @author lxd
	 * @param realKeyWords  
	 */
	  	
	public Vector<AtomicPattern> removeDuplicates(Vector<AtomicPattern> realKeyWords) {
		
		Vector<AtomicPattern> tmpVector = new Vector<AtomicPattern>();
		
		if(realKeyWords != null && realKeyWords.size() > 0) {
			for(int i=0; i<realKeyWords.size(); i++) {
				if(!tmpVector.contains(realKeyWords.get(i))) {
					tmpVector.add(realKeyWords.get(i));
				}
			}
		}
		return tmpVector;
	}

	/**
	 * @Description 检验文本中出现的关键词集合，根据组合关键词（关键词列表中用空格分隔的一行，为一个关键词组合，例如”共产党  是傻B“），
	 * 				来检测关键词集合中哪些是真正的非法词汇组合；将UnionPattern中的level装到levelSet中。
	 * @author lxd
	 * @param aps
	 *            检测到的所有的关键词，都装到了aps中
	 * @param levelSet
	 */

	private void parseAtomicPatternSet(Vector<AtomicPattern> aps, Vector<Integer> levelSet) {
		
		// 从aps中将元素（AtomicPattern，也就是关键词）逐个拿出来，
		while (aps.size() > 0) {
			AtomicPattern ap = aps.get(0);
			
			/*
			 * ap的belongUnionPattern是在addFilterKeyWord(String keyWord, int
			 * level)的时候设置的每个unionPattern装的是关键词文件中的一行关键词
			 */
			UnionPattern up = ap.belongUnionPattern;

			/*
			 * 只有一行的关键词（关键词列表中的一行，用空格” “分隔开组成的集合），都在文章中出现了时，才算真正检测到了非法关键词.例如，如果关键词列表第一行是”共产党
			 * 国民党“，而文章中只出现了”共产党“，则不算检测出了非法关键词。只有文章中即出现了 ”共产党“，又出现了”国民党“时，才算出现一处非法关键词。
			 * 换句话讲：每一个关键词只要在文章中出现，就能检测到，但是是否算数，规则由用户自己定。 例如，关键词列表中，一行设置成”共产党 王八蛋
			 * “，那么只有文章中即出现了”共产党“，又出现了”王八蛋“时，才算非法，如果只是出现了”共产党真它奶奶的是个好党“，则不认为非法；
			 * 这样，在非法关键词组合出现时，可以做必要处理，例如，不允许提交，给出提示。 而在关键词替换时，则不需要这样判断，只要检测到关键词，就处理掉即可。
			 */
			if (up.isIncludeAllAp(aps) == true) {

				/*
				 * up的level是在addFilterKeyWord(String keyWord, int level)的时候初始化的，这里每读取一行
				 * 存成一个unionPattern，所有的level都设成了1
				 */
				//System.out.println("up.getLevel() -- " + up.getLevel());
				levelSet.add(new Integer(up.getLevel()));
			}
			
			// 处理完一个移除一个
			aps.remove(0);
		}
	}

	/**
	 * @Description 检验文本中出现的关键词集合，根据组合关键词（关键词列表中用空格分隔的一行，为一个关键词组合，例如”共产党  是傻B“），
	 * 				来检测关键词集合中哪些是真正的非法词汇组合，将解析后的非法关键词进行存储；将UnionPattern中的level装到levelSet中。
	 * @author lxd
	 * @param aps
	 *            检测到的所有的关键词，都装到了aps中
	 * @param levelSet
	 */
	public Vector<AtomicPattern> getRealKeyWords(String content,
			Vector<Integer> levelSet) {
		
		Vector<AtomicPattern> aps = getAllKeyWords(content);
		
		Vector<AtomicPattern> realKeyWords = new Vector<AtomicPattern>();
		
		// 从aps中将元素（AtomicPattern，也就是关键词）逐个拿出来，
		while (aps.size() > 0) {
			AtomicPattern ap = aps.get(0);
			
			/*
			 * ap的belongUnionPattern是在addFilterKeyWord(String keyWord, int level)的时候设置的
			 * 每个unionPattern装的是关键词文件中的一行关键词
			 */
			UnionPattern up = ap.belongUnionPattern;
			
			/*
			 * 只有一行的关键词（关键词列表中的一行，用空格” “分隔开组成的集合），都在文章中出现了时，才算真正检测到了非法关键词.例如，如果关键词列表第一行是”共产党
			 * 国民党“，而文章中只出现了”共产党“，则不算检测出了非法关键词。只有文章中即出现了 ”共产党“，又出现了”国民党“时，才算出现一处非法关键词。
			 * 换句话讲：每一个关键词只要在文章中出现，就能检测到，但是是否算数，规则由用户自己定。 例如，关键词列表中，一行设置成”共产党 王八蛋
			 * “，那么只有文章中即出现了”共产党“，又出现了”王八蛋“时，才算非法，如果只是出现了”共产党真它奶奶的是个好党“，则不认为非法；
			 * 这样，在非法关键词组合出现时，可以做必要处理，例如，不允许提交，给出提示。 而在关键词替换时，则不需要这样判断，只要检测到关键词，就处理掉即可。
			 * aps是否包含up
			 * 检测完’共产党‘的时候，就在aps中把”共产党“移除了，因此检测”是傻B“的时候，”共产党 是傻B“就不包括在aps中了。
			 * 是否移除，要看需要了。例如如果想把”是傻B“也屏蔽掉，那么就不能移除；但一般情况下，只把共产党屏蔽掉就可以了，是傻B在没有共产党的前提下，并不属于需要过滤的词；
			 * 而共产党在没有是傻B的前提下，也是可以保留的；
			 */
			if (up.isIncludeAllAp(aps) == true) {
				
				/*
				 * up的level是在addFilterKeyWord(String keyWord, int level)的时候初始化的，这里每读取一行
				 * 存成一个unionPattern，所有的level都设成了1
				 */
				//System.out.println("up.getLevel() -- " + up.getLevel());
				levelSet.add(new Integer(up.getLevel()));
				realKeyWords.add(ap);
			}
			
			// 处理完一个移除一个
			aps.remove(0);
		}
		
		return realKeyWords;
	}

	/**
	 * @Description 把与src的末尾匹配的所有destAps中的AtomicPattern都返回； 例如src=“中国人民政府”，destAps中的装
	 * @author lxd
	 * @param src
	 * @param destAps
	 * @return
	 */

	private Vector<AtomicPattern> findMathAps(String src, Vector<AtomicPattern> destAps) {
		Vector<AtomicPattern> aps = new Vector<AtomicPattern>();
		for (int i = 0; i < destAps.size(); i++) {
			AtomicPattern ap = destAps.get(i);
			//System.out.println("destAps.get(i) 中的Patern中的 str -- " + ap.getPattern().str);
			//System.out.println("src -- " + src);
			if (ap.findMatchInString(src) == true)
				aps.add(ap);
		}
		return aps;
	}

	/**
	 * @Description 预处理，将非法字符去掉
	 * @author lxd
	 * @param content
	 * @return
	 */

	private String preConvert(String content) {
		String retStr = new String();
		for (int i = 0; i < content.length(); i++) {
			char ch = content.charAt(i);
			if (this.isValidChar(ch) == true) {
				retStr = retStr + ch;
			}
		}
		return retStr;
	}

	// shift table and hash table of initialize

	/**
	 * @Description 初始化
	 * @author lxd
	 */

	private void init() {
		initFlag = true;
		for (int i = 0; i < maxIndex; i++)
			hashTable[i] = new Vector<AtomicPattern>();
		shiftTableInit();
		hashTableInit();
	}

	public void clear() {
		tmpUnionPatternSet.clear();
		initFlag = false;
	}

	/**
	 * @Description shiftTable是一个int数组，处理关键字
	 * 
	 *              shiftTable[] 初始化全是2 shiftTable[产] 是1 shiftTable[党] 是0
	 * 
	 *              shiftTable[政] 是1 shiftTable[府] 是0
	 * 
	 *              shiftTable[你] 是1 shiftTable[妈] 是0
	 * 
	 *              共产党的“共”字不用处理，因为三个字以上的关键词，末尾两个字一定会做标记 这样的话，只要抓住末尾两位，就可以才欧诺个hashTable中拿出整个关键词，通过
	 *              倒着截取与关键词等长字符的方式截取被检测文本中的等长字符“共产党”进行比较，
	 *              看是否匹配。比如截取到的检测字符时“狗产党”，那就是不匹配了。所以三个字以上的关键词， 只末尾两个字需要处理，第三个以及之前的，是共，是狗，都没关系。
	 * 
	 * @author lxd
	 */

	private void shiftTableInit() {
		for (int i = 0; i < maxIndex; i++)
			shiftTable[i] = 2;
		Vector<UnionPattern> upSet = tmpUnionPatternSet.getSet();
		for (int i = 0; i < upSet.size(); i++) {
			Vector<AtomicPattern> apSet = upSet.get(i).getSet();
			for (int j = 0; j < apSet.size(); j++) {
				AtomicPattern ap = apSet.get(j);
				Pattern pattern = ap.getPattern();
				if (shiftTable[pattern.charAtEnd(1)] != 0) {
/*					System.out.println("pattern.charAtEnd(1) -- " + pattern.charAtEnd(1));
					System.out.println("pattern.charAtEnd(1) to int -- "
							+ (int) pattern.charAtEnd(1));
					System.out.println("shiftTable[pattern.charAtEnd(1)] -- "
							+ shiftTable[pattern.charAtEnd(1)]);*/
					shiftTable[pattern.charAtEnd(1)] = 1;
				}

				if (shiftTable[pattern.charAtEnd(0)] != 0) {
/*					System.out.println("pattern.charAtEnd(0) -- " + pattern.charAtEnd(0));
					System.out.println("pattern.charAtEnd(0) to int -- "
							+ (int) pattern.charAtEnd(0));
					System.out.println("shiftTable[pattern.charAtEnd(0)] -- "
							+ shiftTable[pattern.charAtEnd(0)]);*/
					shiftTable[pattern.charAtEnd(0)] = 0;
				}
			}
		}
	}

	/**
	 * @Description 用关键字的最后一个字符的编码（数字）作为下标，将AtomicPattern(里面是一个关键字)，存到hashTable(Vector数组 )中。
	 *              hashTable是一个Vector(类似List)数组；
	 * @author lxd
	 */

	private void hashTableInit() {
		Vector<UnionPattern> upSet = tmpUnionPatternSet.getSet();
		for (int i = 0; i < upSet.size(); i++) {
			Vector<AtomicPattern> apSet = upSet.get(i).getSet();
			for (int j = 0; j < apSet.size(); j++) {
				AtomicPattern ap = apSet.get(j);
				Pattern pattern = ap.getPattern();
				if (pattern.charAtEnd(0) != 0) {
					//System.out.println("ap.getPattern().str -- " + ap.getPattern().str);
					
					/*
					 * hashTable[府] 存 AtomicPattern<政府> hashTable[党] 存
					 * AtomicPattern<共产党>注意，这里的hashTable[]是一个Vector，hashTable[党] 可以存一个
					 * AtomicPattern<共产党>，也可以存 AtomicPattern<国民党>，还可以存任何以“党结尾的词”，
					 * 所以检测对比的时候，需要遍历；
					 */
					hashTable[pattern.charAtEnd(0)].add(ap);
/*					System.out.println("pattern.charAtEnd(0) -- " + pattern.charAtEnd(0));
					System.out.println("pattern.charAtEnd(0) to int -- "
							+ (int) pattern.charAtEnd(0));*/
				}
			}
		}
	}

	public static void main(String[] args) {
		MutiPatternParser parser = new MutiPatternParser();
		AtomicPattern ap = new AtomicPattern(new Pattern("共产党"));
		Vector<AtomicPattern> apSet = new Vector<AtomicPattern>();
		apSet.add(ap);
		UnionPattern up = new UnionPattern();
		up.apSet = apSet;

		parser.tmpUnionPatternSet = new UnionPatternSet();
		parser.tmpUnionPatternSet.addNewUnionPattrn(up);
		parser.hashTableInit();
	}

}
