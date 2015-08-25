package com.znznhome.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.MyFavorite;
import com.znznhome.service.MyFavoriteManager;
import com.znznhome.util.AjaxOutPrintUtil;
import com.znznhome.util.JsonUtil;
import com.znznhome.util.Page;
import com.znznhome.util.PageMgr;
@Component("myFavoriteAction")
@Scope("prototype")
public class MyFavoriteAction extends ActionSupport {
	
	private PageMgr pageMgr;

	@Resource(name="pageMgr")
	public void setPageMgr(PageMgr pageMgr) {
		this.pageMgr = pageMgr;
	}
	private int pid;
	private int position;
	private int grade;

	public PageMgr getPageMgr() {
		return pageMgr;
	}
	private String title;
	private String url;
	private int mbid;
	private String type;
	private int isleaf;
	
	//ID
	private int myFavoriteID;
	
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
	
	
	private MyFavoriteManager myFavoriteManager;
	
	public MyFavoriteManager getMyFavoriteManager() {
		return myFavoriteManager;
	}

	@Resource(name="myFavoriteManager")
	public void setMyFavoriteManager(MyFavoriteManager myFavoriteManager) {
		this.myFavoriteManager = myFavoriteManager;
	}

	public String load() {
		String sql = "select * from znzn_myfavorite where mbid=" + mbid;
		List<MyFavorite> list = myFavoriteManager.loadBySQL(sql);
		
		String result = "";
		
		if(list == null || list.size() == 0) {
			//insert into znzn_myfavorite values(0, -1, 0, 0, '收藏夹', '', 0, 0, 'dir') ;
			Map map = new HashMap();
			Map attrs = new HashMap();
			attrs.put("id", 0);
			map.put("data", "收藏夹");
			map.put("attr", attrs);
			result = JsonUtil.map2JsonString(map);
		} else{
			Map map = new HashMap();
			Map attrs = new HashMap();
			attrs.put("id", 0);
			map.put("data", "lxd");
			map.put("attr", attrs);
//			map.put("state", "closed");
			//child
			Map children = new HashMap();
			Map sonAttrs = new HashMap();
			children.put("data", "xiaobao");
			sonAttrs.put("id", 0);
			children.put("attr", sonAttrs);
			map.put("children", new Map[]{children});
			System.out.println(JsonUtil.map2JsonString(map));
			result = JsonUtil.map2JsonString(map);
		}
		
		AjaxOutPrintUtil.print(result);
		return null;
	}
	
	 
	 /** 
	  * @Description 
	  *   id not null auto_increment,
	  *   pid bigint(20)  not null,
	  *   position bigint(20)  not null,
	  *   title varchar(100) not null,
	  *   memberid bigint(20) not null,
	  * @author xiudong.li
	  * @return  
	  */
	public String add() {
		MyFavorite myFavorite = new MyFavorite();
		//myFavorite.setGrade(1);程序自动控制
		myFavorite.setTitle(title);
		myFavorite.setUrl(url);
		System.out.println("add ? " + pid + title + position);
		boolean b = myFavoriteManager.save(myFavorite);
		if(true == b) {
			AjaxOutPrintUtil.print("add success");
		} else {
			AjaxOutPrintUtil.print("add fail");
		}
		
		return null;
	}
	
	public String delete() {
		
		boolean ok = myFavoriteManager.delete(myFavoriteID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		MyFavorite myFavorite = myFavoriteManager.loadByID(myFavoriteID);
		myFavorite.setTitle(title);
		myFavorite.setUrl(url);
		boolean b = myFavoriteManager.save(myFavorite);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {

			sql_count = "select count(*) from znzn_myfavorite where 1=1 ";
			sql = "select * from znzn_myfavorite where 1=1 ";
			
			//查询条件
			String condition = "";

			//构建查询条件
			if(search_content != null && !search_content.trim().equals("")) {
				condition = condition + " and " + search_condition + 
				" like '%" + search_content + "%'";
			}
			
			//为查询条件添加排序条件
			//condition = condition + " order by createtime desc " ;
			int pageSize = 10;
			Class c = new MyFavorite().getClass();
			
			//给sql语句加上查询条件
			sql_count = sql_count + condition;
			sql = sql + condition;
			page = pageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
			
			//查询条件存入session
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.remove("sql");
			session.remove("sql_count");
			session.put("sql", sql);
			session.put("sql_count", sql_count);
			
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			
			//接受传入的查询条件
			sql = (String)session.get("sql");
			sql_count = (String)session.get("sql_count");
			
			//不能将pageNo作为int类型直接接收下来，否则无法做判断，因此作为字符串引入。
			//这里再声明一个变量，解析一下pageNo，并处理一下异常；
			int intPageNo = 0;

			try {
				intPageNo = Integer.parseInt(pageNo.trim());
			} catch (NumberFormatException e) {
				intPageNo = 1;
			}
			if (intPageNo <= 0){
					intPageNo = 1;
			}
			
			int pageSize = 10;
			Class c = new MyFavorite().getClass();
			page = pageMgr.getListForPage(c, sql_count, sql, intPageNo, pageSize);
			
			return SUCCESS;
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_myfavorite ";
			sql = "select * from znzn_myfavorite ";

			int pageSize = 10;
			Class c = new MyFavorite().getClass();
			page = pageMgr.getListForPage(c, sql_count, sql, 1, pageSize);
			
			//查询条件存入session
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.remove("sql");
			session.remove("sql_count");
			session.put("sql", sql);
			session.put("sql_count", sql_count);
			
			return SUCCESS;
		}	
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}

	public int getMyFavoriteID() {
		return myFavoriteID;
	}

	public void setMyFavoriteID(int myFavoriteID) {
		this.myFavoriteID = myFavoriteID;
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

	public void setSql_count(String sqlCount) {
		sql_count = sqlCount;
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

	public void setAction_search(String actionSearch) {
		action_search = actionSearch;
	}

	public String getSearch_content() {
		return search_content;
	}

	public void setSearch_content(String searchContent) {
		search_content = searchContent;
	}

	public String getSearch_condition() {
		return search_condition;
	}

	public void setSearch_condition(String searchCondition) {
		search_condition = searchCondition;
	}

	public int getMbid() {
		return mbid;
	}

	public void setMbid(int mbid) {
		this.mbid = mbid;
	}
	
}
