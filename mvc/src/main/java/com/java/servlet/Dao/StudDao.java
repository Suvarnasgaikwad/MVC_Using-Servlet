package com.java.servlet.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.model.Student;

public class StudDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Mysqlroot3306");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}
	
	public  static int save(Student stud) throws SQLException
	{
		Connection con=StudDao.getConnection();
		Statement st=con.createStatement();
		String sql="insert into Student values('"+stud.getId()+"','"+stud.getStudName()+"','"+stud.getStudlastName()+"');";
		int result=st.executeUpdate(sql);
		return result;
		
	}
	public static List<Student> getstud() throws SQLException
	{  List<Student>list=new ArrayList<>();
		Connection con=StudDao.getConnection();
		Statement st=con.createStatement();
		String sql="select*from Student";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Student stud=new Student();
			int id=rs.getInt("StudId");
			String name=rs.getString("StudName");
			String last=rs.getString("StudlastName");
			stud.setId(id);
			stud.setStudName(name);
			stud.setStudlastName(last);
			list.add(stud);
		}
		return list;
	}
	public static int delete(int id) throws SQLException
	{
		Connection con=StudDao.getConnection();
		Statement st=con.createStatement();
		String sql="delete from Student where StudId='"+id+"'";
		int num=st.executeUpdate(sql);
		
		return num;
		
	}
}