package com.znznhome.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "znzn_meta_config")
public class Config {

	private int id;
	private String item;
	private String conffield;
	private String confvalue;
	private String confdescr;
	private Timestamp createtime;
	private int orders;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getConffield() {
		return conffield;
	}

	public void setConffield(String conffield) {
		this.conffield = conffield;
	}

	public String getConfvalue() {
		return confvalue;
	}

	public void setConfvalue(String confvalue) {
		this.confvalue = confvalue;
	}

	public String getConfdescr() {
		return confdescr;
	}

	public void setConfdescr(String confdescr) {
		this.confdescr = confdescr;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

}
