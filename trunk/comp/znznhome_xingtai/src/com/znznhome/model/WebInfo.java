package com.znznhome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znzn_webinfo")
public class WebInfo {
	
	private int id;
	private String companyname;
	private String shortname;
	private String seokeywords;
	private String dbserver;
	private String dbserverport;
	private String dbname;
	private String dbusername;
	private String dbpassword;
	private String logourl;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getSeokeywords() {
		return seokeywords;
	}
	public void setSeokeywords(String seokeywords) {
		this.seokeywords = seokeywords;
	}
	public String getDbserver() {
		return dbserver;
	}
	public void setDbserver(String dbserver) {
		this.dbserver = dbserver;
	}
	public String getDbserverport() {
		return dbserverport;
	}
	public void setDbserverport(String dbserverport) {
		this.dbserverport = dbserverport;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDbusername() {
		return dbusername;
	}
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}
	public String getDbpassword() {
		return dbpassword;
	}
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
	public String getLogourl() {
		return logourl;
	}
	public void setLogourl(String logourl) {
		this.logourl = logourl;
	}

}
