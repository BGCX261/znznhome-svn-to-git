package com.znznhome.action;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.ChatMessage;
import com.znznhome.model.Message;
import com.znznhome.service.ChatMessageManager;
import com.znznhome.service.MessageManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport {
	
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	//addMessage
	private int mbid;
	private String mbname;
	private int categoryid;
	private String province;
	private String city;
	private String district;
	private String title;
	private String contact;
	private String keywords;
	private String content;
	private String ip;
	private int passflag;
	private int recflag;
	
	//ID
	private int messageID;
	
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
	
	private MessageManager messageManager;
	
	public MessageManager getMessageManager() {
		return messageManager;
	}

	@Resource(name="messageManager")
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	public String add() {
		
		Message message = new Message();
		
		message.setCategoryid(categoryid);
		message.setCity(city);
		message.setContact(contact);
		message.setContent(content);
		message.setDistrict(district);
		message.setIp(ip);
		message.setKeywords(keywords);
		message.setMbid(mbid);
		message.setMbname(mbname);
		message.setPassflag(passflag);
		message.setProvince(province);
		message.setRecflag(recflag);
		message.setTitle(title);

		boolean b = messageManager.save(message);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = messageManager.delete(messageID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		Message message = messageManager.loadByID(messageID);
		
		message.setCategoryid(categoryid);
		message.setCity(city);
		message.setContact(contact);
		message.setContent(content);
		message.setDistrict(district);
		message.setIp(ip);
		message.setKeywords(keywords);
		message.setMbid(mbid);
		message.setMbname(mbname);
		message.setPassflag(passflag);
		message.setProvince(province);
		message.setRecflag(recflag);
		message.setTitle(title);
		
		boolean ok = messageManager.update(message);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		/*if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_message where 1=1 ";
			sql = "select * from znzn_message where 1=1 ";
			Class c = new Message().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Message().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_message ";
			sql = "select * from znzn_message order by createtime desc";
			Class c = new Message().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	*/
		return SUCCESS;
	}
	
	//Getters and Setters
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

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getRecflag() {
		return recflag;
	}

	public void setRecflag(int recflag) {
		this.recflag = recflag;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
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
