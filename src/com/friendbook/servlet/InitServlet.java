package com.friendbook.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.friendbook.db.DbConnection;



/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Connection cn=null;
		super.init(config);
		try {
			Class.forName(config.getInitParameter("driver"));
			cn=DriverManager.getConnection(config.getInitParameter("url"),config.getInitParameter("duser"),config.getInitParameter("dpass"));
			DbConnection.setConnection(cn);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}