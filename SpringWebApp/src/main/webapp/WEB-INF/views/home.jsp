<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to the application</h2>
<a href="javascript:document.getElementById('logOutFrm').submit();" class="btn btn-default btn-flat">Sign out</a>
<form action="logout" id="logOutFrm" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>