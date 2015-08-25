package com.znznhome.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.MessageDefault;
import com.znznhome.service.MessageDefaultManager;
import com.znznhome.service.MessageDefaultManager;
import com.znznhome.util.Page;
import com.znznhome.util.PageMgr;
@Component("messageDefaultAction")
@Scope("prototype")
public class MessageDefaultAction extends ActionSupport {
	
	private PageMgr pageMgr;
	
	@Resource(name="pageMgr")
	public void setpageMgr(PageMgr pageMgr) {
		this.pageMgr = pageMgr;
	}
	private int categoryid;
	private String name;
	private String content;
	private String other;
	
	//ID
	private int messageDefaultID;
	
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
	
	//MessageDefaultManager
	private MessageDefaultManager messageDefaultManager;
	
	public MessageDefaultManager getMessageDefaultManager() {
		return messageDefaultManager;
	}

	@Resource(name="messageDefaultManager")
	public void setMessageDefaultManager(MessageDefaultManager messageDefaultManager) {
		this.messageDefaultManager = messageDefaultManager;
	}

	public String add() {
		
		MessageDefault messageDefault = new MessageDefault();

		messageDefault.setCategoryid(categoryid);
		messageDefault.setContent(content);
		messageDefault.setName(name);
		messageDefault.setOther(other);
		
		boolean b = messageDefaultManager.save(messageDefault);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = messageDefaultManager.delete(messageDefaultID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		MessageDefault messageDefault = messageDefaultManager.loadByID(messageDefaultID);
		
		messageDefault.setCategoryid(categoryid);
		messageDefault.setContent(content);
		messageDefault.setName(name);
		messageDefault.setOther(other);
		
		boolean ok = messageDefaultManager.update(messageDefault);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {

			sql_count = "select count(*) from znzn_message_default where 1=1 ";
			sql = "select * from znzn_message_default where 1=1 ";
			
			//查询条件
			String condition = "";

			//构建查询条件
			if(search_content != null && !search_content.trim().equals("")) {
				condition = condition + " and " + search_condition + 
				" like '%" + search_content + "%'";
			}
			
			//为查询条件添加排序条件
			//condition = condition + " order by createtime desc " ;
			int pageSize = 10;
			Class c = new MessageDefault().getClass();
			
			//给sql语句加上查询条件
			sql_count = sql_count + condition;
			sql = sql + condition;
			page = pageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
			
			//查询条件存入session
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.remove("sql");
			session.remove("sql_count");
			session.put("sql", sql);
			session.put("sql_count", sql_count);
			
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			
			//接受传入的查询条件
			sql = (String)session.get("sql");
			sql_count = (String)session.get("sql_count");
			
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
			Class c = new MessageDefault().getClass();
			page = pageMgr.getListForPage(c, sql_count, sql, intPageNo, pageSize);
			
			return SUCCESS;
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_message_default ";
			sql = "select * from znzn_message_default ";

			int pageSize = 10;
			Class c = new MessageDefault().getClass();
			page = pageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
			
			//查询条件存入session
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.remove("sql");
			session.remove("sql_count");
			session.put("sql", sql);
			session.put("sql_count", sql_count);
			
			return SUCCESS;
		}	
	}

	//Getters and Setters
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getMessageDefaultID() {
		return messageDefaultID;
	}

	public void setMessageDefaultID(int messageDefaultID) {
		this.messageDefaultID = messageDefaultID;
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
