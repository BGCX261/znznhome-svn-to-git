package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.ChatMessage;
import com.znznhome.model.Url;
import com.znznhome.service.ChatMessageManager;
import com.znznhome.util.CommonUtil;
import com.znznhome.util.Constant;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("chatMessageAction")
@Scope("prototype")
public class ChatMessageAction extends ActionSupport {
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	//addChatMessage
	private int categoryid;
	private int mbid;
	private String mbname;
	private int mbphotono;
	private String title;
	private String content;
	private String contact;
	private String ip;
	private int passflag;
	private String other;

	//ID
	private int chatMessageID;
	
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
	
	//ChatMessageManager
	private ChatMessageManager chatMessageManager;
	
	public ChatMessageManager getChatMessageManager() {
		return chatMessageManager;
	}

	@Resource(name="chatMessageManager")
	public void setChatMessageManager(ChatMessageManager chatMessageManager) {
		this.chatMessageManager = chatMessageManager;
	}

	public String add() {
		
		ChatMessage chatMessage = new ChatMessage();
		
		chatMessage.setCategoryid(categoryid);
		chatMessage.setContact(contact);
		chatMessage.setContent(content);
		chatMessage.setIp(ip);
		chatMessage.setMbid(mbid);
		chatMessage.setMbname(mbname);
		chatMessage.setMbphotono(mbphotono);
		chatMessage.setOther(other);
		chatMessage.setPassflag(passflag);
		chatMessage.setTitle(title);

		boolean b = chatMessageManager.save(chatMessage);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = chatMessageManager.delete(chatMessageID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		ChatMessage chatMessage = chatMessageManager.loadByID(chatMessageID);
		
		chatMessage.setCategoryid(categoryid);
		chatMessage.setContact(contact);
		chatMessage.setContent(content);
		chatMessage.setIp(ip);
		chatMessage.setMbid(mbid);
		chatMessage.setMbname(mbname);
		chatMessage.setMbphotono(mbphotono);
		chatMessage.setOther(other);
		chatMessage.setPassflag(passflag);
		chatMessage.setTitle(title);
		boolean ok = chatMessageManager.update(chatMessage);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		String sqlOrigin = "select * from znzn_chatmessage";
		String sqlCountOrigin = "select count(*) from znzn_chatmessage";
		// 通过查询进入
		sql = CommonUtil.getSQL(sqlOrigin, search_content, search_condition, "createtime");
		sql_count = CommonUtil.getSQLCount(sqlCountOrigin, search_content, search_condition);
		
		if(pageSize == 0) pageSize = Constant.PAGESIZE_BG;
		Class c = new ChatMessage().getClass();
		
		if (CommonUtil.isEmpty(pageNo)) {
			//直接点击/搜索点击，均走session
			page = searchMgr.search(sql_count, sql, c, pageSize);
			return SUCCESS;
		} else {
			//直接点击和查询的分页问题(从session中取带查询条件的sql)
			page = searchMgr.search(pageNo, c, pageSize);
			return SUCCESS;
		}
		
	}

	//Setters and Getters
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getMbid() {
		return mbid;
	}

	public void setMbid(int mbid) {
		this.mbid = mbid;
	}

	public String getMbname() {
		return mbname;
	}

	public void setMbname(String mbname) {
		this.mbname = mbname;
	}

	public int getMbphotono() {
		return mbphotono;
	}

	public void setMbphotono(int mbphotono) {
		this.mbphotono = mbphotono;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPassflag() {
		return passflag;
	}

	public void setPassflag(int passflag) {
		this.passflag = passflag;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getChatMessageID() {
		return chatMessageID;
	}

	public void setChatMessageID(int chatMessageID) {
		this.chatMessageID = chatMessageID;
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
