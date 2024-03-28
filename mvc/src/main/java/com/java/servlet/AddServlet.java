package com.java.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.java.servlet.Dao.StudDao;
import com.java.servlet.model.Student;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String StudName=request.getParameter("first");
		String StudlastName=request.getParameter("last");
		String id=request.getParameter("id");
		int StudId=Integer.parseInt(id);
	//	StudDao dao=new StudDao();
		Student stud=new Student();
		stud.setStudName(StudName);
		stud.setStudlastName(StudlastName);
		stud.setId(StudId);
		int status=0;
		try {
			status=StudDao.save(stud);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status>0)
		{
			out.println("Data Successfully Save");
		
		}
		else {
			out.println("Failed to save");
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("Reg.html");
		rd.include(request, response);
	}

}
