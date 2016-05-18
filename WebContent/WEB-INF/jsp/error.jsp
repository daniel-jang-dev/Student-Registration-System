<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Errors</title>
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
        
            <c:if test="${errors != null}">
                <div id="errors">
                    <ul>
                        <c:forEach var="e" items="${errors}">
                            <span>${e}</span><br>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <%@include file="/WEB-INF/jspf/form.jspf" %>
        </div>
    </body>
</html>
