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

@WebServlet("/UserSevlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EcommerceDAO dao;
	User u;
	PrintWriter out;
	public UserServlet() {
		dao=new EcommerceDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		String loginID=request.getParameter("lid");
		String password=request.getParameter("pswd");
	
		
		if(dao.validateUser(loginID,password)){
			out.println("<font color=green>Logged-in Successfully!</font>");
			RequestDispatcher rd=request.getRequestDispatcher("main.html");
			rd.forward(request,response);
		}
		else{
			out.println("<font color=red>LOGIN / PASSWORD IS INCORRECT...</font>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
	}

}
