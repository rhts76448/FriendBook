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
 * Servlet implementation class BecomeFriends
 */
@SuppressWarnings("serial")
@WebServlet("/BecomeFriends")
public class BecomeFriends extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		String userId=(String)session.getAttribute("userId");
		String r_userId=(String)session.getAttribute("r_userId");
		CRUD.becomeFriends(userId, r_userId);
		int c=CRUD.getFriendShip(userId, r_userId);
		session.setAttribute("friendship", c);
		session.setAttribute("view", "searchBox");
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
