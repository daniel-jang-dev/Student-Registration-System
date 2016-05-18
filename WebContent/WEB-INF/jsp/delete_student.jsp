<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Student</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>        
    <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
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
          <input type="submit" value="Delete" class="btnSubmit"/>
        </form>
        <form action="teacher" method="get">
          <input type="hidden" name="action" value="list_students"/>
          <input type="submit" value="Cancel" class="btnReset"/>
        </form>
        
      </fieldset>
    </div>
  </body>
</html>
