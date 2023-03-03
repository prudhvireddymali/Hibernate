package com.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bean.Employee;
import com.ems.dao.EmployeeDAO;

/**
 * Servlet implementation class EMSController
 */
public class EMSController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionFrom = request.getParameter("EMSButton");
		EmployeeDAO dao = new EmployeeDAO();
		
		if(actionFrom.equals("Insert")){
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			int  esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee bean = new Employee();
			bean.setEid(eid);
			bean.setEname(ename);
			bean.setEsalary(esalary);
			try{
			   int n = dao.insertEmployee(bean);
			   if(n == 1){
				   response.sendRedirect("InsertSuccess.jsp");
			   } else {
				   response.sendRedirect("InsertFail.jsp");
			   }
			}catch(Exception e){
				response.sendRedirect("InsertFail.jsp");
			}
		}
		//delete
		if(actionFrom.equals("Delete")){
			int eid = Integer.parseInt(request.getParameter("eid"));
			try{
			int n= dao.deleteEmployee(eid);
			if(n== 1){
				response.sendRedirect("DeleteSuccess.jsp");
			} else {
				response.sendRedirect("DeleteFail.jsp");
			}
			}catch(Exception e){
				response.sendRedirect("DeleteFail.jsp");
			}
		}
		
		//update
		if(actionFrom.equals("Update")){
			int eid = Integer.parseInt(request.getParameter("eid"));
			//String ename = request.getParameter("ename");
			int  esalary = Integer.parseInt(request.getParameter("esalary"));
			
			Employee bean = new Employee();
			bean.setEid(eid);
			bean.setEsalary(esalary);
			try{
			   int n = dao.UpdateEmployee(bean);
			   if(n >0){
				   response.sendRedirect("UpdateSuccess.jsp");
			   } else {
				   response.sendRedirect("UpdateFail.jsp");
			   }
			}catch(Exception e){
				response.sendRedirect("UpdateFail.jsp");
			}
		}
		 
		if(actionFrom.equals("Find")){
			int eid = Integer.parseInt(request.getParameter("eid"));
			try{
			Employee bean = dao.findEmployee(eid);
			if(bean != null){
				RequestDispatcher rd = request.getRequestDispatcher("FindSucces.jsp");
				request.setAttribute("emp", bean);
				rd.forward(request, response);
			} else {
				response.sendRedirect("FindFail.jsp");
			}
			}catch(Exception e){
				response.sendRedirect("FindFail.jsp");
			}
		}
		
			}
	
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDAO dao = new EmployeeDAO();
		try{
		List<Employee> list = dao.findAllEmployee();
		RequestDispatcher rd = req.getRequestDispatcher("FindAll.jsp");
		req.setAttribute("list", list);
		rd.forward(req, resp);
		}catch(Exception e){
			
		}
	}

}
