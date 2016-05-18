<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Confirmation</title>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>        
      <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
      <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="global" id="confirm">
	<h1>Confirmation</h1>
        <p>
            <label>Name: </label>
            <span><c:out value="${form.name}"/></span>
        </p>
        <p>
            <label>Email: </label>
            <span><c:out value="${form.email}"/></span>
        </p>
        <p>
            <label>Program: </label>
            <span><c:out value="${form.program}"/></span>
        </p>
        <p>
            <label>Year: </label>
            <span><c:out value="${form.year}"/></span>
        </p>
        <p>
            <label>Information to be shared with students?</label>
            <span><c:out value="${form.share}"/></span>
        </p>
    	<br>
    <a href="./">Go to Main</a>
</div>

</body>
</html>
