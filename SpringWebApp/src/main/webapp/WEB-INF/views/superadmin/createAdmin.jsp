<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin creation</title>
<%@include file="css.jsp"%>
<style type="text/css">
.error {
color: #99182c;
}
textarea.error	{
border:1.5px solid #99182c;
}
input.error	{
border:1.5px solid #99182c;
}
select.error {
border:1.5px solid #99182c;
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
						<form class="form" id="register-form" method="post">
							<div class="form-body">
								<h4 class="form-section"><i class="icon-head"></i> Admin Info</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="firstName">First Name</label>
											<input type="text" id="firstName" class="form-control" placeholder="First Name" name="firstName" required>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="lastName">Last Name</label>
											<input type="text" id="lastName" class="form-control" placeholder="Last Name" name="lastName" required>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="emailId">E-mail</label>
											<input type="email" id="emailId" class="form-control" placeholder="E-mail" name="emailId" required>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="mobileNumber">Mobile Number</label>
											<input type="text" id="mobileNumber" class="form-control" placeholder="Phone" name="mobileNumber" required>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="dateOfBirth">Date of birth</label>
											<input type="date" id="dateOfBirth" class="form-control" name="dateOfBirth" data-toggle="tooltip"
											 data-trigger="hover" data-placement="top" data-title="Date of birth" required="required">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="gender">Gender</label>
											<select id="gender" name="gender" class="form-control" required>
												<option value="" selected="selected">Gender</option>
												<option value="less than 5000$">less than 5000$</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="userName">User name</label>
											<input type="text" id="userName" class="form-control" placeholder="User name" name="userName" required>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="age">Age</label>
											<input type="text" id="age" class="form-control" placeholder="Age" name="age" required>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
										<label>Password</label>
											<div class="input-group">
											<input type="password" class="form-control" placeholder="password" name="password" id="password" required>
											<span class="input-group-addon" id="pwd"><i class="icon-eye-blocked"></i></span>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
										<label>Confirm password</label>
											<div class="input-group">
											<input type="password" class="form-control" placeholder="Confirm passsword" id="confirmPwd" name="confirmPwd" required>
											<span class="input-group-addon" id="cnfPwd"><i class="icon-eye-blocked"></i></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="address">Address</label>
											<textarea id="address" rows="5" class="form-control square" name="address" placeholder="comments" required></textarea>
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
										<input type="file" id="file">
										<span class="file-custom"></span>
									</label>
								</div>
								</div>
								</div>
								
								<div class="form-actions">
								<button type="button" class="btn btn-warning mr-1">
									<i class="icon-cross2"></i> Cancel
								</button>
								<button type="submit" class="btn btn-primary">
									<i class="icon-check2"></i> Save
								</button>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf"/>	
							</form>	
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-xs-12">
			<div class="card">					
            <div class="card-header">
                <h4 class="card-title">Administrator listing</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
 <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
  </ul>
</nav>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                        <li><a data-action="close"><i class="icon-cross2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body collapse in">
                <div class="table-responsive">
                    <table class="table">
                        <thead class="thead-inverse">
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Username</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                        </tbody>
                    </table>
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
	var msg = "";
	$('#register-form').validate({
		rules: {
			emailId: {
				email: true,
				remote: {
					url  : 'validate-admin-email',
					headers: {'X-CSRF-TOKEN': $("#csrf").val()},
					type : 'POST',
					contentType: 'application/json',
					data : JSON.stringify({'emailId': $('#emailId').val() }),
					success: function(data)	{
						if(data.statusCode !== 200)	{
							msg = data.errorMessage;
							return false;
						}
					},
					error: function(xhr, errorType, exception)	{
						console.log(errorType);
						console.log(exception);
						return false;
					}
				}
			}
		},
		messages: {
			emailId: {
				remote: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
			}
		}
	});
});
</script>
</html>