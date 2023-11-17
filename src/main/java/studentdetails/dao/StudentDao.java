package studentdetails.dao;
import studentdetails.dto.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class StudentDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=root");
		return connection;
		
	}
	public int saveStudent(Student stud) throws ClassNotFoundException, SQLException 
	{
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
		pt.setInt(1,stud.getId());
		pt.setString(2, stud.getName());
		pt.setString(3, stud.getPassword());
		pt.setString(4, stud.getLocation());
		pt.setLong(5,stud.getPhoneNo());
		pt.setString(6, stud.getEmail());
		int res = pt.executeUpdate();
		return res;
		
	}
	public Student findbyId(int id) throws ClassNotFoundException, SQLException 
	{
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("select * from student where id = ?");
		pt.setInt(1, id);
		ResultSet rs = pt.executeQuery();
		Student s = new Student();
		while (rs.next())
		{
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setLocation(rs.getString(4));
			s.setPhoneNo(rs.getLong(5));
			s.setEmail(rs.getString(6));	
		}
		return s;
	}
	public int updateStudent(Student stud) throws ClassNotFoundException, SQLException 
	{
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("update student set name = ?,password=?,location=?,phoneno=?,email=? where id = ?");
		pt.setString(1, stud.getName());
		pt.setString(2, stud.getPassword());
		pt.setString(3, stud.getLocation());
		pt.setLong(4,stud.getPhoneNo());
		pt.setString(5, stud.getEmail());
		pt.setInt(6,stud.getId());
		return pt.executeUpdate();
		
	}
	
	public int deleteStudent(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("delete  from student where id = ?");
		pt.setInt(1, id);
		return pt.executeUpdate();
	}
	public List<Student> getAllStudent() throws SQLException, ClassNotFoundException 
	{
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("select * from student ");
		ResultSet rs = pt.executeQuery();
		List<Student> students = new ArrayList<>();
		
		while (rs.next())
		{
			Student s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setLocation(rs.getString(4));
			s.setPhoneNo(rs.getLong(5));
			s.setEmail(rs.getString(6));
			students.add(s);
		}
		return students;
		
	}
	public Student findByName(String name) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		PreparedStatement pt = connection.prepareStatement("select * from student where name = ?");
		pt.setString(1, name);
		ResultSet rs = pt.executeQuery();
		Student s = new Student();
		while (rs.next())
		{
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setLocation(rs.getString(4));
			s.setPhoneNo(rs.getLong(5));
			s.setEmail(rs.getString(6));	
		}
		return s;
		
	}
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
	}

}
