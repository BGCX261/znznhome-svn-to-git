package com.znznhome.util;

import java.sql.*;

public class ListCategory {
	static Connection conn;
	static Statement stmt1, stmt2;
	static ResultSet rs1, rs2;
	static String sql = "";
	static String user = "root";
	static String pswd = "root";
	static String url = "jdbc:mysql://localhost:3306/znzn";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pswd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String listCates(int tempId, String tempStr) {


		try {

			sql = "select * from znzn_category where pid = " + tempId;
					
			stmt1 = conn.createStatement();
			rs1 = stmt1.executeQuery(sql);
			while (rs1.next()) {
				tempId = rs1.getInt("id");
				tempStr += "　┣";
				tempStr += rs1.getString("name") + "<br>";
				// sql = "select * from category where parent_id = " + tempId +
				// " order by orders";
				// stmt2 = conn.createStatement();
				// rs2 = stmt2.executeQuery(sql);
				// if(rs2.next())
				// {
				
				tempStr = listCates(tempId, tempStr);
				// }
				// rs2.close();
				// stmt2.close();
			}
			rs1.close();
			stmt1.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
		// System.out.println(tempStr); //输出到Tomcat
		return tempStr;
	}
	
	public static void main(String[] args) {
		System.out.println(ListCategory.listCates(2, "---"));
	}
}
