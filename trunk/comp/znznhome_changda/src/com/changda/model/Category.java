package com.changda.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	private int id;
	private int pid;
	private String name;
	//这个目录下的文件（news）所用的模板文件名称，列表例外，如案例展示，则用单独模板
	private String templatefilename;
	private int isleaf;
	private int grade;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getTemplatefilename() {
		return templatefilename;
	}

	public void setTemplatefilename(String templatefilename) {
		this.templatefilename = templatefilename;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
