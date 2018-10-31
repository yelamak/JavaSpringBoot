package com.medplus.employee.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ViewEmpls
 */
@WebServlet("/ViewEmpls")
public class ViewEmpls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmpls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("logintype").equals("admin")) {
		AdminService ser=new AdminServiceImpl();
		List<Employee> employees = ser.getEmployees();
		session.setAttribute("action", request.getParameter("action"));
		RequestDispatcher rd=request.getRequestDispatcher("ViewEmpls.jsp");
		request.setAttribute("empls", employees);
		rd.forward(request, response);
		}
		else
		{
			UserService user=new UserServiceImpl();
			List<Employee> employees = user.getEmployees();
			
			session.setAttribute("action", request.getParameter("action"));
			RequestDispatcher rd=request.getRequestDispatcher("ViewEmpls.jsp");
			request.setAttribute("empls", employees);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
