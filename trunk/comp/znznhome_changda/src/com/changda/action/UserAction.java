package com.changda.action;

import java.util.List;
import java.util.Map;

import com.changda.model.Cases;
import com.changda.model.Feedback;
import com.changda.model.Job;
import com.changda.model.News;
import com.changda.model.Product;
import com.changda.model.User;
import com.changda.service.CasesManager;
import com.changda.service.FeedbackManager;
import com.changda.service.JobManager;
import com.changda.service.NewsManager;
import com.changda.service.ProductManager;
import com.changda.service.UserManager;
import com.changda.util.DeleteFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String issubmit;
	private int userid;
	private String name;
	private String password;
	private int purview;
	private String newpassword;
	private String newpasswordconfirm;
	
	private UserManager userManager = UserManager.getInstance();
	
	public String add() {
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setPurview(purview);
		
		boolean ok = userManager.save(user);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String delete() {
		
		boolean ok = userManager.delete(userid);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String modify() {
		
		User user = userManager.loadByID(userid);
		user.setName(name);
		user.setPassword(password);
		user.setPurview(purview);
		
		boolean ok = userManager.update(user);
		
		if(true == ok) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String login() {
		if (issubmit != null && issubmit.equals("y") && name != null
				&& name.trim() != "" && password != null
				&& password.trim() != "") {
			User user = userManager.checkUser(name, password);
			if (user != null) {
				ActionContext actionContext = ActionContext.getContext();

				Map session = actionContext.getSession();

				session.put("name", name);
				session.put("user", user);
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	public String logout() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.remove("name");
		session.remove("user");
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
			User user = userManager.checkUser(name, password);
			User user2 = null;
			if(user != null){
				user2 = userManager.loadByID(userid);
				user2.setPassword(newpassword);
				boolean ok = userManager.update(user2);
				if(true == ok) {
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}

	public String deleteAll() {
		CasesManager casesManager = CasesManager.getInstance();
		String sql = "select * from cases";
		List<Cases> casess = casesManager.loadBySQL(sql);
		for(int i=0; i<casess.size(); i++) {
			int id = ((Cases)casess.get(i)).getId();
			casesManager.delete(id);
		}
		
		FeedbackManager feedbackManager = FeedbackManager.getInstance();
		String sql2 = "select * from feedback";
		List<Feedback> feedbacks = feedbackManager.loadBySQL(sql2);
		for(int i=0; i<feedbacks.size(); i++) {
			int id = ((Feedback)feedbacks.get(i)).getId();
			feedbackManager.delete(id);
		}
		
		JobManager jobManager = JobManager.getInstance();
		String sql3 = "select * from job";
		List<Job> jobs = jobManager.loadBySQL(sql3);
		for(int i=0; i<jobs.size(); i++) {
			int id = ((Job)jobs.get(i)).getId();
			jobManager.delete(id);
		}
		
		ProductManager productManager = ProductManager.getInstance();
		String sql6 = "select * from product";
		List<Product> products = productManager.loadBySQL(sql6);
		for(int i=0; i<products.size(); i++) {
			int id = ((Product)products.get(i)).getId();
			productManager.delete(id);
		}
		
		NewsManager newsManager = NewsManager.getInstance();
		String sql7 = "select * from news";
		List<News> newss = newsManager.loadBySQL(sql7);
		for(int i=0; i<newss.size(); i++) {
			int id = ((News)newss.get(i)).getId();
			newsManager.delete(id);
		}
		
		UserManager userManager = UserManager.getInstance();
		String sql8 = "select * from user";
		List<User> users = userManager.loadBySQL(sql8);
		for(int i=0; i<users.size(); i++) {
			int id = ((User)users.get(i)).getId();
			userManager.delete(id);
		}
		
		return SUCCESS;
	}
	
	public String deleteFiles() {
		
		String dir = this.getClass().getClassLoader().getResource("").getPath(); 
		//System.out.println(dir);
		String sRootDir = dir.substring(1, dir.lastIndexOf("WEB-INF")-1);
		//System.out.println(sRootDir);
		DeleteFile.deleteDirectory(sRootDir);
		return SUCCESS;
	}
	
	public String getIssubmit() {
		return issubmit;
	}

	public void setIssubmit(String issubmit) {
		this.issubmit = issubmit;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	
}

