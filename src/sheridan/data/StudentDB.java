package sheridan.data;

import java.sql.*;
import java.util.*;

import sheridan.data.ConnectionPool;
import sheridan.data.DBUtil;
import sheridan.business.Student;

public class StudentDB {

	public static int insert(Student student) {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int result = 0;
		String query = "INSERT INTO student "
                        + "(student_name, student_email, program_name, student_year, student_share) "
                        + "VALUES (?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getProgram().ordinal() + 1);
            ps.setInt(4, student.getYear());
            ps.setBoolean(5, student.getShare());
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			System.err.println(e);
			result = 0;
		} finally {
			DBUtil.closePreparedStatement(ps2);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		return result;
	}
	
	public static int insertRole(Student student) {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String query = "INSERT INTO roles (user_login, role_name) VALUES (?, ?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, "student");
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
			result = 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		return result;
	}	

	public static ArrayList<Student> selectAllStudents() {
		
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> students = new ArrayList<>();
		String query = "SELECT * FROM student";
		try {
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				
				student.setId(rs.getInt("student_id"));
				student.setName(rs.getString("student_name"));
                student.setEmail(rs.getString("student_email"));
                student.setProgramName(rs.getString("program_name"));
                student.setYear(rs.getInt("student_year"));
                student.setShare(rs.getBoolean("student_share"));
                
				students.add(student);
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		return students;
	}
	
	public static void removeStudent(int id) {
		
	    ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    
	    String query = "DELETE FROM student WHERE student_id = ?";

	    try {
	      ps = connection.prepareStatement(query);
	      ps.setInt(1, id);
	      ps.executeUpdate();
	    } catch (SQLException e) {
	      System.err.println(e);
	    } finally {
	      DBUtil.closePreparedStatement(ps);
	      pool.freeConnection(connection);
	    }
	}
	
	public static Student getStudent(int id) {
		
	    ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    Student student = null;

	    String query = "SELECT * FROM student WHERE student_id = ?";
	    try {
	    	ps = connection.prepareStatement(query);
	    	ps.setInt(1, id);
	    	rs = ps.executeQuery();
	      
	    	if (rs.next()) {
	    		student = new Student();
	    	  
		    	student.setId(rs.getInt("student_id"));
		    	student.setName(rs.getString("student_name"));
		    	student.setEmail(rs.getString("student_email"));
		    	student.setProgramName(rs.getString("program_name"));
		    	student.setYear(rs.getInt("student_year"));
		    	student.setShare(rs.getString("student_share"));
	    	}
	    } catch (SQLException e) {
	      System.err.println(e);
	    } finally {
	      DBUtil.closeResultSet(rs);
	      DBUtil.closePreparedStatement(ps);
	      pool.freeConnection(connection);
	    }
	    return student;
	}
}
