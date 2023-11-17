package studentdetails.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentdetails.dao.StudentDao;
import studentdetails.dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		HttpSession session = req.getSession();
		String name1 = (String) session.getAttribute("name");
		String password1= (String) session.getAttribute("password");
		
		try {
			if(name1 != null ) {
			dao.updateStudent(stud);
			List<Student> students = dao.getAllStudent();
			req.setAttribute("students", students);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
			}
			else {
				req.setAttribute("message", "Login Required");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
