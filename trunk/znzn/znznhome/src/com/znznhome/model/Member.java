package com.znznhome.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znzn_member")
public class Member {

	public static final int SUPERMANAGER = 1;
	public static final int COMMONMANAGER = 10;
	public static final int FRONTMANAGER = 100;
	public static final int COMMONMEMBER = 1000;
	private int id;
	private String name;
	private int type;
	private String password;
	private int purview; //（1000一般用户,100前台管理员,10管理员,1超级管理员）
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

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public int getPurview() {
		return purview;
	}

	public void setPurview(int purview) {
		this.purview = purview;
	}
}
