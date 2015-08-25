package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Url;
import com.znznhome.service.CategoryManager;
import com.znznhome.service.UrlManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;

/**
 * @Description
 * @author xiudong.li
 * @contact qq:1067811307
 * @date 2012-8-12 下午4:26:15
 * @version V1.0
 */

@Component("urlAction")
@Scope("prototype")
public class UrlAction extends ActionSupport {

	private static final long serialVersionUID = -429725259616716914L;
	private SearchMgr searchMgr;

	@Resource(name = "searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	

	// 增加URL
	private String title;
	private String descr;
	private String urladdress;
	private int categoryid;
	private String categoryname;
	private String categoryename = ""; // 暂时在action中自己获取
	private String origin;
	private int recflag;

	// ID
	private int urlID;

	// 查询与分页
	private Page page;
	private String sql;
	private String sql_count;
	private int startNo;
	private int pageSize;
	private int totalRecords;
	private String pageNo;
	private int totalPages;

	// 用来区分查询提交过来的还是菜单链接过来的
	private String action_search;
	// 查询条件
	private String search_content;
	private String search_condition;

	// UrlManager
	private UrlManager urlManager;

	@Resource(name = "urlManager")
	public void setUrlManager(UrlManager urlManager) {
		this.urlManager = urlManager;
	}

	private CategoryManager categoryManager;

	@Resource(name = "categoryManager")
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	public String add() {
		Url url = new Url();
		url.setCategoryid(categoryid);
		url.setDescr(descr);
		url.setRecflag(recflag);
		url.setTitle(title);
		url.setUrladdress(urladdress);
		categoryname = categoryManager.getEnameByID(categoryid);
		url.setCategoryename(categoryename);
		url.setOrigin(origin);
		// 下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----") == -1 ? -5 : (categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index + 5);
		url.setCategoryname(categoryname);

		boolean b = urlManager.save(url);
		if (true == b) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String delete() {

		boolean ok = urlManager.delete(urlID);

		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String modify() {
		Url url = urlManager.loadByID(urlID);
		System.out.println("urlID:" + urlID);
		url.setCategoryid(categoryid);
		url.setDescr(descr);
		url.setRecflag(recflag);
		url.setTitle(title);
		url.setUrladdress(urladdress);
		url.setOrigin(origin);
		categoryname = categoryManager.getEnameByID(categoryid);
		url.setCategoryename(categoryename);
		// 下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----") == -1 ? -5 : (categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index + 5);
		url.setCategoryname(categoryname);
		boolean ok = urlManager.update(url);

		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String manager() {

		if (action_search != null && action_search.equals("action_search")) {
			// 通过查询进入
			sql_count = "select count(*) from znzn_url where 1=1 ";
			sql = "select * from znzn_url where 1=1 ";
			Class c = new Url().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;

		} else if (pageNo != null && !pageNo.trim().equals("")) {
			// 处理直接点击和查询的分页问题
			Class c = new Url().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;

		} else {
			// 直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_url ";
			sql = "select * from znzn_url order by createtime desc";
			Class c = new Url().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}

	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getUrladdress() {
		return urladdress;
	}

	public void setUrladdress(String urladdress) {
		this.urladdress = urladdress;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
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

	public int getUrlID() {
		return urlID;
	}

	public void setUrlID(int urlID) {
		this.urlID = urlID;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryename() {
		return categoryename;
	}

	public void setCategoryename(String categoryename) {
		this.categoryename = categoryename;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
