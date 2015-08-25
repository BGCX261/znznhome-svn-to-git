package com.znznhome.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znzn_myfavorite")
public class MyFavorite implements Serializable {
	
	private int id;
	private int memberCtgrId;
	private String title;
	private String url;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberCtgrId() {
		return memberCtgrId;
	}

	public void setMemberCtgrId(int memberCtgrId) {
		this.memberCtgrId = memberCtgrId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
