
package com.znznhome.action;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Member;
import com.znznhome.model.Url;
import com.znznhome.service.CategoryManager;
import com.znznhome.service.UrlManager;
import com.znznhome.util.AjaxOutPrintUtil;
import com.znznhome.util.CommonUtil;
import com.znznhome.util.ConfigUtil;
import com.znznhome.util.Constant;
import com.znznhome.util.JsonUtil;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;

@Component("urlAction")
@Scope("prototype")
public class UrlAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -429725259616716914L;
	
	private SearchMgr searchMgr;

	@Resource(name = "searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	
	//直接获取request参数使用。用于接收过滤修改后的request参数
	private HttpServletRequest request;
	
	// 增加URL
	private String title;
	private String descr;
	private String urladdress;
	private int categoryid;
	private String idandname;
	private String categoryname;
	private String tags; //标签，4个字以内
	private int memberid; // 发布人id
	private String membername; // 发布人姓名
	//private String ipaddress; // 添加url人员的ip 自动获取
	private String origin;
	private int recflag;
	private long score; // 得分， 排名在前，但在recflag之后，暂时不启用
	private int topflag; // 置顶， 排名最前 可多个
	private int live; // 为0：不显示， 1：显示
	private long clickrate; // 点击率，每点击一次，click增1.
	private long up; // 顶多少次
	private long down; // 踩多少次
	// private Timestamp createtime;

	// ID
	private int urlID;
	//IDs 批量删除时，用于接收需要删除的urlID
	private String urlIDs;



	// 查询与分页
	private Page page;
	private String sql;
	private String sql_count;
	private int startNo;
	//pageSize 用于接收列表数量，如果不传，则设为6
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
		url.setRecflag(recflag);
		url.setDescr((String)request.getAttribute("descr"));
		url.setTitle((String)request.getAttribute("title"));
		url.setUrladdress(urladdress);
		url.setOrigin((String)request.getAttribute("origin"));
		
		//categoryid和categoryname从前台或后台一起传过来，然后拆分获取到；
		String[] id_name = idandname.trim().split("#");
		categoryid = Integer.parseInt(id_name[0]);
		categoryname = id_name[1];
		url.setCategoryid(categoryid);
		url.setCategoryname(categoryname);
		
		url.setClickrate(0); //ajax updata时设置
		url.setDown(0);//ajax updata时设置
		
		url.setLive(live);//开关量，前台添加从配置文件中获取，允许修改；后台可自主设置、默认1；
		
		//从session中获得member信息
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Object tmp = session.get("member");
		if(tmp != null){
			Member member = (Member)session.get("member");
			url.setMemberid(member.getId());
			url.setMembername(member.getName());
		}else {
			url.setMemberid(-1);
			url.setMembername("匿名");
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		
		url.setIpaddress(request.getRemoteAddr());
		url.setTags(tags);
		url.setScore(0);//ajax updata时设置
		url.setTopflag(topflag); //前台提交的默认为0，后台的可设置
		url.setUp(0);//ajax updata时设置

		boolean b = urlManager.save(url);
		if (true == b) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String addByAjax() {
		Url url = new Url();
		url.setDescr((String)request.getAttribute("descr"));
		url.setRecflag(0);
		url.setTitle((String)request.getAttribute("title"));
		url.setUrladdress(urladdress);
		url.setOrigin((String)request.getAttribute("origin"));
		
		//categoryid和categoryname从前台或后台一起传过来，然后拆分获取到；
		String[] id_name = idandname.trim().split("#");
		categoryid = Integer.parseInt(id_name[0]);
		categoryname = id_name[1];
		url.setCategoryid(categoryid);
		url.setCategoryname(categoryname);
		url.setTags(tags);
		
		url.setClickrate(0); //ajax updata时设置
		url.setDown(0);//ajax updata时设置
		url.setLive(Integer.parseInt(ConfigUtil.getParamsMap().get("live").toString()));//开关量，前台添加从配置文件中获取，允许修改；后台可自主设置、默认1；
		
		//从session中获得member信息
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Object tmp = session.get("member");
		if(tmp != null){
			Member member = (Member)session.get("member");
			url.setMemberid(member.getId());
			url.setMembername(member.getName());
		}else {
			url.setMemberid(-1);
			url.setMembername("匿名");
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		url.setIpaddress(request.getRemoteAddr());
		
		url.setScore(0);//ajax updata时设置
		url.setTopflag(0); //前台提交的默认为0，后台的可设置
		url.setUp(0);//ajax updata时设置

		boolean b = urlManager.save(url);
		if (true == b) {
			AjaxOutPrintUtil.print("alert('add success');");
		} else {
			AjaxOutPrintUtil.print("add fail");
		}
		return null;
	}
	
	public String modifyByAjax() {
		Url url = urlManager.loadByID(urlID);
		url.setDescr(descr);
		url.setTitle(title);
		url.setUrladdress(urladdress);
		url.setOrigin(origin);
		url.setTags(tags);
		//categoryid和categoryname从前台或后台一起传过来，然后拆分获取到；
		String[] id_name = idandname.trim().split("#");
		categoryid = Integer.parseInt(id_name[0]);
		categoryname = id_name[1];
		url.setCategoryid(categoryid);
		url.setCategoryname(categoryname);
		//从session中获得member信息
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Object tmp = session.get("member");
		if(tmp != null){
			Member member = (Member)session.get("member");
			url.setMemberid(member.getId());
			url.setMembername(member.getName());
		}else {
			url.setMemberid(-1);
			url.setMembername("匿名");
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		url.setIpaddress(request.getRemoteAddr());
		
		boolean ok = urlManager.update(url);

		if (true == ok) {
			AjaxOutPrintUtil.print("alert('modify success');");
		} else {
			AjaxOutPrintUtil.print("modify fail");
		}
		return null;
	}

	public String upByAjax() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		if(this.cookieCheck(request, response, "up") == false){
			return null;
		}
		
		Map map = new HashMap();
		Url url = urlManager.loadByID(urlID);
		url.setUp(url.getUp() + 1);
		boolean ok = urlManager.update(url);
		if (true == ok) {
			map.put("rstStr", "up success!");
			map.put("state", 1);
			map.put("count", url.getUp());
			map.put("urlID", urlID);
			map.put("method", "up");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		} else {
			map.put("rstStr", "up fail!");
			map.put("state", 0);
			map.put("count", url.getUp());
			map.put("urlID", urlID);
			map.put("method", "up");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}
		
		
		return null;
	}
	
	private boolean cookieCheck(HttpServletRequest request, HttpServletResponse response, String method) {
		//从session中获得member信息
		Cookie[]cookies=request.getCookies();   
		String   cookieName="myCookie" + urlID + method;   
		String   cookieValue="myCookieValue" + urlID + method; 
		Cookie   myCookie=null;   
		
		for(int   i=0;i<cookies.length;i++)   {   
		  if(cookies[i].getName().equals(cookieName))   {   
		      myCookie=cookies[i];   
		      break;   
		    }   
		}
		
		if(myCookie != null && myCookie.getValue().equals(cookieValue)) {
			//检测cookie，如果存在直接返回，不做数据库操作
			Map map = new HashMap();
			map.put("rstStr", "Fail! can't do it duplicate");
			map.put("state", -1);
			map.put("count", -1);
			map.put("urlID", urlID);
			map.put("method", "-1");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
			return false;
		} else {
			//先设置cookie
			myCookie = new  Cookie(cookieName, cookieValue); 
			myCookie.setMaxAge(60*60*24);
			response.addCookie(myCookie);
			return true;
		}
	}
	
	public String downByAjax() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		if(this.cookieCheck(request, response, "down") == false){
			return null;
		}
		
		Map map = new HashMap();
		Url url = urlManager.loadByID(urlID);
		url.setDown(url.getDown() + 1);
		boolean ok = urlManager.update(url);
		if (true == ok) {
			map.put("rstStr", "down success!");
			map.put("state", 1);
			map.put("count", url.getDown());
			map.put("urlID", urlID);
			map.put("method", "down");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		} else {
			map.put("rstStr", "down fail!");
			map.put("state", 0);
			map.put("count", url.getDown());
			map.put("urlID", urlID);
			map.put("method", "down");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}
		return null;
	}
	
	public String clickrateByAjax() {
		Map map = new HashMap();
		Url url = urlManager.loadByID(urlID);
		url.setClickrate(url.getClickrate() + 1);
		boolean ok = urlManager.update(url);
		if (true == ok) {
			map.put("rstStr", "click success!");
			map.put("state", 1);
			map.put("count", url.getClickrate());
			map.put("urlID", urlID);
			map.put("method", "click");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		} else {
			map.put("rstStr", "click fail!");
			map.put("state", 0);
			map.put("count", url.getClickrate());
			map.put("urlID", urlID);
			map.put("method", "click");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}
		return null;
	}
	
	public String delete() {

		boolean ok = urlManager.delete(urlID);

		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String deleteBatchByAjax() {
		Map map = new HashMap();
		String ids[] = null;
		//如果一个未选中，则不更新；
		if(urlIDs == null || urlIDs.trim().equals("")) {
			map.put("rstStr", "fail, selected nothing!");
			map.put("state", "0");
			map.put("method", "deleteBatch");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
			return null;
		} else {
			ids = urlIDs.split(",");
		}
		String whereCondition = "";
		for(int i=0; i<ids.length; i++) {
			whereCondition += " id=" + ids[i] + (i==ids.length-1 ? " " : " or ");
		}
		String sql = "delete from znzn_url where " + whereCondition;
		boolean ok = urlManager.executQuery(sql); 
		if(ok != true) {
			map.put("rstStr", "fail!");
			map.put("state", "-1");
			map.put("method", "deleteBatch");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}else {
			map.put("rstStr", "success!");
			map.put("state", "1");
			map.put("method", "deleteBatch");
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}
		
		return null;
	}

	public String modify() {
		Url url = urlManager.loadByID(urlID);
		url.setDescr(descr);
		url.setRecflag(recflag);
		url.setTitle(title);
		url.setUrladdress(urladdress);
		url.setOrigin(origin);
		url.setTags(tags);
		//categoryid和categoryname从前台或后台一起传过来，然后拆分获取到；
		String[] id_name = idandname.trim().split("#");
		categoryid = Integer.parseInt(id_name[0]);
		categoryname = id_name[1];
		url.setCategoryid(categoryid);
		url.setCategoryname(categoryname);
		
		url.setLive(live);
		url.setTopflag(topflag);
		
		boolean ok = urlManager.update(url);

		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	 
	/** 
	 * @Description 前台显示，带分页
	 * @author xiudong.li
	 * @return  
	 */
	public String list() {
		sql_count = "select count(*) from znzn_url where categoryid=" + categoryid;
		sql = "select * from znzn_url where categoryid=" + categoryid + " order by createtime desc";
		if (pageNo == null || pageNo.trim().equals("")) {
			pageNo = "1";
		} 
		//处理直接点击和查询的分页问题
		if(pageSize == 0) pageSize = Constant.PAGESIZE_BG;
		Class c = new Url().getClass();
		page = searchMgr.search(sql_count, sql, pageNo, c, pageSize);
		return SUCCESS;
	}

	
	 
	/** 
	 * @Description 后台管理，带分页
	 * @author xiudong.li
	 * @return  
	 */
	public String manager() {

		String sqlOrigin = "select * from znzn_url";
		String sqlCountOrigin = "select count(*) from znzn_url";
		// 通过查询进入
		sql = CommonUtil.getSQL(sqlOrigin, search_content, search_condition, "createtime");
		sql_count = CommonUtil.getSQLCount(sqlCountOrigin, search_content, search_condition);
		
		if(pageSize == 0) pageSize = Constant.PAGESIZE_BG;
		Class c = new Url().getClass();
		
		if (CommonUtil.isEmpty(pageNo)) {
			//直接点击/搜索点击，均走session
			page = searchMgr.search(sql_count, sql, c, pageSize);
			return SUCCESS;
		} else {
			//直接点击和查询的分页问题(从session中取带查询条件的sql)
			page = searchMgr.search(pageNo, c, pageSize);
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public int getTopflag() {
		return topflag;
	}

	public void setTopflag(int topflag) {
		this.topflag = topflag;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public long getClickrate() {
		return clickrate;
	}

	public void setClickrate(long clickrate) {
		this.clickrate = clickrate;
	}

	public long getUp() {
		return up;
	}

	public void setUp(long up) {
		this.up = up;
	}

	public long getDown() {
		return down;
	}

	public void setDown(long down) {
		this.down = down;
	}

	public SearchMgr getSearchMgr() {
		return searchMgr;
	}
	
	public String getIdandname() {
		return idandname;
	}

	public void setIdandname(String idandname) {
		this.idandname = idandname;
	}

	public static void main(String[] args) {
		Object o = null;
		System.out.println(o);
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getUrlIDs() {
		return urlIDs;
	}

	public void setUrlIDs(String urlIDs) {
		this.urlIDs = urlIDs;
	}

}
