package com.znznhome.lucene.analyzer;

import java.io.StringReader;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

public class AnalyzerTest {

	String enText = "IndexWriter addDocument's a javadoc.txt";
	String zhText = "2B青年快乐多";

	Analyzer en1 = new StandardAnalyzer(Version.LUCENE_36); // 单字分词
	Analyzer en2 = new SimpleAnalyzer(Version.LUCENE_36);

	Analyzer zh1 = new CJKAnalyzer(Version.LUCENE_36); //二分法分词
	Analyzer zh2 = new MMSegAnalyzer(); // 词库分词
	
	Analyzer mms = new IKAnalyzer();

	@Test
	public void test() throws Exception {
		 analyze(mms, zhText);
		// analyze(en1, zhText);

		// analyze(zh1, zhText);
		 //analyze(zh1, zhText);
	}

	public void analyze(Analyzer analyzer, String text) throws Exception {
		System.out.println("-------------> 分词器" + analyzer.getClass());
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		Iterator<AttributeImpl> it = tokenStream.getAttributeImplsIterator();
		while(it.hasNext()) {
			AttributeImpl attr = it.next();
			System.out.println(attr);
		}
		Token token = new Token();
	}
	
/*	public void analyze2(Analyzer analyzer, String text) throws Exception {
		System.out.println("-------------> 分词器：" + analyzer.getClass());
		TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
		for (Token token = new Token(); (token = tokenStream..next(token)) != null;) {
			System.out.println(token);
		}
	}*/
}
