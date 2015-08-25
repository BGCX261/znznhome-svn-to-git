package com.changda.util;

import java.util.Map;

import com.changda.action.UserAction;
import com.changda.model.User;
import com.changda.service.UserManager;
import com.opensymphony.xwork2.ActionContext;

public class Test {
	public static void main(String args[]) {
/*		UserManager um = UserManager.getInstance();

			//User user = um.checkUser("admin", "admin");
		User u = new User();
		u.setName("3");
		u.setPassword("3");
		boolean b = um.save(u);
		System.out.println(b);*/
String test ="<p>sadj</p>adsl<p>dsafk</p><div style=\"page-break-after: always\"><span style=\"display: none\">&nbsp;</span></div><p>sadj</p>adsl<p>dsafk</p>";
String tests[] = test.split("<div style=\"page-break-after: always\"><span style=\"display: none\">&nbsp;</span></div>");
System.out.println(tests[0]);
System.out.println(tests[1]);
	}
}
