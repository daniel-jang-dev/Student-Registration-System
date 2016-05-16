<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Errors</title>
        <link rel="stylesheet" href="styles/jsp.css" type="text/css"/>
    </head>
    <body>
        <div id="global">
            <c:if test="${errors != null}">
                <div id="errors">
                    <ul>
                        <c:forEach var="e" items="${errors}">
                            <li>${e}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <%@include file="/WEB-INF/jspf/form.jspf" %>
        </div>
    </body>
</html>
