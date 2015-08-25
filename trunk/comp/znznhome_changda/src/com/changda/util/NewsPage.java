package com.changda.util;

import java.util.List;

public class NewsPage {
	
	private int pageNo; //当前页码
	private int totalPages; //总页数
	private String content;  //当前页的内容
	private String htmlfilename; //静态页面名称，多页的新闻，只保存一个静态页面名称，其它页面用该名称与页码的组合构成。
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHtmlfilename() {
		return htmlfilename;
	}
	public void setHtmlfilename(String htmlfilename) {
		this.htmlfilename = htmlfilename;
	}

}
