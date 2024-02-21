package com.tech.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	
	private static Connection cn=null;
	private static Statement st =null;
	private static PreparedStatement ps= null;
	private static ResultSet rs=null;
	
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle" , "root","admin");
		
		return cn;
	}
	
	public static void create(){
		try {
			cn =getConnection();
			st=cn.createStatement();
			String sql="create table priya(p_id int , p_name varchar(24), p_email varchar(25))";
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	finally {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(cn!=null){
				  try {
					cn.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				  }
			}
	}
	}
	public static void insert(int p_id , String p_name,String p_email){
		try {
			cn=getConnection();
			ps=cn.prepareStatement("insert into priya values(?,?,?)");
			ps.setInt(1, p_id);
			ps.setString(2, p_name);
			ps.setString(3, p_email);
		
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				if(cn!=null){
					  try {
						cn.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					  }
				}
		}
		
	
	}
	public static void delete(int p_id) {
		try {
			cn=getConnection();
			ps=cn.prepareStatement("delete from priya where p_id=?");
			ps.setInt(1, p_id);

		
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				if(cn!=null){
					  try {
						cn.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					  }
				}
		}
		
	}
	

	
	
		
	
	public static void Update(int p_id, String p_name, String p_email)  {
		try {
			cn=getConnection();
			String sql="Update  priya set p_name=? , p_email=? where p_id=?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, p_name);
			ps.setString(2, p_email);
			ps.setInt(3, p_id);
			
			
			
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				if(cn!=null){
					  try {
						cn.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					  }
				}
		}
		
	}
	
	public static void retrive() {
		try {
			cn=getConnection();
			st=cn.createStatement();
			String sql="select * from priya";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
				System.out.println("------------------------");

			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		finally {
			if(st!=null) {
				try 
				{
					st.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				if(cn!=null){
					  try
					  {
						cn.close();
					} 
					  catch (SQLException e)
					  {
					
						e.printStackTrace();
					}
					  }
				}
		}
		
		
		
		
		
	}





}
