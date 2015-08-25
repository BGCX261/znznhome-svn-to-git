package com.znznhome.util;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.znznhome.lucene.QueryResult;
import com.znznhome.service.IndexManager;

@Component("pageMgr")
public class PageMgr {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	 
	/** 
	 * @Description 按查询条件获取记录列表
	 * @author xiudong.li
	 * @param c
	 * @param sql_count
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return  
	 */
	public Page getListForPage(Class c, String sql_count, String sql, int pageNo,
			int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		//计算记录总数
		SQLQuery q = session.createSQLQuery(sql_count);
		int totalRecords = ((BigInteger)q.list().get(0)).intValue();
		//计算总页数
		int totalPages = totalRecords % pageSize == 0 ? totalRecords
				/ pageSize : totalRecords / pageSize + 1;
		if(totalPages == 0) totalPages = 1;
		if (pageNo > totalPages) pageNo = totalPages;
		
		//计算起始记录号、结束记录号
		int startNo = pageSize * (pageNo - 1);
		int endNo = pageNo >= totalPages ? totalRecords : (pageSize*pageNo); 
		
		//生成记录数
		List list = session.createSQLQuery(sql).addEntity(c).setFirstResult(startNo).setMaxResults(pageSize).list();

		//数据存入Page，返回给用户
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setTotalRecords(totalRecords);
		page.setList(list);
		page.setPageSize(pageSize);
		page.setSql(sql);
		page.setStartNo(startNo);
		page.setTotalPages(totalPages);
		page.setSql_count(sql_count);

		return page;
	}

	 
	/** 
	 * @Description 获取lucene搜索结果
	 * @author xiudong.li
	 * @param query
	 * @param indexBean
	 * @param pageNo
	 * @param pagesize
	 * @return  
	 */
	public Page getListForPage(String query, String indexBean, int pageNo, int pageSize, IndexManager indexManager) {
		
		QueryResult queryResult =  indexManager.search(query, pageNo, pageSize);
		
		
		//计算记录总数
		
		int totalRecords = queryResult.getRecordCount();
		
		//计算总页数
		int totalPages = totalRecords % pageSize == 0 ? totalRecords
				/ pageSize : totalRecords / pageSize + 1;
		if(totalPages == 0) totalPages = 1;
		if (pageNo > totalPages) pageNo = totalPages;
		
		//计算起始记录号、结束记录号
		int startNo = pageSize * (pageNo - 1);
		
		//lucene查询到的结果集
		List list = queryResult.getRecordList();

		//数据存入Page，返回给用户
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setTotalRecords(totalRecords);
		page.setList(list);
		page.setPageSize(pageSize);
		page.setStartNo(startNo);
		page.setTotalPages(totalPages);
		return page;
	}

}
