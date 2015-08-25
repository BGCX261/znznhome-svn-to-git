package com.changda.action;

import java.sql.Timestamp;
import java.util.Map;

import com.changda.model.Job;
import com.changda.model.News;
import com.changda.service.JobManager;
import com.changda.util.Page;
import com.changda.util.SearchMgr;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {
	
	private String position;
	private String field;
	private String location;
	private String totalnumber;
	private String daytime;
	private String intro;
	private int stateflag;
	
	//countNumber 用于接收列表数量，如果不传，则设为6
	private int countNumber;
	
	//ID
	private int jobID;
	
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
	
	//JobManager
	private JobManager jobManager = JobManager.getInstance();
	
	public String add() {
		Job job = new Job();
		job.setDaytime(daytime);
		job.setField(field);
		job.setIntro(intro);
		job.setLocation(location);
		job.setPosition(position);
		job.setStateflag(1);
		job.setTotalnumber(totalnumber);
		boolean b = jobManager.save(job);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = jobManager.delete(jobID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Job job = jobManager.loadByID(jobID);
		job.setDaytime(daytime);
		job.setField(field);
		job.setIntro(intro);
		job.setLocation(location);
		job.setPosition(position);
		job.setStateflag(1);
		job.setTotalnumber(totalnumber);
		boolean ok = jobManager.update(job);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String list() {
		
		if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Job().getClass();
			page = SearchMgr.search(pageNo, c, 5);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from job";
			sql = "select * from job order by createtime desc";
			Class c = new Job().getClass();
			page = SearchMgr.search(sql_count, sql, c, 5);
			return SUCCESS;
		}	
		
	}

	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from job where 1=1 ";
			sql = "select * from job where 1=1 ";
			Class c = new Job().getClass();
			page = SearchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Job().getClass();
			page = SearchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from job ";
			sql = "select * from job order by createtime desc";
			Class c = new Job().getClass();
			page = SearchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	
		
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTotalnumber() {
		return totalnumber;
	}

	public void setTotalnumber(String totalnumber) {
		this.totalnumber = totalnumber;
	}

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getStateflag() {
		return stateflag;
	}

	public void setStateflag(int stateflag) {
		this.stateflag = stateflag;
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
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

