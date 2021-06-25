<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin creation</title>
<%@include file="css.jsp"%>
<style type="text/css">
.parsley-type,.parsley-required,.parsley-length,
.parsley-checkemail,.parsley-equalto,.parsley-checkuname,
.parsley-pattern {
	display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    margin-top: 0;
    margin-bottom: 1rem;
    color: #DA4453 !important;
    font-size: 12px;
}
ul li{
	line-height: 1.2;
	display: list-item;
    text-align: -webkit-match-parent;
}
input.parsley-error,
select.parsley-error,
textarea.parsley-error {    
    border-color:#DA4453;
}
input.parsley-error:focus,
select.parsley-error:focus,
textarea.parsley-error:focus {    
    border-color:#967ADC;
}
</style>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">
<%@ include file="header.jsp"%>
<%@ include file="sideBar.jsp"%>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-body">
			<section id="basic-form-layouts">
				<div class="row match-height">
					<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form">Admin Registration</h4>
					<a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
					<div class="heading-elements">
						<ul class="list-inline mb-0">
							<li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
							<li><a data-action="reload"><i class="icon-reload"></i></a></li>
							<li><a data-action="expand"><i class="icon-expand2"></i></a></li>
							<li><a data-action="close"><i class="icon-cross2"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="card-body collapse in">
					<div class="card-block">
						<form class="form" id="register-form" method="post" enctype="multipart/form-data" action="save-admin-details?${_csrf.parameterName}=${_csrf.token}">
							<div class="form-body">
								<h4 class="form-section"><i class="icon-head"></i> Admin Info</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="firstName">First Name</label>
											<input type="text" id="firstName" class="form-control" placeholder="First Name" name="firstName" data-parsley-required="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="lastName">Last Name</label>
											<input type="text" id="lastName" class="form-control" placeholder="Last Name" name="lastName" data-parsley-required="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="emailId">E-mail</label>
											<input type="text" id="emailId" class="form-control" placeholder="E-mail" name="emailId" 
											data-parsley-required="true" data-parsley-type="email" data-parsley-trigger="focusout"
											data-parsley-checkemail>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="mobileNumber">Mobile Number</label>
											<input type="text" id="mobileNumber" class="form-control" placeholder="Phone" name="mobileNumber" data-parsley-required="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="dateOfBirth">Date of birth</label>
											<input type="date" id="dateOfBirth" class="form-control" name="dateOfBirth" data-toggle="tooltip"
											 data-trigger="hover" data-placement="top" data-title="Date of birth" data-parsley-required="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="gender">Gender</label>
											<select id="gender" name="gender" class="form-control" data-parsley-required="true">
												<option value="" selected="selected">---select gender---</option>
												<c:forEach var="gender" items="${genderList }">
												<option value="${gender }">${gender}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="userName">User name</label>
											<input type="text" id="userName" class="form-control" placeholder="User name" name="userName"
											 data-parsley-required="true" data-parsley-trigger="focusout" data-parsley-checkuname>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="age">Age</label>
											<input type="text" id="age" class="form-control" placeholder="Age" name="age" data-parsley-required="true" 
											data-parsley-pattern="^[1-9]{1,3}$">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
										<label>Password</label>
											<div class="position-relative has-icon-left">
											<input type="password" class="form-control" placeholder="password" name="password" id="password" data-parsley-required="true" 
											data-parsley-length=[8,16]>
											<div class="form-control-position" id="pwd"><i class="icon-eye-blocked"></i></div>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
										<label>Confirm password</label>
											<div class="position-relative has-icon-left">
											<input type="password" class="form-control" placeholder="Confirm passsword" id="confirmPwd" name="confirmPwd" 
											data-parsley-equalto="#password" data-parsley-required="true"  data-parsley-trigger="keyup">
											<div class="form-control-position" id="cnfPwd"><i class="icon-eye-blocked"></i></div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="address">Address</label>
											<textarea id="address" rows="5" class="form-control square" name="address" placeholder="comments" data-parsley-required="true"></textarea>
										</div>
									</div>
									<div class="col-md-6">
									<div class="form-group">
											<label>Account activation</label>
											<div class="input-group">
												<label class="display-inline-block custom-control custom-radio ml-1">
													<input type="radio" name="isActiveUser" class="custom-control-input" value="1">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Activate</span>
												</label>
												<label class="display-inline-block custom-control custom-radio">
													<input type="radio" name="isActiveUser" checked="checked" class="custom-control-input" value="0">
													<span class="custom-control-indicator"></span>
													<span class="custom-control-description ml-0">Deactivate</span>
												</label>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
								<div class="col-md-12">
								<div class="form-group">
									<label>Select File</label>
									<label id="projectinput7" class="file center-block">
										<input type="file" id="adminImage" name="adminImage">
										<span class="file-custom"></span>
									</label>
								</div>
								</div>
								</div>
								<div class="form-actions">
								<button type="button" class="btn btn-warning mr-1">
									<i class="icon-cross2"></i> Cancel
								</button>
								<button type="submit" class="btn btn-primary" id="submitBtn">
									<i class="icon-check2"></i> Submit
								</button>
								</div>
							</div>
							</form>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf"/>	
					</div>
				</div>
			</div>
		</div>
				</div>
			</section>
		</div>
	</div>
	</div>
