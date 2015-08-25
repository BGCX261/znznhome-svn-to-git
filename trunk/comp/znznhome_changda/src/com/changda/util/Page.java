package com.changda.util;

import java.util.List;

public class Page {
	
	private String sql;  //查询条件
	private int startNo; //开始记录数
	private int pageSize; //页面大小
	private int totalRecords;  //记录总数
	private int pageNo; //页码
	private int totalPages; //总页数
	private String sql_count; //用于统计记录数的sql语句
	private List list;  //结果集
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
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
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getSql_count() {
		return sql_count;
	}
	public void setSql_count(String sql_count) {
		this.sql_count = sql_count;
	}
	
}
