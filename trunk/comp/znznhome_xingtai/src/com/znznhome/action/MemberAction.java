package com.znznhome.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.model.Cases;
import com.znznhome.model.Category;
import com.znznhome.model.FeedBack;
import com.znznhome.model.Member;
import com.znznhome.model.News;
import com.znznhome.model.Product;
import com.znznhome.service.CasesManager;
import com.znznhome.service.CategoryManager;
import com.znznhome.service.FeedBackManager;
import com.znznhome.service.MemberManager;
import com.znznhome.service.NewsManager;
import com.znznhome.service.ProductManager;

@Component("memberAction")
@Scope("prototype")
public class MemberAction extends ActionSupport {
	
	private static final long serialVersionUID = -5889220799483118762L;

	//ID
	private int memberID;
	
	private String issubmit;
	
	private String name;
	private int type;
	private String password;
	private int purview; //0,普通 1,管理员
	private String email;
	private Timestamp createtime;
	private int passflag;// 0,未通过，1,通过，
	private String realname;
	private String sex;
	private String phyle;
	private String blood;
	private String college;
	private String company;
	private String address;
	private String contact;
	private Timestamp birthday;
	
	private String newpassword;
	
	private String newpasswordconfirm;
	
	private MemberManager memberManager;
	private CasesManager casesManager; 
	private CategoryManager categoryManager; 
	private FeedBackManager feedBackManager; 
	private NewsManager newsManager; 
	private ProductManager productManager; 

	@Resource(name="casesManager")
	public void setCasesManager(CasesManager casesManager) {
		this.casesManager = casesManager;
	}

	@Resource(name="categoryManager")
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	@Resource(name="feedBackManager")
	public void setFeedBackManager(FeedBackManager feedBackManager) {
		this.feedBackManager = feedBackManager;
	}

	@Resource(name="newsManager")
	public void setNewsManager(NewsManager newsManager) {
		this.newsManager = newsManager;
	}

	@Resource(name="productManager")
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	@Resource(name="memberManager")
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

	public String add() {
		
		if(name == null || password == null){
			return ERROR;
		}else if (name.trim().equals("") || password.trim().equals("")) {
			return ERROR;
		}else if (memberManager.memberExists(name) == true) {
			return ERROR;
		}
		
		Member member = new Member();
		member.setName(name);
		member.setPassword(password);
		member.setPurview(purview);
		member.setAddress(address);
		member.setBirthday(birthday);
		member.setBlood(blood);
		member.setCollege(college);
		member.setCompany(company);
		member.setContact(contact);
		member.setEmail(email);
		member.setPhyle(phyle);
		member.setRealname(realname);
		member.setSex(sex);
		member.setType(type);
		
		boolean ok = memberManager.save(member);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String delete() {
		
		boolean ok = memberManager.delete(memberID);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		Member member = memberManager.loadByID(memberID);
		member.setName(name);
		member.setPassword(password);
		member.setPurview(purview);
		member.setAddress(address);
		member.setBirthday(birthday);
		member.setBlood(blood);
		member.setCollege(college);
		member.setCompany(company);
		member.setContact(contact);
		member.setEmail(email);
		member.setPhyle(phyle);
		member.setRealname(realname);
		member.setSex(sex);
		member.setType(type);
		
		boolean ok = memberManager.update(member);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String del() {
		String sql = "select * from znzn_cases";
		List<Cases> casess = casesManager.loadBySQL(sql);
		for(int i=0; i<casess.size(); i++) {
			int id = ((Cases)casess.get(i)).getId();
			casesManager.delete(id);
		}
		
		String sql2 = "select * from znzn_feedback";
		List<FeedBack> feedbacks = feedBackManager.loadBySQL(sql2);
		for(int i=0; i<feedbacks.size(); i++) {
			int id = ((FeedBack)feedbacks.get(i)).getId();
			feedBackManager.delete(id);
		}
		
		String sql6 = "select * from znzn_product";
		List<Product> products = productManager.loadBySQL(sql6);
		for(int i=0; i<products.size(); i++) {
			int id = ((Product)products.get(i)).getId();
			productManager.delete(id);
		}
		
		String sql7 = "select * from znzn_news";
		List<News> newss = newsManager.loadBySQL(sql7);
		for(int i=0; i<newss.size(); i++) {
			int id = ((News)newss.get(i)).getId();
			newsManager.delete(id);
		}
		
		String sql8 = "select * from znzn_category";
		List<Category> category = categoryManager.loadBySQL(sql8);
		for(int i=0; i<category.size(); i++) {
			int id = ((Category)category.get(i)).getId();
			categoryManager.delete(id);
		}
		
		return SUCCESS;
	}
	
	public String login() {
		
		if (issubmit != null && issubmit.equals("y") && name != null
				&& name.trim() != "" && password != null
				&& password.trim() != "") {
			Member member = memberManager.checkMember(name, password);
			if (member != null) {
				ActionContext actionContext = ActionContext.getContext();

				Map session = actionContext.getSession();

				session.put("name", name);
				session.put("member", member);
				session.put("purview", member.getPurview());
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	public String logout() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("name");
		session.remove("member");
		session.remove("purview");
		return SUCCESS;
	}
	
	public String changepassword() {
		if(name != null &&
				!name.trim().equals("") &&
				newpassword != null && 
				!newpassword.trim().equals("") && 
				newpasswordconfirm != null &&
				!newpasswordconfirm.trim().equals("") &&
				newpassword.equals(newpasswordconfirm)) {
			Member member = memberManager.checkMember(name, password);
			Member member2 = null;
			if(member != null){
				member2 = memberManager.loadByID(memberID);
				member2.setPassword(newpassword);
				boolean ok = memberManager.update(member2);
				if(true == ok) {
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}

	public String getIssubmit() {
		return issubmit;
	}

	public void setIssubmit(String issubmit) {
		this.issubmit = issubmit;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPurview() {
		return purview;
	}

	public void setPurview(int purview) {
		this.purview = purview;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpasswordconfirm() {
		return newpasswordconfirm;
	}

	public void setNewpasswordconfirm(String newpasswordconfirm) {
		this.newpasswordconfirm = newpasswordconfirm;
	}
	
	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public MemberManager getUserManager() {
		return memberManager;
	}

	public void setUserManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public int getPassflag() {
		return passflag;
	}

	public void setPassflag(int passflag) {
		this.passflag = passflag;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhyle() {
		return phyle;
	}

	public void setPhyle(String phyle) {
		this.phyle = phyle;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	
}

