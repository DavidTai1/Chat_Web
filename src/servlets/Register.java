package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data_objects.Users;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		if (username == ""){
//			response.sendRedirect("register.jsp?err=3");
//			return;
//		}
//		
//		Users u = Jpa_user.getUser("a");
//		
//		if(u != null){
//			response.sendRedirect("register.jsp?err=1");
//			return;
//		}
//		u=new Users(username,password);
//		Jpa_user.addUser(u);
		
//		request.getSession(true).setAttribute("loggedInUser", u);
//		
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
