package servlet_prc_person_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_prc_person_dao.PersonDao;
import servlet_prc_person_dto.Person;

public class PersonHtmlServController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		 
		
		//save
		//assigning value
		Person person=new Person();
		 
		person.setEmail(email);
		person.setPassword(password);
		 
		
		PersonDao personDao=new PersonDao();
		PrintWriter out	=resp.getWriter();
		//login
		if(personDao.login(email).equals(password)) {
//			out.print("==============Login Successfully==============");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("loginsuccess.html");
//			dispatcher.forward(req, resp);
			resp.sendRedirect("https://www.google.com/");
			
		}
		else {
			//out.print("============Invlid password========");
			RequestDispatcher dispatcher=req.getRequestDispatcher("form.html");
			dispatcher.forward(req, resp);
					}
	}

}
