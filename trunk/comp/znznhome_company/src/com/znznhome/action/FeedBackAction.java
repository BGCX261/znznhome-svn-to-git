package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.FeedBack;
import com.znznhome.service.FeedBackManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("feedBackAction")
@Scope("prototype")
public class FeedBackAction extends ActionSupport {
	
	private static final long serialVersionUID = -6447002386975983808L;

	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	//增加FeedBack
	private String content;
	
	//ID
	private int feedBackID;
	
	//查询与分页
	private Page page;
	private String sql;
	private String sql_count;
	private int startNo;
	private int pageSize;
	private int totalRecords;
	private String pageNo;
	private int totalPages;
	
	//用来区分查询提交过来的还是菜单链接过来的
	private String action_search;
	//查询条件
	private String search_content;
	private String search_condition;
	
	//FeedBackManager
	private FeedBackManager feedBackManager;

	@Resource(name="feedBackManager")
	public void setFeedBackManager(FeedBackManager feedBackManager) {
		this.feedBackManager = feedBackManager;
	}

	public String add() {
		FeedBack feedBack = new FeedBack();
		feedBack.setContent(content);
		boolean b = feedBackManager.save(feedBack);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = feedBackManager.delete(feedBackID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		FeedBack feedBack = feedBackManager.loadByID(feedBackID);
		feedBack.setContent(content);
		boolean ok = feedBackManager.update(feedBack);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_feedback where 1=1 ";
			sql = "select * from znzn_feedback where 1=1 ";
			Class c = new FeedBack().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new FeedBack().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_feedback ";
			sql = "select * from znzn_feedback order by createtime desc";
			Class c = new FeedBack().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	
		
	}

	//Getters and Setters
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFeedBackID() {
		return feedBackID;
	}

	public void setFeedBackID(int feedBackID) {
		this.feedBackID = feedBackID;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getSql_count() {
		return sql_count;
	}

	public void setSql_count(String sql_count) {
		this.sql_count = sql_count;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getAction_search() {
		return action_search;
	}

	public void setAction_search(String action_search) {
		this.action_search = action_search;
	}

	public String getSearch_content() {
		return search_content;
	}

	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}

	public String getSearch_condition() {
		return search_condition;
	}

	public void setSearch_condition(String search_condition) {
		this.search_condition = search_condition;
	}
	
}
