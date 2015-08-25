package com.changda.action;

import java.sql.Timestamp;
import java.util.Map;

import com.changda.model.Feedback;
import com.changda.service.FeedbackManager;
import com.changda.util.Page;
import com.changda.util.SearchMgr;
import com.opensymphony.xwork2.ActionSupport;

public class FeedbackAction extends ActionSupport {
	
	private String contactperson;
	private String company;
	private String tel;
	private String address;
	private String email;
	private String detail;
	private Timestamp createtime;
	private String subject;
	private String title;
	private String mobile;
	private String fax;
	private String province;
	private String city;
	private String district;
	private String postcode;
	
	//ID
	private int feedbackID;
	
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
	
	//FeedbackManager
	private FeedbackManager feedbackManager = FeedbackManager.getInstance();
	
	public String add() {
		Feedback feedback = new Feedback();

		feedback.setAddress(address);
		feedback.setCity(city);
		feedback.setCompany(company);
		feedback.setContactperson(contactperson);
		feedback.setDetail(detail);
		feedback.setDistrict(district);
		feedback.setEmail(email);
		feedback.setFax(fax);
		feedback.setTitle(title);
		feedback.setTel(tel);
		feedback.setSubject(subject);
		feedback.setProvince(province);
		feedback.setPostcode(postcode);
		feedback.setMobile(mobile);

		boolean b = feedbackManager.save(feedback);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = feedbackManager.delete(feedbackID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Feedback feedback = feedbackManager.loadByID(feedbackID);
		feedback.setAddress(address);
		feedback.setCity(city);
		feedback.setCompany(company);
		feedback.setContactperson(contactperson);
		feedback.setDetail(detail);
		feedback.setDistrict(district);
		feedback.setEmail(email);
		feedback.setFax(fax);
		feedback.setTitle(title);
		feedback.setTel(tel);
		feedback.setSubject(subject);
		feedback.setProvince(province);
		feedback.setPostcode(postcode);
		feedback.setMobile(mobile);

		boolean ok = feedbackManager.update(feedback);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	

	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from feedback where 1=1 ";
			sql = "select * from feedback where 1=1 ";
			Class c = new Feedback().getClass();
			page = SearchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Feedback().getClass();
			page = SearchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from feedback ";
			sql = "select * from feedback order by createtime desc";
			Class c = new Feedback().getClass();
			page = SearchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	
		
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
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

