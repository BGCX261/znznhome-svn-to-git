package com.changda.service;

import java.util.List;

import com.changda.dao.MemberDAO;
import com.changda.dao.UserDAO;
import com.changda.dao.impl.MemberDAOImpl;
import com.changda.dao.impl.UserDAOImpl;
import com.changda.model.Member;
import com.changda.model.User;

public class MemberManager {
	private static MemberManager memberManager = null;
	private MemberDAO memberDAO = new MemberDAOImpl();
	private MemberManager(){
	}
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public static synchronized  MemberManager getInstance() {
		if(memberManager == null) memberManager = new MemberManager();
		return memberManager;
	}
	
	public boolean save(Member member) {
		if(member.getName() == null || member.getPassword() == null){
			return false;
		}else if (member.getName().trim().equals("") || member.getPassword().trim().equals("")) {
			return false;
		}else if (MemberManager.getInstance().memberExists(member.getName()) == true) {
			return false;
		}
		
		return memberDAO.save(member);
	}

	public int countBySQL(String count_sql) {
		return memberDAO.countBySQL(count_sql);
	}

	public List<Member> loadBySQL(String sql) {
		return memberDAO.loadBySQL(sql);
	}

	public boolean delete(int id) {
		return memberDAO.delete(id);
	}
	
	public Member loadByID(int id) {
		return memberDAO.loadByID(id);
	}
	
	public boolean update(Member member) {
		return memberDAO.update(member);
	}
	
	//检查用户名是否存在
	public boolean memberExists(String name) {
		return memberDAO.memberExists(name);
	}

	//登录检测
	public Member checkMember(String name, String password) {
		return memberDAO.checkMember(name, password);
	}

}
