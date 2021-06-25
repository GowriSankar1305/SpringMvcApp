<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html data-textdirection="ltr" class="loading">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"><title>login here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/icomoon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/flag-icon.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pace.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-extended.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/app.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/colors.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vertical-menu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vertical-overlay-menu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login-register.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body data-open="click" data-menu="vertical-menu" data-col="1-column" class="vertical-layout vertical-menu 1-column  blank-page blank-page">
<div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><section class="flexbox-container">
    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1  box-shadow-2 p-0">
        <div class="card border-grey border-lighten-3 m-0">
            <div class="card-header no-border">
                <div class="card-title text-xs-center">
                    <div class="p-1"><img src="${pageContext.request.contextPath}/resources/images/robust-logo-dark.png" alt="branding logo"></div>
                </div>
                <c:choose>
                    <c:when test="${loginFail ne null}">
                    <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span style="color: red;font-weight: bold;">${loginFail}</span></h6>
                    </c:when>
                    <c:when test="${logoutSuccess ne null}">
                    <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span style="color: green;font-weight: bold;">${logoutSuccess}</span></h6>
                    </c:when>
                    <c:when test="${sessionExpired ne null}">
                    <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span style="color: red;font-weight: bold;">${sessionExpired}</span></h6>
                    </c:when>
                    <c:when test="${sessionInvalid ne null}">
                    <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span style="color: orange;font-weight: bold;">${sessionInvalid}</span></h6>
                    </c:when>
                </c:choose>
            </div>
            <div class="card-body collapse in">
                <div class="card-block">
                    <form class="form-horizontal form-simple" action="login" method="post" id="signupFrm">
                        <fieldset class="form-group position-relative has-icon-left mb-0">
                            <input type="text" class="form-control form-control-lg input-lg" name="username" id="username" placeholder="Your Username" required>
                            <div class="form-control-position">
                                <i class="icon-head"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group position-relative has-icon-left">
                            <input type="password" class="form-control form-control-lg input-lg" name="password" id="password" placeholder="Enter Password" required>
                            <div class="form-control-position">
                                <i class="icon-key3"></i>
                            </div>
                        </fieldset>
                        <fieldset class="form-group row">
                            <div class="col-md-6 col-xs-12 text-xs-center text-md-left">
                                <fieldset>
                                    <input type="checkbox" id="remember-me" class="chk-remember">
                                    <label for="remember-me"> Remember Me</label>
                                </fieldset>
                            </div>
                            <div class="col-md-6 col-xs-12 text-xs-center text-md-right"><a href="recover-password.html" class="card-link">Forgot Password?</a></div>
                        </fieldset>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary btn-lg btn-block" id="submitBtn"><i class="icon-unlock2"></i> Login</button>
                    </form>
                </div>
            </div>
            <div class="card-footer">
                <div class="">
                    <p class="float-sm-left text-xs-center m-0"><a href="recover-password.html" class="card-link">Recover password</a></p>
                    <p class="float-sm-right text-xs-center m-0">New to Robust? <a href="register-simple.html" class="card-link">Sign Up</a></p>
                </div>
            </div>
        </div>
    </div>
</section>

        </div>
      </div>
    </div>

</body>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/tether.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/unison.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/blockUI.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.matchHeight-min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/screenfull.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/pace.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app-menu.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>

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
		$('#submitBtn').html('<i class="icon-spinner3"></i> Checking...');
		$('#submitBtn').attr('disabled',true);
		return true;
	});
});
</script>
</html>