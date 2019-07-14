package com.sample.ActionController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.bean.Student;
import com.sample.dao.StudentDao;


@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			s.setAddress(request.getParameter("address"));
			s.setSalary(request.getParameter("salary"));
			s.setId(Integer.parseInt(request.getParameter("id")));
			System.out.println("Value set in bean by servlet request paratemeter");
			StudentDao.insertstudent(s);
			response.sendRedirect("show.jsp");
			
			
			
	
			
		}
		if(action.equalsIgnoreCase("edit"))
		{
			System.out.println("edit button pressed");
			int id=Integer.parseInt(request.getParameter("id"));
			Student s=StudentDao.getStudentById(id);
			System.out.println("Output of getstudentById"+s);
			request.setAttribute("s", s);
			System.out.println("attribute set of student object");
			
			request.getRequestDispatcher("update.jsp").forward(request,response);
			System.out.println("Attrebute dispatch to update.jsp");
			
			
		}
		
		if(action.equalsIgnoreCase("update"))
		{
			Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setId(Integer.parseInt(request.getParameter("id")));
			StudentDao.updateStudent(s);
			response.sendRedirect("show.jsp");
		}
		
		if(action.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			StudentDao.deleteStudentById(id);
			response.sendRedirect("Show.jsp");
		}
	}

}
