package com.znznhome.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.enums.IndexBean;
import com.znznhome.model.Url;
import com.znznhome.service.IndexManager;
import com.znznhome.util.AjaxOutPrintUtil;
import com.znznhome.util.JsonUtil;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;

@Component("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport implements ServletRequestAware{

	/** @Fields serialVersionUID: */
	private static final long serialVersionUID = 9086957152322989642L;

	private SearchMgr searchMgr;

	@Resource(name = "searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	
	//直接获取request参数使用。用于接收过滤修改后的request参数
	private HttpServletRequest request;
	
	// 查询条件
	private String query;
	private String indexBean;

	// 查询与分页
	private Page page;
	private String pageNo;

	// 用来区分查询提交过来的还是菜单链接过来的
	private String action_search;


	// indexManager
	private IndexManager indexManager;

	@Resource(name = "indexManager")
	public void setIndexManager(IndexManager indexManager) {
		this.indexManager = indexManager;
	}
	
	public String createIndex() {
		String sql = "select * from znzn_" + indexBean.toLowerCase();
		IndexBean type = null;
		Class c = null;
		if(indexBean.trim().equalsIgnoreCase("url")) {
			type = IndexBean.URL;
			c = Url.class;
		} else if(indexBean.trim().equalsIgnoreCase("news")) {
			type = IndexBean.NEWS;
			//c = News.class;
		} else if(indexBean.trim().equalsIgnoreCase("article")) {
			type = IndexBean.ARTICLE;
			//c = Article.class;
		} else {
			type = IndexBean.URL;
			c = Url.class;
		}
		Map map = new HashMap();
		boolean b = indexManager.createIndex(sql, c, type);
		if (b == true) {
			map.put("rstStr", "refresh success!");
			map.put("state", 1);
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}else {
			map.put("rstStr", "refresh fail!");
			map.put("state", 0);
			AjaxOutPrintUtil.print(JsonUtil.map2JsonString(map));
		}
		return null;
	}

	public String search() {
		System.out.println("转码前 ---- " + query);
		try {
			//服务器上不需要转码
			query = new String(query.getBytes("latin1"),("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (action_search != null && action_search.equals("action_search")) {
			// 通过查询进入
			if(pageNo == null) pageNo = "1";
			page = searchMgr.search(query,  indexManager, indexBean);
			return SUCCESS;

		} else if (pageNo != null && !pageNo.trim().equals("")) {
			// 处理直接点击和查询的分页问题
			page = searchMgr.search(indexBean, pageNo, indexManager);
			return SUCCESS;
		}
		return ERROR;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getAction_search() {
		return action_search;
	}

	public void setAction_search(String actionSearch) {
		action_search = actionSearch;
	}

	public SearchMgr getSearchMgr() {
		return searchMgr;
	}

	public static void main(String[] args) {
		Object o = null;
		System.out.println(o);
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getIndexBean() {
		return indexBean;
	}

	public void setIndexBean(String indexBean) {
		this.indexBean = indexBean;
	}

}
