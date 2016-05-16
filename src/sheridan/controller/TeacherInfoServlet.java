package sheridan.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridan.business.Student;
import sheridan.data.StudentDB;

public class TeacherInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "list_students";
		}
		String url;

		switch (action) {

			case "delete_student": {
	
				int id = Integer.parseInt(request.getParameter("student_id"));
				Student student = StudentDB.getStudent(id);
				request.setAttribute("student", student);
				url = "/WEB-INF/jsp/delete_student.jsp";
				break;
			}
			
			case "logout" : {
        		url = "/WEB-INF/jsp/logout.jsp";
        		break;
        	}
	
			case "list_students":
			default: {
				url = "/WEB-INF/jsp/student_list.jsp";
			}

		}

		ArrayList<Student> students = StudentDB.selectAllStudents();
		request.setAttribute("students", students);

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url;
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "list_students";
		}
		
		switch (action) {
			case "remove_student": { // remove the record
	
				// you MUST hide student_id as hidden input
	
				int id = Integer.parseInt(request.getParameter("student_id"));
				StudentDB.removeStudent(id);
				
			}
			default: {
				url = "teacher?action=list_students";
			}
		}
		response.sendRedirect(url);
	}

}
