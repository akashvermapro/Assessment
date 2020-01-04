package com.xyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyz.bean.User;
import com.xyz.ecommercedao.EcommerceDAO;

@WebServlet("/ListProducts" )
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EcommerceDAO dao;
	User u;
	PrintWriter out;
	public ListProducts() {
		dao=new EcommerceDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("main.html");
			rd.include(request,response);
			ResultSet res=dao.retrieveProducts();
			out.println("<table border=3><tr><th>Id</th><th>Name</th><th>Price</th><th>Category</th></tr>");
			while(res.next())
			{
				out.println("<tr>");
				out.println("<td>"+res.getString("id")+"</td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getInt("price")+"</td>");
				out.println("<td>"+res.getString("category")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
