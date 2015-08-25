package com.znznhome.dao;

import java.util.List;

import com.znznhome.model.Member;

public interface MemberDAO {
	
	boolean save(Member member);
	boolean update(Member member);
	boolean delete(int id);
	int countBySQL(String count_sql);
	List<Member> loadBySQL(String sql);
	Member loadByID(int id);
	boolean memberExists(String name);
	Member checkMember(String name, String password);
}
