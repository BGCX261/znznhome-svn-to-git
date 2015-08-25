package com.changda.action;

import java.sql.Timestamp;
import java.util.Map;

import com.changda.model.Cases;
import com.changda.model.News;
import com.changda.service.CasesManager;
import com.changda.util.Page;
import com.changda.util.SearchMgr;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CasesAction extends ActionSupport {
	
	private int categoryid;
	private String categoryname;
	private String title;
	private String picurl;
	private String content;
	private Timestamp createtime;
	private Timestamp updatetime;
	private String seotitle;
	private String seokeywords;
	private String seodescription;
	private int topscore;
	private int recflag;
	private String casename;
	private String scale;
	private String location;
	private String casetime;
	
	//countNumber 用于接收列表数量，如果不传，则设为6
	private int countNumber;
	
	//ID
	private int casesID;
	
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
	
	//CasesManager
	private CasesManager casesManager = CasesManager.getInstance();
	
	public String add() {
		Cases cases = new Cases();

		cases.setCasename(casename);
		cases.setCasetime(casetime);
		cases.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		cases.setCategoryname(categoryname);
		cases.setContent(content);
		cases.setLocation(location);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String picurl = (String)session.get("picurl");
		session.remove("picurl");
		
		cases.setPicurl(picurl);
		cases.setTopscore(topscore);
		cases.setTitle(seotitle);
		cases.setSeotitle(seotitle);
		cases.setSeodescription(seodescription);
		cases.setSeokeywords(seokeywords);
		cases.setScale(scale);
		cases.setRecflag(recflag);
		

		boolean b = casesManager.save(cases);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = casesManager.delete(casesID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Cases cases = casesManager.loadByID(casesID);

		cases.setCasename(casename);
		cases.setCasetime(casetime);
		cases.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		cases.setCategoryname(categoryname);
		cases.setContent(content);
		cases.setLocation(location);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		//新上传图片就用新的，否则就用老的
		String picurl = (session.get("picurl") == null || session.get("picurl" ) == "" ) ? (String)session.get("picurl_md") : (String)session.get("picurl");
		session.remove("picurl");
		session.remove("picurl_md");
		
		cases.setPicurl(picurl);
		cases.setTopscore(topscore);
		cases.setTitle(seotitle);
		cases.setSeotitle(seotitle);
		cases.setSeodescription(seodescription);
		cases.setSeokeywords(seokeywords);
		cases.setScale(scale);
		cases.setRecflag(recflag);

		boolean ok = casesManager.update(cases);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String list() {
		if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			if(countNumber == 0) countNumber = 6;
			Class c = new Cases().getClass();
			page = SearchMgr.search(pageNo, c, countNumber);
			return SUCCESS;
			
		} else {
			if(countNumber == 0) countNumber = 6;
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from cases where recflag=1 and categoryid=" + categoryid;
			sql = "select * from cases where recflag=1 and categoryid=" + categoryid + " order by createtime desc";
			Class c = new Cases().getClass();
			page = SearchMgr.search(sql_count, sql, c, countNumber);
			return SUCCESS;
		}	
				
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from cases where 1=1 ";
			sql = "select * from cases where 1=1 ";
			Class c = new Cases().getClass();
			page = SearchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Cases().getClass();
			page = SearchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from cases ";
			sql = "select * from cases order by createtime desc";
			Class c = new Cases().getClass();
			page = SearchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	
		
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getSeotitle() {
		return seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeokeywords() {
		return seokeywords;
	}

	public void setSeokeywords(String seokeywords) {
		this.seokeywords = seokeywords;
	}

	public String getSeodescription() {
		return seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public int getTopscore() {
		return topscore;
	}

	public void setTopscore(int topscore) {
		this.topscore = topscore;
	}

	public int getRecflag() {
		return recflag;
	}

	public void setRecflag(int recflag) {
		this.recflag = recflag;
	}

	public String getCasename() {
		return casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCasetime() {
		return casetime;
	}

	public void setCasetime(String casetime) {
		this.casetime = casetime;
	}

	public int getCasesID() {
		return casesID;
	}

	public void setCasesID(int casesID) {
		this.casesID = casesID;
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

