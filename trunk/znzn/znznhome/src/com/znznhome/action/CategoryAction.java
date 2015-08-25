package com.znznhome.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Category;
import com.znznhome.service.CategoryManager;
import com.znznhome.util.CommonUtil;
import com.znznhome.util.Constant;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("categoryAction")
@Scope("prototype")
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 317762955984388243L;
	
	private SearchMgr searchMgr;

	@Resource(name = "searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}

	private String name;
	private String ename;
	private String categorycoding;
	private String descr;
	private int pid;
	private int isleaf;
	private int grade;
	private String other;
	
	//ID
	private int categoryID;
	
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
	
	//CategoryManager
	private CategoryManager categoryManager;
	
	public CategoryManager getCategoryManager() {
		return categoryManager;
	}

	@Resource(name="categoryManager")
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
	
	public String add() {
		Category category = new Category();
		category.setIsleaf(1);
		category.setDescr(descr);
		category.setGrade(grade);
		category.setName(name);
		category.setEname(ename);
		category.setCategorycoding(categorycoding);
		category.setOther(other);
		category.setPid(pid);
		boolean b = categoryManager.save(category);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = categoryManager.delete(categoryID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Category category = categoryManager.loadByID(categoryID);
		
		//判断ename是否重复
		String oldEname = category.getEname();
		if(!oldEname.equals(ename) && categoryManager.enameExists(ename) != false) {
			return ERROR;
		}
		
		int oldPid = category.getPid();
		
		//先检查是不是移到了自己的子目录下，如果是，则返回错误，更新失败
		List<Category> selfList = new ArrayList<Category>();
		selfList = categoryManager.getAllChilds(selfList, categoryID);
		for(Iterator<Category> iterator = selfList.iterator(); iterator.hasNext();) {
			Category category3 = iterator.next();
			int id3 = category3.getId();
			if (id3 == pid) {
				return ERROR;
			}
		}
		
		//不允许将自己改为自己的子目录
		if(pid == categoryID) {
			return ERROR;
		}
		
		int oldGrade = category.getGrade();
		int newGrade = pid == 0 ? 1 : categoryManager.loadByID(pid).getGrade() + 1;
		int diffGrade = newGrade - oldGrade;
		//category.setIsleaf(isleaf);
		category.setDescr(descr);
		category.setGrade(newGrade);
		category.setName(name);
		category.setEname(ename);
		category.setCategorycoding(categorycoding);
		category.setOther(other);
		category.setPid(pid);
		//如果pid改变了，则需要将新的pid节点的isleaf设为0；
		if(oldPid != pid) {
			//无论如何，将新的父节点isleaf改为1
			categoryManager.updateNewPidCategory(pid);
			//将其所有子节点grade降级或升级
			List<Category> cList = new ArrayList<Category>();
			cList = categoryManager.getAllChilds(cList, categoryID);
			for(Iterator<Category> iterator = cList.iterator(); iterator.hasNext();) {
				Category category2 = iterator.next();
				int grade2 = category2.getGrade();
				category2.setGrade(grade2 + diffGrade) ;
				categoryManager.update(category2);
			}
		}
		boolean ok = categoryManager.update(category);
		//检查原来的父目录，如果没有子节点了，则改isleaf为1
		categoryManager.updateOldPidCategory(oldPid);
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String manager() {
		String sqlOrigin = "select * from znzn_category";
		String sqlCountOrigin = "select count(*) from znzn_category";
		// 通过查询进入
		sql = CommonUtil.getSQL(sqlOrigin, search_content, search_condition, "");
		sql_count = CommonUtil.getSQLCount(sqlCountOrigin, search_content, search_condition);
		
		if(pageSize == 0) pageSize = Constant.PAGESIZE_BG;
		Class c = new Category().getClass();
		
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
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCno() {
		return isleaf;
	}
	public void setCno(int cno) {
		this.isleaf = cno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
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

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getCategorycoding() {
		return categorycoding;
	}

	public void setCategorycoding(String categorycoding) {
		this.categorycoding = categorycoding;
	}
}
