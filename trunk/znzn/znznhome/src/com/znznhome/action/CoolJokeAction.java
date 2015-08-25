package com.znznhome.action;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.ChatMessageKeywords;
import com.znznhome.model.CoolJoke;
import com.znznhome.model.Url;
import com.znznhome.service.CoolJokeManager;
import com.znznhome.service.UrlManager;
import com.znznhome.util.Page;
import com.znznhome.util.PageMgr;
import com.znznhome.util.SearchMgr;
@Component("coolJokeAction")
@Scope("prototype")
public class CoolJokeAction extends ActionSupport {
	
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	private int categoryid;
	private int mbid;
	private String mbname;
	private String title;
	private String content;
	private String ip;
	//private Timestamp createtime;
	private int passflag;
	private int recflag;
	private String other;
	
	//ID
	private int coolJokeID;
	
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
	
	//CoolJokeManager
	private CoolJokeManager coolJokeManager;
	
	public CoolJokeManager getCoolJokeManager() {
		return coolJokeManager;
	}

	@Resource(name="coolJokeManager")
	public void setCoolJokeManager(CoolJokeManager coolJokeManager) {
		this.coolJokeManager = coolJokeManager;
	}

	public String add() {
		CoolJoke coolJoke = new CoolJoke();
		coolJoke.setCategoryid(categoryid);
		coolJoke.setMbid(mbid);
		coolJoke.setContent(content);
		coolJoke.setIp(ip);
		coolJoke.setMbname(mbname);
		coolJoke.setOther(other);
		coolJoke.setTitle(title);
		coolJoke.setRecflag(recflag);
		coolJoke.setPassflag(passflag);
		boolean b = coolJokeManager.save(coolJoke);
		if(true == b) return SUCCESS;
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = coolJokeManager.delete(coolJokeID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		CoolJoke coolJoke = coolJokeManager.loadByID(coolJokeID);
		
		coolJoke.setCategoryid(categoryid);
		coolJoke.setMbid(mbid);
		coolJoke.setContent(content);
		coolJoke.setIp(ip);
		coolJoke.setMbname(mbname);
		coolJoke.setOther(other);
		coolJoke.setTitle(title);
		coolJoke.setRecflag(recflag);
		coolJoke.setPassflag(passflag);

		boolean ok = coolJokeManager.update(coolJoke);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		
		/*if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_cooljoke where 1=1 ";
			sql = "select * from znzn_cooljoke where 1=1 ";
			Class c = new CoolJoke().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new CoolJoke().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_cooljoke ";
			sql = "select * from znzn_cooljoke order by createtime desc";
			Class c = new CoolJoke().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	*/
		return SUCCESS;
	}

	//Getters and Setters
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

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getCoolJokeID() {
		return coolJokeID;
	}

	public void setCoolJokeID(int coolJokeID) {
		this.coolJokeID = coolJokeID;
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
