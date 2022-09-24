package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.dto.Cart;

import jdbc_maven.Cart;
public class CartDao {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection connection=null;
	public Cart saveCartobj(Cart p) {
		String query="insert into Cart values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection=DriverManager.getConnection("localhost:3306","root","root");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306  /jdbcprc","root","root");
			//String query=("insert into bike values(?,?,?,?,?)");
			//st.execute("INSERT INTO jdbcprc.student VALUES(1,'VINOD','0987654334','Bangalore','561007')");
			CartDao cao=new CartDao();
			Cart cto=new Cart();
			PreparedStatement ps= connection.prepareStatement(query);
			
			ps.setInt(1, p.getId());
			ps.setString(2,p.getEmail());
			ps.setString(3,p.getPassword());
			ps.setString(4,p.getUsername());
			ps.setString(5,p.getAddress());
			int rows=ps.executeUpdate();
			if(rows==1) {
				return p ;
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		}
	public Cart updateCartobj(Cart p) {
		String query="update Cart set Email=?,Password=?,Address=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection=DriverManager.getConnection("localhost:3306","root","root");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306  /jdbcprc","root","root");
			//String query=("insert into bike values(?,?,?,?,?)");
			//st.execute("INSERT INTO jdbcprc.student VALUES(1,'VINOD','0987654334','Bangalore','561007')");
			CartDao cao=new CartDao();
			Cart cto=new Cart();
			PreparedStatement ps= connection.prepareStatement(query);
			
			ps.setInt(1, p.getId());
			ps.setString(2,p.getEmail());
			ps.setString(3,p.getPassword());
			ps.setString(4,p.getUsername());
			ps.setString(5,p.getAddress());
			int rows=ps.executeUpdate();
			if(rows==1) {
				return p ;
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		}
	
	public Cart getCartobj(int id) {
		String query="Select * from Cart where Cart_Id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection=DriverManager.getConnection("localhost:3306","root","root");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306  /jdbcprc","root","root");
			//String query=("insert into bike values(?,?,?,?,?)");
			//st.execute("INSERT INTO jdbcprc.student VALUES(1,'VINOD','0987654334','Bangalore','561007')");
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, id);
			//ResultSet rs=new ResultSet();
			Cart pr=new Cart();
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				pr.setId(rs.getInt(1));
				pr.setEmail(rs.getString(2));
				pr.setPassword(rs.getString(3));
				pr.setUsername(rs.getString(4));
				pr.setAddress(rs.getString(5));	
			}
			return pr;
		}
			
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public String deleteCartobj(int id) {
		String query="delete from Cart where Cart_Id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection=DriverManager.getConnection("localhost:3306","root","root");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306  /jdbcprc","root","root");
			//String query=("insert into bike values(?,?,?,?,?)");
			//st.execute("INSERT INTO jdbcprc.student VALUES(1,'VINOD','0987654334','Bangalore','561007')");
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, id);
			int a=ps.executeUpdate();
			if(a==1) {
				return "deleted";
			}
		}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(connection!=null) {
					try {
						connection.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
		}
		return null;
	}


	
}
