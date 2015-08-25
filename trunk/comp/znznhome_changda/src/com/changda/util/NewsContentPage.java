package com.changda.util;

public class NewsContentPage {
	private String pre_fileName;//静态文件名前部分
	private int pageNo;//当前页
	private int totalPages;//总共几页
	
	public String getPre_fileName() {
		return pre_fileName;
	}
	public void setPre_fileName(String pre_fileName) {
		this.pre_fileName = pre_fileName;
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
	
}
