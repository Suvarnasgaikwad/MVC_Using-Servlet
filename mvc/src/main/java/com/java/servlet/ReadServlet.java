package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.java.servlet.Dao.StudDao;
import com.java.servlet.model.Student;

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try {
				List<Student>list=StudDao.getstud();
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<a href='Reg.html'>Add New Student</a>");
				out.println("<h1>Student List</h1>");
				out.print("<table border='1' width='50%'");
				out.print("<tr><th>Id</th><th>Name</th><th>LastName</th><th>Delete</th></tr>");
				for(Student e:list){
					out.print("<tr><td>"+e.getId()+"</td><td>"+e.getStudName()+"</td><td>"+e.getStudlastName()+"</td><td><a href='DelServlet?id="+e.getId()+"'>delete<a></td></tr>");
				}
				out.print("</table>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
