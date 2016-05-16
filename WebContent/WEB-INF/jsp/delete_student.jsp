<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/jsp.css" type="text/css"/>
    <title>Student Delete</title>
  </head>
  <body>
    <div class="global">
      <h1>Delete Student Record</h1>
      <p class="message">Do you really want to remove this record?</p>
      <fieldset>
        <legend>Student Info</legend>
        <p>
          <label>Name:</label> 
          <span class="value">
            <c:out value="${student.name}"/>
          </span>
        </p>
        <p>
          <label>Email:</label>
          <span class="value">
            <c:out value="${student.email}"/>
          </span>
        </p>
        <p>
          <label>Program:</label>
          <span class="value">
            <c:out value="${student.programName}"/>
          </span>
        </p>
        <p>
          <label>Year:</label>
          <span class="value">
            <c:out value="${student.year}"/>
          </span>
        </p>
        <p>
          <label>Share:</label>
          <span class="value">
            <c:out value="${student.share}"/>
          </span>
        </p>
        
        <form action="teacher" method="post">
          <input type="hidden" name="action" value="remove_student"/>
          <input type="hidden" name="student_id" value="${student.id}"/>
          <input class="buttons" type="submit" value="Delete"/>
        </form>
        <form action="teacher" method="get">
          <input type="hidden" name="action" value="list_students"/>
          <input class="buttons" type="submit" value="Cancel"/>
        </form>
        
      </fieldset>
    </div>
  </body>
</html>
