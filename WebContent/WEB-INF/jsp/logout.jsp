<%@ page contentType="text/html" pageEncoding="utf-8" session="true" %>
<% 
    String login = request.getRemoteUser();
    if(login == null){
        response.sendRedirect("./");
    }else{
        session.invalidate();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout</title>
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
            <h1>Logout</h1>
            <p>
            User <span style="color:blue; font-weight: bolder">
                ${login}</span> has been logged out.
            </p>
            <p><a href="./">Back to Main</a></p>
        </div>
    </body>
</html>