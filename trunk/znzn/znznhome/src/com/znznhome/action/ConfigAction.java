package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Config;
import com.znznhome.model.ConfigMap;
import com.znznhome.model.Url;
import com.znznhome.service.ConfigManager;
import com.znznhome.util.CommonUtil;
import com.znznhome.util.Constant;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;

@Component("configAction")
@Scope("prototype")
public class ConfigAction extends ActionSupport {

	/** @Fields serialVersionUID: */
	private static final long serialVersionUID = -6804838909652139709L;
	
	private SearchMgr searchMgr;

	@Resource(name = "searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
	
	//countNumber 用于接收列表数量，如果不传，则设为6
	private int countNumber;
	
	private String item;
	private String conffield;
	private String confvalue;
	private String confdescr;
	private int orders;

	// ID
	private int configID;

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

	// ConfigManager
	private ConfigManager configManager;
	
	@Resource(name = "configManager")
	public void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}
	
	private ConfigMap configMap = ConfigMap.getInstance();
	
/*	@Resource(name = "configMap")
	public void setConfigMap(ConfigMap configMap) {
		this.configMap = configMap;
	}*/
	 
	/** 
	 * @Description 刷新目录及配置缓存
	 * @author xiudong.li
	 * @return  
	 */
	public String refresh() {
		configMap.init();
		return null;
	}
	
	public String add() {
		Config config = new Config();
		config.setConfdescr(confdescr);
		config.setConffield(conffield);
		config.setConfvalue(confvalue);
		config.setOrders(orders);
		config.setItem(item);
		boolean b = configManager.save(config);
		if (true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		boolean ok = configManager.delete(configID);

		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Config config = configManager.loadByID(configID);
		config.setConfdescr(confdescr);
		config.setConffield(conffield);
		config.setConfvalue(confvalue);
		config.setOrders(orders);
		config.setItem(item);
		boolean ok = configManager.update(config);
		if (true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String manager() {

		String sqlOrigin = "select * from znzn_meta_config";
		String sqlCountOrigin = "select count(*) from znzn_meta_config";
		// 通过查询进入
		sql = CommonUtil.getSQL(sqlOrigin, search_content, search_condition, "createtime");
		sql_count = CommonUtil.getSQLCount(sqlCountOrigin, search_content, search_condition);
		
		if(pageSize == 0) pageSize = Constant.PAGESIZE_BG;
		Class c =  new Config().getClass();
		
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


	public int getCountNumber() {
		return countNumber;
	}


	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getConffield() {
		return conffield;
	}


	public void setConffield(String conffield) {
		this.conffield = conffield;
	}


	public String getConfvalue() {
		return confvalue;
	}


	public void setConfvalue(String confvalue) {
		this.confvalue = confvalue;
	}


	public String getConfdescr() {
		return confdescr;
	}


	public void setConfdescr(String confdescr) {
		this.confdescr = confdescr;
	}


	public int getConfigID() {
		return configID;
	}


	public void setConfigID(int configID) {
		this.configID = configID;
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
	
	public String getAction_search() {
		return action_search;
	}

	public void setAction_search(String action_search) {
		this.action_search = action_search;
	}
	
	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

}
