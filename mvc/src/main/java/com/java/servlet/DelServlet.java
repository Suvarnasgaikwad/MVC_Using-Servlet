package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.java.servlet.Dao.StudDao;

/**
 * Servlet implementation class DelServlet
 */
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   String Id= request.getParameter("id");
	PrintWriter out=response.getWriter();
	    int id=Integer.parseInt(Id);
	    int num=0;
	    try {
			 num=StudDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    response.sendRedirect("ReadServlet");
//		if(num>0)
//		{
//			out.println("Delete DAta");
//		}
//		else {
//			out.println(" failed to Delete DAta");
//		}
	}

}
