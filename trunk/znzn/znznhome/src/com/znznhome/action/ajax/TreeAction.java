package com.znznhome.action.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.util.AjaxOutPrintUtil;
import com.znznhome.util.JsonUtil;

@Component("treeAction")
@Scope("prototype")
public class TreeAction extends ActionSupport {

	/** @Fields serialVersionUID: */
	private static final long serialVersionUID = -4421759726039415662L;

	private int pid;
	private int position;
	private int grade;
	private String title;
	private String url;
	private int memberid;
	private String type;
	private int isleaf;

	public String load() {
		System.out.println("debug");
/*		String result = "<ul parent_id=\"9\" state=\"open\" id=\"1\">" + "<li  parent_id2=\"7\" state=\"copend\"  id=\"4\">" + "	<a href=\"#\">Roo t node 1</a>" + "	<ul>"
				+ "		<li  parent_id2=\"8\" state=\"open\"  id=\"2\">" + "			<a href=\"#\">Child00 node 1</a>" + "		</li>" + "		<li parent_id=\"92\" id=\"3\">"
				+ "			<a href=\"#\">Child node 2</a>" + "		</li>" + "	</ul>" + "</li>" + "<li parent_id=\"90\" id=\"5\">"
				+ "	<a href=\"#\">Root node 2</a>" + "</li>" + "</ul>";
		String result = "{" + 
				"\"data\" : \"node_title\", " + 
				// omit `attr` if not needed; the `attr` object gets passed to the jQuery `attr` function
				"\"attr\" : { \"id\" : \"88\" }, " + 
				// `state` and `children` are only used for NON-leaf nodes
				"\"state\" : \"closed\", " + 
				"\"children\" : []" +
			"}";
*/
		//Map map = new HashMap();
		//map里面装所有的dir  data（title），attr（id），state，children（map）
		Map map = new HashMap();
		Map attrs = new HashMap();
		attrs.put("id", 123);
		map.put("data", "lxd");
		map.put("attr", attrs);
//		map.put("state", "closed");
		//child
		Map children = new HashMap();
		Map sonAttrs = new HashMap();
		children.put("data", "xiaobao");
		sonAttrs.put("id", 456);
		children.put("attr", sonAttrs);
		map.put("children", new Map[]{children});
		System.out.println(JsonUtil.map2JsonString(map));
		String result = JsonUtil.map2JsonString(map);

		AjaxOutPrintUtil.print(result);

		return null;
	}

	public String add() {
		String result = "'status':1,'id':234";
		System.out.println("pid: " + pid);
		System.out.println("position: " + position);
		System.out.println("title: " + title);
		System.out.println("type: " + type);
		
		AjaxOutPrintUtil.print(result);
		return null;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	
}
