package com.xyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyz.bean.User;
import com.xyz.ecommercedao.EcommerceDAO;

@WebServlet("/Register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EcommerceDAO dao;
	User u;
	PrintWriter out;
	public UserRegisterServlet() {
		dao=new EcommerceDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		String loginID=request.getParameter("uid");
		String password=request.getParameter("pswd");
		String email=request.getParameter("email");
		u=new User(loginID,password,email); 
		int inserted = dao.registerUser(u);
		if(inserted>0){
			out.println("<font color=green>User Created. Please Login</font>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		else
			out.println("<h2>Rows not inserted</h2>");
	}

}
