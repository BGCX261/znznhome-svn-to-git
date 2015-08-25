package com.znznhome.lucene.helloworld;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.MultiReader;
import org.apache.lucene.index.ParallelReader;
import org.apache.lucene.index.SegmentReader;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.znznhome.lucene.utils.File2DocumentUtils;

public class HelloWorld {

	String filePath = "E:\\IndexWriter addDocument's a javadoc.txt";

	String indexPath = "E:\\luceneIndex";

	Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

	/**
	 * 创建索引
	 * 
	 * IndexWriter 是用来操作（增、删、改）索引库的
	 */
	@Test
	public void createIndex() throws Exception {
		// file --> doc
		Document doc = File2DocumentUtils.file2Document(filePath);
		String _indexPath = "E:\\luceneIndex";
		Directory _dir = null;
		IndexWriterConfig _conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		//建立索引
		IndexWriter indexWriter = new IndexWriter(_dir, _conf);;
		indexWriter.addDocument(doc);
		indexWriter.close();
	}

	/**
	 * 搜索
	 * 
	 * IndexSearcher 是用来在索引库中进行查询的
	 */
	@Test
	public void search() throws Exception {
//		String queryString = "document";
		String queryString = "adddocument";

		//1，把要搜索的文本解析为 Query
		String[] fields = { "name", "content" };
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_36, fields, analyzer);
		Query query = queryParser.parse(queryString);

		// 2，进行查询
		ParallelReader pReader = new ParallelReader();
		SegmentReader sReader = new SegmentReader();
		MultiReader mReader = new MultiReader(pReader, sReader);
		IndexSearcher indexSearcher = new IndexSearcher(mReader);
		Filter filter = null;
		TopDocs topDocs = indexSearcher.search(query, filter, 10000);
		System.out.println("总共有【" + topDocs.totalHits + "】条匹配结果");

		// 3，打印结果
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			int docSn = scoreDoc.doc; // 文档内部编号
			Document doc = indexSearcher.doc(docSn); // 根据编号取出相应的文档
			File2DocumentUtils.printDocumentInfo(doc); // 打印出文档信息
		}
	}
}
