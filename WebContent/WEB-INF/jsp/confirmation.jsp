<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Confirmation</title>
<link rel="stylesheet" href="styles/jsp.css" type="text/css"/>
</head>
<body>

<div id="global">
    <fieldset>
        <legend>Confirmation: </legend>
        <p>
            <label>Name: </label>
            <span style="color:blue"><c:out value="${form.name}"/></span>
        </p>
        <p>
            <label>Email: </label>
            <span style="color:blue"><c:out value="${form.email}"/></span>
        </p>
        <p>
            <label>Which program are you in?</label>
            <span style="color:blue"><c:out value="${form.program}"/></span>
        </p>
        <p>
            <label>What year are you in?</label>
            <span style="color:blue"><c:out value="${form.year}"/></span>
        </p>
        <p>
            <label>Do you want your information to be shared with students?</label>
            <span style="color:blue"><c:out value="${form.share}"/></span>
        </p>
 
    </fieldset>
    
    <a href="./">Index</a>
</div>

</body>
</html>
