package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ems.bean.Employee;
import com.ems.util.DBUtil;

public class EmployeeDAO {
   public int insertEmployee(Employee bean)throws Exception{
	   Connection con = DBUtil.getDBConnection();
	   String sql = "insert into tbl_employee values (?, ?, ?)";
	   PreparedStatement ps = con.prepareStatement(sql);
	   ps.setInt(1, bean.getEid());
	   ps.setString(2, bean.getEname());
	   ps.setInt(3, bean.getEsalary());
	   int n = ps.executeUpdate();
	   con.close();
	   return n;
   }
   
  
   
   public int deleteEmployee(int eid)throws Exception{
	   //Fill Your Code
	   Connection con = DBUtil.getDBConnection();
	   String sql = "delete from tbl_Employee where eid=?";
	   PreparedStatement ps = con.prepareStatement(sql);
	   ps.setInt(1, eid);
	   int n = ps.executeUpdate();
	   con.close();
	
	   return n;
   }
   
   public Employee findEmployee(int eid)throws Exception{
	   Connection con = DBUtil.getDBConnection();
	   String sql = "select * from tbl_employee where eid = ?";
	   PreparedStatement ps = con.prepareStatement(sql);
	   ps.setInt(1, eid);
	   ResultSet rs = ps.executeQuery();
	   Employee e = null;
	   if(rs.next()){
		   e = new Employee();
		   e.setEid(rs.getInt("eid"));
		   e.setEname(rs.getString("ename"));
		   e.setEsalary(rs.getInt("esalary"));
	   }
	   return e;
   }
   
   public List<Employee> findAllEmployee()throws Exception{
	   ArrayList<Employee> empList = new ArrayList<Employee>();
	   Connection con = DBUtil.getDBConnection();
	   String sql = "select * from tbl_employee";
	   PreparedStatement ps = con.prepareStatement(sql);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next()){
		  Employee e = new Employee();
		  e.setEid(rs.getInt("eid"));
		  e.setEname(rs.getString("ename"));
		  e.setEsalary(rs.getInt("esalary"));
		  empList.add(e);
	   }
	   return empList;
   }

public int UpdateEmployee(Employee bean) throws Exception{
		   //Fill Your Code
		   Connection con = DBUtil.getDBConnection();

		   String sql = "UPDATE tbl_employee SET esalary =? WHERE eid =?";
		   PreparedStatement ps = con.prepareStatement(sql);
		   ps.setInt(1, bean.getEsalary());
		ps.setInt(2, bean.getEid());
		   
		   int n = ps.executeUpdate();
		   con.close();
		   return n;
	
}
}
