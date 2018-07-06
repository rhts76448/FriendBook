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
 * Servlet implementation class SearchBox
 */
@SuppressWarnings("serial")
@WebServlet("/SearchBox")
public class SearchBox extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String r_userId=request.getParameter("q");
		String name=CRUD.getUserName(r_userId);
		session.setAttribute("r_name", name);
		session.setAttribute("r_userId", r_userId);
		String userId=(String)session.getAttribute("userId");
		int c=0;
		if(name!=null) {
			c=CRUD.getFriendShip(userId, r_userId);
		}
		session.setAttribute("friendship", c);
		session.setAttribute("view", "searchBox");
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
