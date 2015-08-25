package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.springframework.stereotype.Component;

import com.znznhome.dao.IndexDAO;
import com.znznhome.enums.IndexBean;
import com.znznhome.lucene.QueryResult;

@Component("indexManager")
public class IndexManager {
	
	private IndexDAO indexDAO;
	@Resource(name="indexDAO")
	public void setIndexDAO(IndexDAO indexDAO) {
		this.indexDAO = indexDAO;
	}
	
	public boolean createIndex(String sql, Class c, IndexBean type) {
		boolean b = false;
		try {
			b = indexDAO.createIndex(sql, c, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean save(Document doc, IndexWriter indexWriter){
		return indexDAO.save(doc, indexWriter);
	}
	public boolean delete(Term term){
		return indexDAO.delete(term);
	}
	public boolean update(Term term, Document doc){
		return indexDAO.update(term, doc);
	}
	public QueryResult search(String queryString, int firstResult, int maxResults){
		return indexDAO.search(queryString, firstResult, maxResults);
	}
}
