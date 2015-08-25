package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Category;
import com.znznhome.model.ChatMessageKeywords;
import com.znznhome.service.ChatMessageKeywordsManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("chatMessageKeywordsAction")
@Scope("prototype")
public class ChatMessageKeywordsAction extends ActionSupport {
	
//	id int primary key not null auto_increment,
//	keywords varchar(255), #关键词 作为搜索条件
//	createtime timestamp default now(), #默认按时间排序
//	grade int, #代表关键词等级，等级越高，越往前排，先设三级 0, 1, 2
//	recflag int, #是否推荐到列表 0,不推荐 ， 1,推荐加“精” 2,推荐变红色 3,推荐变绿色
//	other varchar(20) #备用
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	private String keywords;
	private String other;
	private int grade;
	private int recflag;
	
	//ID
	private int chatMessageKeywordsID;
	
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

	//ChatMessageKeywordsManager
	private ChatMessageKeywordsManager chatMessageKeywordsManager;
	
	public ChatMessageKeywordsManager getChatMessageKeywordsManager() {
		return chatMessageKeywordsManager;
	}

	@Resource(name="chatMessageKeywordsManager")
	public void setChatMessageKeywordsManager(
			ChatMessageKeywordsManager chatMessageKeywordsManager) {
		this.chatMessageKeywordsManager = chatMessageKeywordsManager;
	}

	public String add() {
		ChatMessageKeywords chatMessageKeywords = new ChatMessageKeywords();
		chatMessageKeywords.setGrade(grade);
		chatMessageKeywords.setKeywords(keywords);
		chatMessageKeywords.setRecflag(recflag);
		chatMessageKeywords.setOther(other);
		boolean b = chatMessageKeywordsManager.save(chatMessageKeywords);
		if(true == b) return SUCCESS;
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = chatMessageKeywordsManager.delete(chatMessageKeywordsID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		ChatMessageKeywords chatMessageKeywords = chatMessageKeywordsManager.loadByID(chatMessageKeywordsID);
		chatMessageKeywords.setGrade(grade);
		chatMessageKeywords.setKeywords(keywords);
		chatMessageKeywords.setRecflag(recflag);
		chatMessageKeywords.setOther(other);
		boolean ok = chatMessageKeywordsManager.update(chatMessageKeywords);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		/*if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_chatmessage_keywords where 1=1 ";
			sql = "select * from znzn_chatmessage_keywords where 1=1 ";
			Class c = new ChatMessageKeywords().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new ChatMessageKeywords().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_chatmessage_keywords ";
			sql = "select * from znzn_chatmessage_keywords order by createtime desc";
			Class c = new ChatMessageKeywords().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	*/
		return SUCCESS;
	}

	//Getters and Setters
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getRecflag() {
		return recflag;
	}

	public void setRecflag(int recflag) {
		this.recflag = recflag;
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

	public int getChatMessageKeywordsID() {
		return chatMessageKeywordsID;
	}

	public void setChatMessageKeywordsID(int chatMessageKeywordsID) {
		this.chatMessageKeywordsID = chatMessageKeywordsID;
	}

}
