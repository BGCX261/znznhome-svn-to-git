package com.znznhome.lucene.directory;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.znznhome.lucene.utils.File2DocumentUtils;

public class DirectoryTest {
	String filePath = "D:\\MyEclipse 8.6\\znznhome_xingtai\\WebRoot\\source\\MyInformation.txt";
	String indexPath = "D:\\MyEclipse 8.6\\znznhome_xingtai\\WebRoot\\luceneIndex";
	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

	@Test
	public void test1()throws Exception {
		// Directory dir = FSDirectory.getDirectory(indexPath);
		Directory dir = new RAMDirectory();
		
		Document doc = File2DocumentUtils.file2Document(filePath);
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		IndexWriter indexWriter = new IndexWriter(dir, conf);
		indexWriter.addDocument(doc);
		indexWriter.close();
	}
	
	@Test
	public void test2() throws Exception{
		Directory fsDir = FSDirectory.open(new File(indexPath));
	
		//1，启动时读取
		Directory ramDir = new RAMDirectory(fsDir);
		
		// 运行程序时操作 ramDir
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		IndexWriter ramIndexWriter = new IndexWriter(ramDir, conf);
		//添加 Document
		Document doc = File2DocumentUtils.file2Document(filePath);
		ramIndexWriter.addDocument(doc);
		ramIndexWriter.close();
		
		// 2，退出时保存
		IndexWriter fsIndexWriter = new IndexWriter(fsDir, conf);
		fsIndexWriter.addIndexes(ramDir);
		//	fsIndexWriter.flush();
		//	fsIndexWriter.optimize();
		fsIndexWriter.close();
	}
	
	
	@Test
	public void test3() throws Exception{
		Directory fsDir = FSDirectory.open(new File(indexPath));
		IndexWriter fsIndexWriter = new IndexWriter(fsDir, analyzer, MaxFieldLength.LIMITED);
		
		fsIndexWriter.optimize();
		fsIndexWriter.close();
	}
}
