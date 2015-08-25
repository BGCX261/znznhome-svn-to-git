package com.znznhome.util;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.znznhome.service.IndexManager;

@Component("searchMgr")
public class SearchMgr {
	
	private PageMgr pageMgr;
	
	@Resource(name="pageMgr")
	public void setPageMgr(PageMgr pageMgr) {
		this.pageMgr = pageMgr;
	}
	 
	/** 
	 * @Description 点击搜索按钮时
	 * @author xiudong.li
	 * @param query
	 * @param indexBean
	 * @param indexManager
	 * @return  
	 */
	  	
	public Page search(String query, IndexManager indexManager, String indexBean ) {
		
		int intPageNo = 1;
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("query");
		session.put("query", query);
		return pageMgr.getListForPage(query, indexBean, intPageNo, 10, indexManager);
	}
	
	 
	/** 
	 * @Description 点击结果分页时
	 * @author xiudong.li
	 * @param indexBean
	 * @param pageNo
	 * @param indexManager
	 * @return  
	 */
	  	
	public Page search(String indexBean, String pageNo, IndexManager indexManager) {
		
		int intPageNo = 1;
		try {
			intPageNo = Integer.parseInt(pageNo.trim());
		} catch (NumberFormatException e) {
			intPageNo = 1;
		}
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		//接受传入的查询条件
		String query = (String)session.get("query");
		return pageMgr.getListForPage(query, indexBean, intPageNo, 10, indexManager);
	}

	/** 
	 * @Description 后台条件查询的分页（从session中取带查询条件的sql）
	 * @author xiudong.li
	 * @param pageNo
	 * @param c
	 * @param pageSize
	 * @return  
	 */
	  	
	public Page search(String pageNo, Class c, int pageSize) {
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		//接受传入的查询条件
		String sql = (String)session.get("sql");
		String sql_count = (String)session.get("sql_count");
		
		//不能将pageNo作为int类型直接接收下来，否则无法做判断，因此作为字符串引入。
		//这里再声明一个变量，解析一下pageNo，并处理一下异常；
		int intPageNo = 0;

		try {
			intPageNo = Integer.parseInt(pageNo.trim());
		} catch (NumberFormatException e) {
			intPageNo = 1;
		}
		if (intPageNo <= 0){
				intPageNo = 1;
		}
		
		Page page = pageMgr.getListForPage(c, sql_count, sql, intPageNo, pageSize);
		
		return page;
	}
	
	/** 
	 * @Description 后台条件查询
	 * @author xiudong.li
	 * @param sqlCount
	 * @param sql
	 * @param c
	 * @param pageSize
	 * @return  
	 */
	  	
	public Page search(String sqlCount, String sql, Class c, int pageSize) {
		Page page = pageMgr.getListForPage(c, sqlCount, sql, 1, pageSize);
		
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("sql");
		session.remove("sql_count");
		session.put("sql", sql);
		session.put("sql_count", sqlCount);
		return page;
	}
	
	/** 
	 * @Description 前台显示（条件中带pageNo）**
	 * @author xiudong.li
	 * @param sqlCount
	 * @param sql
	 * @param pageNo_Str
	 * @param c
	 * @param pageSize
	 * @return  
	 */
	public Page search(String sqlCount, String sql, String pageNo_Str, Class c, int pageSize) {
		int pageNo = 0;
		try {
			pageNo = Integer.parseInt(pageNo_Str.trim());
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		if (pageNo <= 0){
				pageNo = 1;
		}
		
		Page page = pageMgr.getListForPage(c, sqlCount, sql, pageNo, pageSize);
		
		return page;
	}
	
}
