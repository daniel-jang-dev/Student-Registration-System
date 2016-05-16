
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="styles/jsp.css" type="text/css"/>
        <title>Student List</title>
    </head>
    <body>
        <div id="list_box">
            <h1>Registered Students</h1>
            <table class="table table-striped">
                <tr>
                    <th>Count</th>
                    <th>Name</th>  
                    <th>Email</th>
                    <th>Program</th>
                    <th>Year</th>
                    <th>Share</th>
                    <th>Update</th>
                </tr>
                
                <c:forEach var="s" items="${students}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.program}</td>
                        <td>${s.year}</td>
                        <td>${(s.share)?"yes":"no"}</td>                     
                        <td><a href="teacher?action=delete_student&student_id=${s.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                
            </table>
            <a href="./">Back to index</a>
            <p><a href="teacher?action=logout">Log out</a></p>
        </div>
    </body>
</html>
