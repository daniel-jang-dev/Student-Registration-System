package sheridan.controller;

import sheridan.business.*;
import sheridan.data.StudentDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action == null) {
        	action = "student_list_only";
        }
        String url; // address to forward
        StudentForm form = new StudentForm();

        switch (action) {

        	case "process_data" : {

        		form.setName(request.getParameter("name"));
        	    form.setEmail(request.getParameter("email"));
        	    form.setProgram(request.getParameter("program"));
        	    form.setYear(request.getParameter("year"));

        	    String share = request.getParameter("share");
        	    if (share == null) {
        	        share = "no";
        	    } else {
        	        share = "yes";
        	    }
        	    form.setShare(share);

        	    List<String> errors = StudentFormValidator.validate(form);
        	    if (errors.isEmpty()) {
        	        url = "/WEB-INF/jsp/confirmation.jsp";
        	        Student student = new Student(form);
        	        StudentDB.insert(student);
        	        StudentDB.insertRole(student);
        	    } else {
        	        request.setAttribute("errors", errors);
        	        url = "/WEB-INF/jsp/error.jsp";
        	    }
        	    break;
        	}

        	case "student_list_only" :{
        		url = "/WEB-INF/jsp/student_list_only.jsp";
        		ArrayList<Student> students = StudentDB.selectAllStudents();
        		request.setAttribute("students", students);
        		break;
        	}
        	
        	case "logout" : {
        		url = "/WEB-INF/jsp/logout.jsp";
        		break;
        	}

        	case "start" :
        	default: {
        		url = "/WEB-INF/jsp/student_form.jsp";
        	}
        }

        request.setAttribute("form", form);

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
