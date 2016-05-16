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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Logout</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <div class="global">
            <h1>Logout</h1>
            <p>
            User <span style="color:blue; font-weight: bolder">
                ${login}</span> has been logged out.
            </p>
            <p><a href="./">Back to Index</a></p>
        </div>
    </body>
</html>