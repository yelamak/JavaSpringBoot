package com.medplus.employee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		HttpSession session=request.getSession();
		if(username.equals("admin")){
			if(pass.equals("admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminView.jsp");
				session.setAttribute("logintype", "admin");
				session.setAttribute("username", username);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("error", "Username and Password incorrect");
				rd.forward(request, response);
			}
				
		}
		else {
			if(pass.equals("123")) {
				RequestDispatcher rd=request.getRequestDispatcher("UserView.jsp");
				session.setAttribute("logintype", "user");
				session.setAttribute("username", username);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				request.setAttribute("error", "Username and Password incorrect");
				rd.forward(request, response);
			}
		}
	}

}