</body>
<%@ include file="scripts.jsp" %>
<script type="text/javascript">
$(function(){
	$('#pwd').click(function(){
		var element = $(this).find('i'); 
		if(element[0].classList[0] === 'icon-eye-blocked')	{
			$(this).html('<i class="icon-eye3"></i>'); 
	    	$('#password').attr('type','text');
	    }
	    else	{
	    	$(this).html('<i class="icon-eye-blocked"></i>');
	    	$('#password').attr('type','password');
	    }
	});
	$('#cnfPwd').click(function(){
		var element = $(this).find('i');
		if(element[0].classList[0] === 'icon-eye-blocked')	{
			$(this).html('<i class="icon-eye3"></i>');
	    	$('#confirmPwd').attr('type','text');
	    }
		else	{
			$(this).html('<i class="icon-eye-blocked"></i>');
			$('#confirmPwd').attr('type','password');
		}
	});
	
	$('#register-form').parsley();
	$('#submitBtn').click(function(event){
		if($('#register-form').parsley().isValid())	{
			$('#submitBtn').html('<i class="icon-spinner3"></i> Saving');
			$('#submitBtn').attr('disbaled',true);
			//$('#register-form').submit();
		}
	});
});

var emailResult = true;
var uNameResult = true;
window.Parsley.addValidator('checkemail',{
	validateString: function (value)	{
		$.ajax({
			url : 'validate-admin-email',
			headers: {'X-CSRF-TOKEN': $("#csrf").val()},
			type : 'POST',
			contentType: 'application/json',
			data : JSON.stringify({'emailId': $('#emailId').val() }),
			async: false,
			success: function(data)	{
				if(data.emailExists == true)	{
					emailResult = false;
				}
				else	{
					emailResult = true;
				}
			}
		});
		return emailResult;
	},
	messages: {
		en: 'An account with this email already exists'
	}
});

window.Parsley.addValidator('checkuname',{
	validateString: function (value)	{
		$.ajax({
			url : 'validate-admin-user-name',
			headers: {'X-CSRF-TOKEN': $("#csrf").val()},
			type : 'POST',
			contentType: 'application/json',
			data : JSON.stringify({'userName': $('#userName').val() }),
			async: false,
			success: function(data)	{
				if(data.userNameExists == true)	{
					uNameResult = false;
				}
				else	{
					uNameResult = true;
				}
			}
		});
	return uNameResult;
	},
	messages: {
		en: 'An account with this username already exists'
	}
});

function validateImage()	{
	
}
</script>
</html>