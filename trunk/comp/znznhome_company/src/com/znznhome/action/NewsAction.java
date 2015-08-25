package com.znznhome.action;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.News;
import com.znznhome.service.NewsManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("newsAction")
@Scope("prototype")
public class NewsAction extends ActionSupport {
	
	private static final long serialVersionUID = 7190139324153413255L;
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	private int categoryid;
	private String picurl;
	private String categoryname;
	private String title;
	private String content;
	private Timestamp createtime;
	private Timestamp updatetime;
	private String author;
	private String origin;
	private String seotitle;
	private String seokeywords;
	private String seodescription;
	private int topscore;
	private int recflag;
	
	//countNumber 用于接收列表数量，如果不传，则设为6
	private int countNumber;
	
	//ID
	private int newsID;
	
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
	
	//NewsManager
	private NewsManager newsManager;
	@Resource(name="newsManager")
	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
	}

	public String add() {
		News news = new News();

		news.setAuthor(author);
		news.setContent(content);
		news.setOrigin(origin);
		
		news.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		news.setCategoryname(categoryname);
		news.setContent(content);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String picurl = (String)session.get("picurl");
		session.remove("picurl");
		
		news.setPicurl(picurl);
		news.setTopscore(topscore);
		news.setTitle(title);
		news.setSeotitle(seotitle);
		news.setSeodescription(seodescription);
		news.setSeokeywords(seokeywords);
		news.setRecflag(recflag);
		

		boolean b = newsManager.save(news);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = newsManager.delete(newsID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		News news = newsManager.loadByID(newsID);

		news.setAuthor(author);
		news.setContent(content);
		news.setOrigin(origin);
		news.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入news中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		news.setCategoryname(categoryname);
		news.setContent(content);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		//新上传图片就用新的，否则就用老的
		String picurl = (session.get("picurl") == null || session.get("picurl" ) == "" ) ? (String)session.get("picurl_md") : (String)session.get("picurl");
		session.remove("picurl");
		session.remove("picurl_md");
		
		news.setPicurl(picurl);
		news.setTopscore(topscore);
		news.setTitle(title);
		news.setSeotitle(seotitle);
		news.setSeodescription(seodescription);
		news.setSeokeywords(seokeywords);
		news.setRecflag(recflag);

		boolean ok = newsManager.update(news);
		
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
			Class c = new News().getClass();
			page = searchMgr.search(pageNo, c, countNumber);
			System.out.println("debug1");
			return SUCCESS;
			
		} else {
			if(countNumber == 0) countNumber = 6;
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_news where recflag=1 and categoryid=" + categoryid;
			sql = "select * from znzn_news where recflag=1 and categoryid=" + categoryid + " order by createtime desc";
			Class c = new News().getClass();
			page = searchMgr.search(sql_count, sql, c, countNumber);
			System.out.println("debug2");
			return SUCCESS;
		}	
				
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_news where 1=1 ";
			sql = "select * from znzn_news where 1=1 ";
			Class c = new News().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new News().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_news ";
			sql = "select * from znzn_news order by createtime desc";
			Class c = new News().getClass();
			page = searchMgr.search(sql_count, sql, c);
			return SUCCESS;
		}	
		
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
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

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
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

	public int getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}

}

