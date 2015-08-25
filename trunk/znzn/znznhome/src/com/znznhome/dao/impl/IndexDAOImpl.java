package com.znznhome.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.znznhome.dao.IndexDAO;
import com.znznhome.enums.IndexBean;
import com.znznhome.lucene.QueryResult;
import com.znznhome.model.Url;

@Component("indexDAO")
public class IndexDAOImpl implements IndexDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	
	public boolean createIndex(String sql, Class c, IndexBean type) throws Exception{
		//String indexPath = "E:\\luceneIndex";
		String indexPath = this.getClass().getClassLoader().getResource("").toString().replace("WEB-INF/classes/", "").replace("file:/", "");
		indexPath = indexPath + "indexPath";

		//System.out.println("indexPath ---------- " + indexPath);
		Directory dir = null;
		Analyzer analyzer = new IKAnalyzer();// 词库分词
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		IndexWriter indexWriter = null;
		//避免重复加载IndexWriter
		if (indexWriter == null) {
			try {
				dir = new SimpleFSDirectory(new File(indexPath));
				indexWriter = new IndexWriter(dir, conf);
				//先删除所有索引
				indexWriter.deleteAll();
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (LockObtainFailedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		
		boolean rst = true;
		
		Session session = sessionFactory.getCurrentSession();
		
		//Session session = sessionFactory.openSession();//允许test测试时用
		SQLQuery q = session.createSQLQuery(sql);
		List list = q.addEntity(c).list();
		switch(type){
		case URL:
			for(int i=0; i<list.size(); i++) {
				Url url = (Url)list.get(i);
				Document doc = new Document();
				doc.add(new Field("id",url.getId()+"", Store.YES, Index.NOT_ANALYZED));
				doc.add(new Field("title", url.getTitle(), Store.YES, Index.ANALYZED));
				doc.add(new Field("origin", url.getOrigin(), Store.YES, Index.ANALYZED));
				doc.add(new Field("categoryname", url.getCategoryname(), Store.YES, Index.NOT_ANALYZED));
				doc.add(new Field("urladdress", url.getUrladdress(), Store.YES, Index.NOT_ANALYZED));
				doc.add(new Field("descr", url.getDescr(), Store.YES, Index.ANALYZED));
				rst = rst & save(doc, indexWriter);
				//System.out.println(doc);
			}
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			break;
		case NEWS:
			break;
		case ARTICLE:
			break;
		}
		return rst;
	}

	/**
	 * 添加/创建索引
	 * 
	 * @param doc
	 */
	public boolean save(Document doc, IndexWriter indexWriter) {
		
		try {
			indexWriter.addDocument(doc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	/**
	 * Term是搜索的最小单位，代表某个 Field 中的一个关键词，如：<title, lucene>
	 * 
	 * 删除包含项的所有文档
	 * 
	 * new Term( "title", "lucene" );
	 * 
	 * new Term( "id", "5" );
	 * 
	 * new Term( "id", UUID );
	 * 
	 * @param term
	 */
	public boolean delete(Term term) {
		String indexPath = this.getClass().getClassLoader().getResource("").toString().replace("WEB-INF/classes/", "").replace("file:/", "");
		indexPath = indexPath + "indexPath";
		System.out.println(indexPath);
		Directory dir = null;
		Analyzer analyzer = new IKAnalyzer();// 词库分词
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		IndexWriter indexWriter = null;
		//避免重复加载IndexWriter
		if (indexWriter == null) {
			try {
				dir = new SimpleFSDirectory(new File(indexPath));
				indexWriter = new IndexWriter(dir, conf);
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (LockObtainFailedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		try {
			indexWriter.deleteDocuments(term);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * 更新索引
	 * 
	 * <pre>
	 * indexWriter.deleteDocuments(term);
	 * indexWriter.addDocument(doc);
	 * </pre>
	 * 
	 * @param term
	 * @param doc
	 */
	public boolean update(Term term, Document doc) {
		//String indexPath = "E:\\luceneIndex";
		String indexPath = this.getClass().getClassLoader().getResource("").toString().replace("WEB-INF/classes/", "").replace("file:/", "");
		indexPath = indexPath + "indexPath";
		Directory dir = null;
		Analyzer analyzer = new IKAnalyzer(true);// 词库分词
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		IndexWriter indexWriter = null;
		//避免重复加载IndexWriter
		if (indexWriter == null) {
			try {
				dir = new SimpleFSDirectory(new File(indexPath));
				indexWriter = new IndexWriter(dir, conf);
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (LockObtainFailedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		try {
			indexWriter.updateDocument(term, doc);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				indexWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * <pre>
	 * totalPage = recordCount / pageSize;
	 * if (recordCount % pageSize &gt; 0)
	 * 	totalPage++;
	 * </pre>
	 * 
	 * @param queryString 搜索的关键词
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public QueryResult search(String queryString,  int pageNo, int pageSize) {
/*		try {
			queryString = new String(queryString.getBytes("iso-8859-1"),("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		System.out.println("queryString --- " + queryString);
		Analyzer analyzer = new IKAnalyzer(true);// 词库分词
		
		try {
			// 1，把要搜索的文本解析为 Query
			String[] fields = {"id", "title", "descr", "origin" , "categoryname", "urladdress"};
			Map<String, Float> boosts = new HashMap<String, Float>();
			//boosts: 权重
			boosts.put("title", 3f);
			boosts.put("descr", 2f);
			// boosts.put("content", 1.0f); 默认为1.0f

			QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_36, fields, analyzer);
			Query query = queryParser.parse(queryString);

			return search(query, pageNo, pageSize);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QueryResult search(Query query, int pageNo, int pageSize) {
		IndexSearcher indexSearcher = null;
		String indexPath = this.getClass().getClassLoader().getResource("").toString().replace("WEB-INF/classes/", "").replace("file:/", "");
		indexPath = indexPath + "indexPath";
		//String indexPath = "E:\\luceneIndex";
		Analyzer analyzer = new IKAnalyzer();// 词库分词
		try {
			// 2，进行查询
			IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
			indexSearcher = new IndexSearcher(reader);
			//Filter filter = FieldCacheRangeFilter.newIntRange("size", 200 ,1000, true, true);

			// ==========排序
			//Sort sort = new Sort();
			//sort.setSort(new SortField("size", SortField.DOUBLE)); // 默认为升序
			// sort.setSort(new SortField("size", true));
			// ==========

			TopDocs topDocs = indexSearcher.search(query, 10);

			int recordCount = topDocs.totalHits;
			List<Document> recordList = new ArrayList<Document>();

			// ============== 准备高亮器
			Formatter formatter_title = new SimpleHTMLFormatter("<font color='red'>", "</font>");
			Formatter formatter_descr = new SimpleHTMLFormatter("<font color='green'>", "</font>");
			Scorer scorer = new QueryScorer(query);
			Highlighter highlighter_title = new Highlighter(formatter_title, scorer);
			Highlighter highlighter_descr = new Highlighter(formatter_descr, scorer);

			Fragmenter fragmenter = new SimpleFragmenter(50);
			highlighter_title.setTextFragmenter(fragmenter);
			highlighter_descr.setTextFragmenter(fragmenter);
			// ==============

			// 3，取出当前页的数据
			//计算起始记录号、结束记录号
			int startNo = pageSize * (pageNo - 1);
			int end = Math.min(startNo + pageSize, topDocs.totalHits);
			
			for (int i = startNo; i < end; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];

				int docSn = scoreDoc.doc; // 文档内部编号
				Document doc = indexSearcher.doc(docSn); // 根据编号取出相应的文档

				// =========== 高亮
				//  返回高亮后的结果，如果当前属性值中没有出现关键字，会返回 null
				String ht = highlighter_title.getBestFragment(analyzer, "title", doc.get("title"));
				if (ht == null) {
					String title = doc.getValues("title")[0];
					int endIndex = Math.min(50, title.length());
					ht = title.substring(0, endIndex);// 最多前50个字符
				}
				doc.getField("title").setValue(ht);
				String hd = highlighter_descr.getBestFragment(analyzer, "descr", doc.get("descr"));
				if (hd == null) {
					String title = doc.getValues("descr")[0];
					int endIndex = Math.min(100, title.length());
					hd = title.substring(0, endIndex);// 最多前50个字符
				}
				doc.getField("descr").setValue(hd);
				// ===========

				recordList.add(doc);
			}

			// 返回结果
			return new QueryResult(recordCount, recordList);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				indexSearcher.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
