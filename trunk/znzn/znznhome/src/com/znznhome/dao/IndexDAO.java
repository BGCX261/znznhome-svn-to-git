package com.znznhome.dao;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;

import com.znznhome.enums.IndexBean;
import com.znznhome.lucene.QueryResult;

public interface IndexDAO {
	
	boolean createIndex(String sql, Class c, IndexBean type) throws Exception ;
	boolean save(Document doc, IndexWriter indexWriter);
	boolean delete(Term term);
	boolean update(Term term, Document doc);
	QueryResult search(String queryString, int firstResult, int maxResults);
	QueryResult search(Query query, int pageNo, int pageSize);
}
