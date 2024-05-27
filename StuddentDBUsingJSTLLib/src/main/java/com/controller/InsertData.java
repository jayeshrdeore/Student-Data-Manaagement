package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	StudentDAO dao;
	ServletContext config;


    public InsertData() {
        super();
       
    }


	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new StudentDAO();
		this.config = config.getServletContext();
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));
		
		Student student = new Student(id,name,marks);
	
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		int i = dao.insertStudent(student, url, username, password);
		System.out.println("data inserted");
		
		if (i == 1) {
			response.sendRedirect("jsp/display.jsp");

		} else {
			out.print("<h1>NOT ADD </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);


		}
	}

}
