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
import com.medplus.employee.service.UserService;
import com.medplus.employee.service.impl.AdminServiceImpl;
import com.medplus.employee.service.impl.UserServiceImpl;

/**
 * Servlet implementation class GetById
 */
@WebServlet("/GetById")
public class GetById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	AdminService service=new AdminServiceImpl();
	Employee emp=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("GetById.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("logintype").equals("admin")) {
		int code=Integer.parseInt(request.getParameter("empcode"));
		emp=service.getEmployeeById(code);
		RequestDispatcher rd=request.getRequestDispatcher("GetById.jsp");
		if(emp!=null) {
			request.setAttribute("employee", emp);
			
		}
		else {
			request.setAttribute("info","no records found");
		}
		rd.forward(request, response);
		}
		else
		{
			UserService us=new UserServiceImpl();
			int code=Integer.parseInt(request.getParameter("empcode"));
			emp=us.getEmployeeById(code);
			RequestDispatcher rd=request.getRequestDispatcher("GetById.jsp");
			if(emp!=null) {
				request.setAttribute("employee", emp);
				
			}
			else {
				request.setAttribute("info","no records found");
			}
			rd.forward(request, response);
		}
	}

}
