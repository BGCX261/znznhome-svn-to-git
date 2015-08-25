package com.znznhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.znznhome.dao.MemberDAO;
import com.znznhome.model.Member;

@Component("memberManager")
public class MemberManager {
	private MemberDAO memberDAO;
	@Resource(name="memberDAO")
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public boolean save(Member member) {
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
