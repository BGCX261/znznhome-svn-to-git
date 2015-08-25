package com.znznhome.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class Test {
	public static void main(String args[]) throws UnsupportedEncodingException {
/*		UserManager um = UserManager.getInstance();

			//User user = um.checkUser("admin", "admin");
		User u = new User();
		u.setName("3");
		u.setPassword("3");
		boolean b = um.save(u);
		System.out.println(b);*/
		/*String s = "abc";
		int s_int = 0;
		try {
			s_int = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}*/
		//System.out.println("s_int" + s_int);
		MD5 md5 = new MD5();
		//System.out.print(md5.getMD5ofStr("admin"));
		//System.out.println(MD5.toMD5("admin"));
		String url_ = "http://localhost:8080/api-server/gds/simple?sid=2203&encode=utf-8&resType=xml&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CosmChange%3E%3Cdata%3E%3Cway+oldchangeset%3D%2224%22+%2F%3E%3C%2Fdata%3E%3C%2FosmChange%3E";
		System.out.println(URLDecoder.decode(url_, "utf-8"));
		String url_2 = "//api-server/gds/simple?sid=2203&encode=utf-8&resType=json&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=\" title=\"http://10.2.8.40:25001/api-server/gds/simple?sid=2203&encode=utf-8&resType=json&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=10.2.8.40:25001/api-server/gds/simple?sid=2203&encode=utf-8&resType=json&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=\">http://10.2.8.40:25001/api-server/gds/simple?sid=2203&encode=utf-8&resType=json&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CosmChange%3E%3Cdata%3E%3Cway+oldchangeset%3D%222%22+%2F%3E%3C%2Fdata%3E%3C%2FosmChange%3E10.2.8.40:25001/api-server/gds/simple?sid=2203&encode=utf-8&resType=json&key=92bff35f9df2777fe3897b2587e4754d5bc4c42f4dea1daedbe9dc1d643b0f0eb8ab57c7d532f771&eid=21&userid=103&layerid=10161&xml=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CosmChange%3E%3Cdata%3E%3Cway+oldchangeset%3D%222%22+%2F%3E%3C%2Fdata%3E%3C%2FosmChange%3E";
		System.out.println(URLDecoder.decode(url_2, "utf-8"));

	}
}
