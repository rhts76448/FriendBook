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
 * Servlet implementation class SignIn
 */
@SuppressWarnings("serial")
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String name=CRUD.userSignIn(userId, password);
		String msg=null;
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		if(name==null)
		{
			msg="Invalid User Id or Password...";
			session.setAttribute("view", null);
		}
		else
		{
			session.setAttribute("name", name);
			session.setAttribute("view", "login");
			session.setAttribute("userId", userId);
			
		}
		session.setAttribute("msg", msg);
		rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
