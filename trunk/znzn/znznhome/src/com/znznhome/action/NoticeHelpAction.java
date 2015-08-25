package com.znznhome.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.znznhome.service.NoticeHelpManager;
@Component("noticeHelpAction")
@Scope("prototype")
public class NoticeHelpAction extends ActionSupport {
	

	private NoticeHelpManager noticeHelpManager;
	
	public NoticeHelpManager getNoticeHelpManager() {
		return noticeHelpManager;
	}

	@Resource(name="noticeHelpManager")
	public void setNoticeHelpManager(NoticeHelpManager noticeHelpManager) {
		this.noticeHelpManager = noticeHelpManager;
	}

	public String add() {

		return ERROR;
	}
	
	public String delete() {
		
		return ERROR;
	}
	
	public String modify() {
		
		return ERROR;
	}

}
