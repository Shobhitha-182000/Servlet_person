package servlet_prc_person_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import servlet_prc_person_dao.PersonDao;
import servlet_prc_person_dto.Person;

public class PersonController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String first_name=req.getParameter("name");
		String last_name=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		//save
		//assigning value
		Person person=new Person();
		person.setFirst_name(first_name);
		person.setLast_name(last_name);
		person.setEmail(email);
		person.setPassword(password);
		person.setPhone(phone);
		
		PersonDao personDao=new PersonDao();
//		personDao.savePerson(person);
		personDao.updatePerson(email, person);
		
		//to print on browser
		PrintWriter out =res.getWriter();
		out.print("person Details added Successfully");
		System.out.println("person details added Successfully");
		
		
	}

}
