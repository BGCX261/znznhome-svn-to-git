package com.changda.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class SearchMgr {
	
	public static Page search(String sql_count, String sql, String search_content, String search_condition, Class c) {
		
		//查询条件
		String condition = "";

		//构建查询条件
		if(search_content != null && !search_content.trim().equals("")) {
			condition = condition + " and " + search_condition + 
			" like '%" + search_content + "%'";
		}
		
		//为查询条件添加排序条件
		condition = condition + " order by createtime desc " ;
		int pageSize = 10;
		
		//给sql语句加上查询条件
		sql_count = sql_count + condition;
		sql = sql + condition;
		Page page = PageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
		
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("sql");
		session.remove("sql_count");
		session.put("sql", sql);
		session.put("sql_count", sql_count);
		return page;
	}
	
	//带pageSize
	public static Page search(String sql_count, String sql, String search_content, String search_condition, Class c, int pageSize) {
		
		//查询条件
		String condition = "";

		//构建查询条件
		if(search_content != null && !search_content.trim().equals("")) {
			condition = condition + " and " + search_condition + 
			" like '%" + search_content + "%'";
		}
		
		//为查询条件添加排序条件
		condition = condition + " order by createtime desc " ;
		
		//给sql语句加上查询条件
		sql_count = sql_count + condition;
		sql = sql + condition;
		Page page = PageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
		
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("sql");
		session.remove("sql_count");
		session.put("sql", sql);
		session.put("sql_count", sql_count);
		return page;
	}
	
	public static Page search(String pageNo, Class c) {
		
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
		
		int pageSize = 10;
		Page page = PageMgr.getListForPage(c, sql_count, sql, intPageNo, pageSize);
		
		return page;
	}
	
	//带pageSize
	public static Page search(String pageNo, Class c, int pageSize) {
		
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
		
		Page page = PageMgr.getListForPage(c, sql_count, sql, intPageNo, pageSize);
		
		return page;
	}
	
	public static Page search(String sql_count, String sql,  Class c) {
		
		//直接点击信息维护时显示的页面；
		int pageSize = 10;
		Page page = PageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
		
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("sql");
		session.remove("sql_count");
		session.put("sql", sql);
		session.put("sql_count", sql_count);
		
		return page;
	}
	
	public static Page search(String sql_count, String sql,  Class c, int pageSize) {
		
		//直接点击信息维护时显示的页面；
		Page page = PageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
		
		//查询条件存入session
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("sql");
		session.remove("sql_count");
		session.put("sql", sql);
		session.put("sql_count", sql_count);
		
		return page;
	}
}
