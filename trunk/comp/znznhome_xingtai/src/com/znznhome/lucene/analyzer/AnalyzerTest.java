package com.znznhome.lucene.analyzer;

import java.io.StringReader;
import java.util.Iterator;

import jeasy.analysis.MMAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class AnalyzerTest {

	String enText = "IndexWriter addDocument's a javadoc.txt";
	String zhText = "2B青年快乐多";

	Analyzer en1 = new StandardAnalyzer(Version.LUCENE_36); // 单字分词
	Analyzer en2 = new SimpleAnalyzer(Version.LUCENE_36);

	Analyzer zh1 = new CJKAnalyzer(Version.LUCENE_36); //二分法分词
	Analyzer zh2 = new MMAnalyzer(); // 词库分词

	@Test
	public void test() throws Exception {
		 analyze(en2, enText);
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
	}
}
