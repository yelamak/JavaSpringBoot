package com.medplus.employee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.employee.bean.Employee;
import com.medplus.employee.service.AdminService;
import com.medplus.employee.service.impl.AdminServiceImpl;
import com.medplus.employee.utils.DateParsing;

/**
 * Servlet implementation class UpdateEmpl
 */
@WebServlet("/UpdateEmpl")
public class UpdateEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	AdminService service=new AdminServiceImpl();
	Employee emp=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.parseInt(request.getParameter("code"));
		emp=service.getEmployeeById(code);
		RequestDispatcher rd=request.getRequestDispatcher("UpdateEmpl.jsp");
		request.setAttribute("employee", emp);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		//session.setAttribute("action", "update");
		int empcode=Integer.parseInt(request.getParameter("empcode"));
		String empname=request.getParameter("empname");
		int sal=Integer.parseInt(request.getParameter("salary"));
		String dob=request.getParameter("dob");
		emp=new Employee();
		emp.setDoj(DateParsing.stringToUtilDateConversion(dob));
		emp.setEmpid(empcode);
		emp.setEmpname(empname);
		emp.setEmpsalary(sal);
		int rows=service.updateEmployee(emp);
		if(rows>0)
			request.setAttribute("success", "updated successfully");
		else
			request.setAttribute("error", "Not updates");
		request.setAttribute("action", session.getAttribute("action"));
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewEmpls");
		rd.forward(request, response);
	}

}
