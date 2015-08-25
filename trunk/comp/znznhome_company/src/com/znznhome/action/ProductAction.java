package com.znznhome.action;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Product;
import com.znznhome.service.ProductManager;
import com.znznhome.util.Page;
import com.znznhome.util.SearchMgr;
@Component("productAction")
@Scope("prototype")
public class ProductAction extends ActionSupport {
	
	private static final long serialVersionUID = -1204088841716685767L;
	private SearchMgr searchMgr;

	@Resource(name="searchMgr")
	public void setSearchMgr(SearchMgr searchMgr) {
		this.searchMgr = searchMgr;
	}
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
	private String productname;
	private String model;
	private String productnumber;
	private String brand;
	private String unit;
	
	//countNumber 用于接收列表数量，如果不传，则设为6
	private int countNumber;
	
	//ID
	private int productID;
	
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
	
	//ProductManager
	private ProductManager productManager;
	@Resource(name="productManager")
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public String add() {
		Product product = new Product();

		product.setBrand(brand);
		product.setModel(model);
		product.setProductname(productname);
		product.setUnit(unit);
		product.setProductnumber(productnumber);
		product.setContent(content);
		
		product.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入product中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		product.setCategoryname(categoryname);
		product.setContent(content);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String picurl = (String)session.get("picurl");
		session.remove("picurl");
		
		product.setPicurl(picurl);
		product.setTopscore(topscore);
		product.setTitle(title);
		product.setSeotitle(seotitle);
		product.setSeodescription(seodescription);
		product.setSeokeywords(seokeywords);
		product.setRecflag(recflag);
		

		boolean b = productManager.save(product);
		if(true == b) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String delete() {
		
		boolean ok = productManager.delete(productID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		Product product = productManager.loadByID(productID);

		product.setBrand(brand);
		product.setModel(model);
		product.setProductname(productname);
		product.setUnit(unit);
		product.setProductnumber(productnumber);
		product.setContent(content);
		product.setCategoryid(categoryid);
		
		//下面为了截取掉categoryname中的前导符号，将目录名称存入product中，作为冗余字段供使用
		int index = categoryname.lastIndexOf("|----")==-1?-5:(categoryname.lastIndexOf("|----"));
		categoryname = categoryname.substring(index+5);
		product.setCategoryname(categoryname);
		product.setContent(content);
		
		//从session中获得图片地址
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		//新上传图片就用新的，否则就用老的
		String picurl = (session.get("picurl") == null || session.get("picurl" ) == "" ) ? (String)session.get("picurl_md") : (String)session.get("picurl");
		session.remove("picurl");
		session.remove("picurl_md");
		
		product.setPicurl(picurl);
		product.setTopscore(topscore);
		product.setTitle(title);
		product.setSeotitle(seotitle);
		product.setSeodescription(seodescription);
		product.setSeokeywords(seokeywords);
		product.setRecflag(recflag);

		boolean ok = productManager.update(product);
		
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
			Class c = new Product().getClass();
			page = searchMgr.search(pageNo, c, countNumber);
			return SUCCESS;
			
		} else {
			if(countNumber == 0) countNumber = 6;
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_product where recflag=1 and categoryid=" + categoryid;
			sql = "select * from znzn_product where recflag=1 and categoryid=" + categoryid + " order by createtime desc";
			Class c = new Product().getClass();
			page = searchMgr.search(sql_count, sql, c, countNumber);
			return SUCCESS;
		}	
				
	}
	
	public String manager() {
		
		if(action_search != null && action_search.equals("action_search")) {
			//通过查询进入
			sql_count = "select count(*) from znzn_product where 1=1 ";
			sql = "select * from znzn_product where 1=1 ";
			Class c = new Product().getClass();
			page = searchMgr.search(sql_count, sql, search_content, search_condition, c);
			return SUCCESS;
			
		} else if (pageNo != null && !pageNo.trim().equals("")) {
			//处理直接点击和查询的分页问题
			Class c = new Product().getClass();
			page = searchMgr.search(pageNo, c);
			return SUCCESS;
			
		} else {
			//直接点击信息维护时显示的页面；
			sql_count = "select count(*) from znzn_product ";
			sql = "select * from znzn_product order by createtime desc";
			Class c = new Product().getClass();
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

