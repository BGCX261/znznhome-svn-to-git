/**   
 * @Title: FilterTest.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:24:32 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

/**
 * @Description levelSet作为非法字符的计数器
 * @author lxd
 * @date 2012-10-2 下午09:24:32
 * @version V1.3.1
 */

public class FilterTest {
	public static void main(String args[]) {
        MutiPatternParser filterEngine = new MutiPatternParser();
        BufferedReader brKeyword = TxtReader.keywordReader("badwords.txt");//关键字的文件
        BufferedReader brArticle = TxtReader.keywordReader("article.txt");//待验证的文章
        String keyword = null;
        String article = null;
        StringBuffer buffer = new StringBuffer();
        Vector<Integer> levelSet = new Vector<Integer>();
        Vector<AtomicPattern> realBadWords = new Vector<AtomicPattern>();
        try {
        	//加载所有关键词
            while ((keyword = brKeyword.readLine()) != null) {
                filterEngine.addFilterKeyWord(keyword, 1);
            }
            //加载文章内所有字符
            while ((article = brArticle.readLine()) != null) {
                buffer.append(article);
            }
        } catch (IOException e) {
            System.out.println("读取文件IO异常!!!");
            e.printStackTrace();
        }
    
        //buffer： 文章
        String content = filterEngine.parse(buffer.toString(), levelSet);

        levelSet.clear();
        filterEngine.parse(content, levelSet);
        System.out.println("有违法字符" + levelSet.size()+"处");
        levelSet.clear();
        Vector<AtomicPattern> singleRealKeyWords = filterEngine.getSingleRealKeyWords(content, levelSet);
        Vector<AtomicPattern> allKeyWords = filterEngine.getAllKeyWords(content);
        Vector<AtomicPattern> realKeyWords = filterEngine.getRealKeyWords(content, levelSet);
        System.out.println("allKeyWords.size()" + allKeyWords.size());
        System.out.println("singleRealKeyWords()" + singleRealKeyWords.size());
        System.out.println("realKeyWords()" + realKeyWords.size());
        for(AtomicPattern ap : allKeyWords) {
        	//System.out.println("去重后的真正关键词 -- " + ap);
        	System.out.println("allKeyWords -- " + ap);
        	content = content.replaceAll(ap.getPattern().getStr(), MutiPatternParser.HEXIEWORD);
        }
/*        for(AtomicPattern ap : realKeyWords) {
        	//System.out.println("去重后的真正关键词 -- " + ap);
        	System.out.println("realKeyWords -- " + ap);
        }*/
/*        for(AtomicPattern ap : singleRealKeyWords) {
        	//System.out.println("去重后的真正关键词 -- " + ap);
        	System.out.println("singleRealKeyWords -- " + ap);
        }*/
        System.out.println("替换后的文本 -- " + content);
    }
}
