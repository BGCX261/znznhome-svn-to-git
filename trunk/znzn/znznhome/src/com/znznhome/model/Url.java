package com.znznhome.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znzn_url")
public class Url implements Serializable{

	private long id;
	private int categoryid;
	private String categoryname;
	private String title;
	private String urladdress;
	private String descr;
	private String tags; //标签，4个字以内
	private int memberid; // 发布人id
	private String membername; // 发布人姓名
	private String origin; // 网址来源
	private String ipaddress; // 添加url人员的ip

	private long score; // 得分， 排名在前，但在recflag之后，暂时不启用
	private int recflag; // 推荐， 排名靠前 可多个
	private int topflag; // 置顶， 排名最前 可多个
	private int live; // 为0：不显示， 1：显示
	private long clickrate; // 点击率，每点击一次，click增1.
	private long up; // 顶多少次
	private long down; // 踩多少次

	private Timestamp createtime;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrladdress() {
		return urladdress;
	}

	public void setUrladdress(String urladdress) {
		this.urladdress = urladdress;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getRecflag() {
		return recflag;
	}

	public void setRecflag(int recflag) {
		this.recflag = recflag;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public int getTopflag() {
		return topflag;
	}

	public void setTopflag(int topflag) {
		this.topflag = topflag;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public long getClickrate() {
		return clickrate;
	}

	public void setClickrate(long clickrate) {
		this.clickrate = clickrate;
	}

	public long getUp() {
		return up;
	}

	public void setUp(long up) {
		this.up = up;
	}

	public long getDown() {
		return down;
	}

	public void setDown(long down) {
		this.down = down;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
