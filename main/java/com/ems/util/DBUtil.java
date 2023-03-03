package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
  public static Connection getDBConnection()throws Exception{
	  String url = "jdbc:mysql://localhost:3306/abc";
		 String userName = "root";
		 String password = "Mali@1996";
		 //Step-1 : Load the driver into JVM
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //Step-2 : Make a connection with DB
		 Connection con = DriverManager.getConnection(url, userName, password);
		 return con;
  }
}
