package studentdetails.servlets;
import studentdetails.dto.Student;
import java.io.IOException;
import java.sql.SQLException;

import studentdetails.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String password = req.getParameter("password");
	String location = req.getParameter("location");
	long phoneno = Long.parseLong(req.getParameter("phoneno"));
	String email = req.getParameter("email");
	
	Student stud =  new Student();
	stud.setId(id);
	stud.setName(name);
	stud.setPassword(password);
	stud.setLocation(location);
	stud.setPhoneNo(phoneno);
	stud.setEmail(email);
	
	StudentDao dao = new StudentDao();
	
	
		int result;
		try {
			result = dao.saveStudent(stud);
			if(result == 1) {
				req.setAttribute("name", name);
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
				
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		}

	
}

