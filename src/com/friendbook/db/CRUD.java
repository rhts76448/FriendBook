package com.friendbook.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD {
	static Connection cn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;

	public static String getUserId(String name, String password)
	{
		String userId=null;
		
		int i=name.trim().indexOf(" ");
		if(i>0)
			userId=name.substring(0, i).toLowerCase();
		else
			userId=name;
		int c=checkUserId(userId);
		userId=userId+c;
		
		try
		{
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("insert into user(id,name,password) values(?,?,?)");
			ps.setString(1, userId);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.execute();
			ps.close();
		}
		catch(SQLException e)
		{System.out.println(e);}
		
		return userId;
	}
	public static int checkUserId(String userId)
	{
		int count=0;
		cn=DbConnection.getConnection();
		try
		{
			ps=cn.prepareStatement("select count(*) from user where id LIKE ?");
			ps.setString(1, userId+"%");
			rs=ps.executeQuery();
			if(rs.next())
				count=rs.getInt(1);
			ps.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return count;
	}
	public static String userSignIn(String userId, String password)
	{
		String name=null;
		try
		{
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("select name from user where id=? and password=?");
			ps.setString(1, userId.toLowerCase());
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
				name=rs.getString(1);
			ps.close();
		}
		catch(SQLException e)
		{System.out.println(e);}
		return name;
	}
	public static String getUserName(String userId)
	{
		String name=null;
		try
		{
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("select name from user where id=?");
			ps.setString(1, userId);
			rs=ps.executeQuery();
			if(rs.next())
				name=rs.getString(1);
			ps.close();
		}
		catch(SQLException e)
		{System.out.println(e);}
		return name;
	}
	public static int getFriendShip(String userId,String r_userId)
	{
		int c=0;
		try {
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("select count(*) from friendships_status where (sender_id=? and receiver_id=?) or (sender_id=? and receiver_id=?)");
			ps.setString(1, userId);
			ps.setString(2, r_userId);
			ps.setString(4, userId);
			ps.setString(3, r_userId);
			rs=ps.executeQuery();
			if(rs.next())
				c=rs.getInt(1); 
			ps.close();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return c;
	}
	public static void becomeFriends(String userId, String r_userId)
	{
		try
		{
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("insert into friendships_status(sender_id,receiver_id) values(?,?)");
			ps.setString(1, userId);
			ps.setString(2, r_userId);
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public static String[] getFriends(String userId)
	{
		ArrayList<String> list=new ArrayList<String>();
		try
		{
			cn=DbConnection.getConnection();
			ps=cn.prepareStatement("select sender_id from friendships_status where receiver_id=? UNION select receiver_id from friendships_status where sender_id=?");
			ps.setString(1, userId);
			ps.setString(2, userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(!(list.contains(rs.getString(1))))
				{
					list.add(rs.getString(1));
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		String[] friends = new String[list.size()];
		friends = list.toArray(friends);
		return friends;
	}
}
