<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="bg-black">
<head>
<meta charset="UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />
<title>login here</title>
</head>
<body class="bg-black">
<div class="form-box" id="login-box">
            <div class="header">Login</div>
            <form action="login" method="post" id="signupFrm">
                <div class="body bg-gray">
                    <div class="form-group" id="userNameField">
                        <input type="text" name="username" id="username" class="form-control" placeholder="User name"/>
                    </div>
                    <div class="form-group" id="pwdField">
                        <input type="password" name="password" id="password" class="form-control" placeholder="Password"/>
                    </div>          
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Remember me
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block" id="submitBtn">Sign me in</button>  
                    <p><a href="#">I forgot my password</a></p>
                    <p><a href="${pageContext.request.contextPath}/">go to home</a></p>
                    <c:choose>
                    <c:when test="${loginFail ne null}">
                    <p align="center" style="color: red;font-weight: bold;">${loginFail}</p>
                    </c:when>
                    <c:when test="${logoutSuccess ne null}">
                    <p align="center" style="color: green;font-weight: bold;">${logoutSuccess}</p>
                    </c:when>
                    <c:when test="${sessionExpired ne null}">
                    <p align="center" style="color: red;font-weight: bold;">${sessionExpired}</p>
                    </c:when>
                    <c:when test="${sessionInvalid ne null}">
                    <p align="center" style="color: orange;font-weight: bold;">${sessionInvalid}</p>
                    </c:when>
                    </c:choose>
                </div>
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>        
</body>
<script type="text/javascript">
$(function(){
	$('#signupFrm').submit(function(){
		if($('#username').val().trim() === "")	{
			$('#username').focus();
			return false;
		}
		else if ($('#password').val().trim() === "")	{
			$('#password').focus();
			return false;
		}
		$('#submitBtn').html('Checking...');
		$('#submitBtn').attr('disabled',true);
		return true;
	});
});
</script>
</html>