//package a.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBBean {
//	private Connection cn;
//	private Statement stmt;
//	private ResultSet rs;
//	private String url="jdbc:mysql://39.107.46.233:3306/db_student";
//	private String username="java";
//	private String password="aaa";
//	public DBBean() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Connection getConnection()
//	{
//		if(cn==null)
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				cn=DriverManager.getConnection(url,username,password);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	return cn;
//	}
//	public ResultSet executeQuery(String sql)
//	{
//		if(cn==null)
//			cn=getConnection();
//		try {
//			stmt=cn.createStatement();
//			rs=stmt.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	return rs;
//	}
//	public int executeUpdate(String sql)
//	{
//		if(cn==null)
//			cn=getConnection();
//		try {
//			stmt=cn.createStatement();
//			return stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return 0;
//		}
//
//	}
//	public void close()
//	{
//		if(cn!=null)
//		{
//			try {
//				if(cn.isClosed()!=false)
//				{
//					cn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
