package com.friendbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friendbook.db.CRUD;

/**
 * Servlet implementation class SignUp
 */
@SuppressWarnings("serial")
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String userId=null;
		String msg=null;
		HttpSession session=request.getSession();
		userId=CRUD.getUserId(name, password);
		msg="Your user id to sign in is : "+userId;
		session.setAttribute("msg", msg);
		session.setAttribute("view", null);
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}
