<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator list</title>
<%@include file="css.jsp"%>
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
                <h4 class="card-title">Administrator listing</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
 						<nav aria-label="Page navigation">
										<ul class="pagination pagination-sm">
											<li class="page-item">
												<a class="page-link" href="#" aria-label="Previous">
													<span aria-hidden="true">&laquo; Prev</span>
													<span class="sr-only">Previous</span>
												</a>
											</li>
											<li class="page-item"><a class="page-link" href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item active"><a class="page-link" href="#">3</a></li>
											<li class="page-item"><a class="page-link" href="#">4</a></li>
											<li class="page-item"><a class="page-link" href="#">5</a></li>
											<li class="page-item">
												<a class="page-link" href="#" aria-label="Next">
													<span aria-hidden="true">Next &raquo;</span>
													<span class="sr-only">Next</span>
												</a>
											</li>
										</ul>
									</nav>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                        <li><a data-action="close"><i class="icon-cross2"></i></a></li>
                    </ul>
                </div>
                
                		<form class="form" id="adminSearchForm">
							<div class="form-body">
								<h4 class="form-section"><i class="icon-head"></i> Admin search criteria</h4>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<input type="text" id="adminFirstName" class="form-control form-control-sm" placeholder="By first name" name="adminFirstName">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminFirstNameOperation" id="adminFirstNameOperation">
											<option value="">--select--</option>
											<c:forEach items="${textOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminFirstNameOperator" id="adminFirstNameOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="col-md-2">
										<div class="form-group">
											<input type="text" id="adminLastName" class="form-control form-control-sm" placeholder="By last name" name="adminLastName">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminLastNameOperation" id="adminLastNameOperation">
											<option value="">--select--</option>
											<c:forEach items="${textOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminLastNameOperator" id="adminLastNameOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<input type="text" id="adminEmail" class="form-control form-control-sm" placeholder="By Email" name="adminEmail">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminEmailOperation" id="adminEmailOperation">
											<option value="">--select--</option>
											<c:forEach items="${textOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminEmailOperator" id="adminEmailOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<input type="text" id="adminMobileNumber" class="form-control form-control-sm" placeholder="By mobile number" name="adminMobileNumber">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminMobileNumberOperation" id="adminMobileNumberOperation">
											<option value="">--select--</option>
											<c:forEach items="${textOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminMobileNumberOperator" id="adminMobileNumberOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<input type="text" id="adminAge" class="form-control form-control-sm" placeholder="By age" name="adminAge">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminAgeOperation" id="adminAgeOperation">
											<option value="">--select--</option>
											<c:forEach items="${numberFieldOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminAgeOperator" id="adminAgeOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select id="adminGender" name="adminGender" class="form-control form-control-sm">
												<option value="" selected="selected">---select gender---</option>
												<c:forEach var="gender" items="${genderList }">
												<option value="${gender }">${gender}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<div class="form-group">
											<select class="form-control form-control-sm" name="adminGenderOperation" id="adminGenderOperation">
											<option value="">--select--</option>
											<c:forEach items="${dropdownOperations }" var="op">
											<option value="${op }">${op}</option>
											</c:forEach>
											</select>
										</div>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control form-control-sm" name="adminGenderOperator" id="adminGenderOperator">
											<option value="">--select--</option>
											<c:forEach items="${sqlClauses }" var="clause">
											<option value="${clause }">${clause }</option>
											</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="form-actions">
								<button type="button" class="btn btn-warning btn-sm">
									<i class="icon-spinner11"></i> Reset
								</button>
								<button type="button" class="btn btn-primary btn-sm" id="searchBtn">
									<i class="icon-search4"></i> Search
								</button>
							</div>
						</form>
            </div>
            <div class="card-body collapse in">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="thead-inverse">
                            <tr>
                                <th>AdminId</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Mobile Number</th>
                                <th>Gender</th>
                                <th>Age</th>
                                <th>Status</th>
                                <th>Date Of Birth</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${admins }" var="admin">
                            <tr>
                                <th>${admin.adminId }</th>
                                <td>${admin.firstName}</td>
                                <td>${admin.lastName }</td>
                                <td>${admin.emailId }</td>
                                <td>${admin.mobileNumber }</td>
                                <td>${admin.gender }</td>
                                <td>${admin.age }</td>
                                <c:choose>
                                <c:when test="${admin.isActiveUser eq 1}">
                                <td><div class="tag tag-success">Active</div> </td>
                                </c:when>
                                <c:otherwise>
                                <td><div class="tag tag-danger">InActive</div> </td>
                                </c:otherwise>
                                </c:choose>
                                <td>${admin.dateOfBirth }</td>
                            </tr>
                        	</c:forEach>
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
<%@ include file="scripts.jsp" %>
<script type="text/javascript">
$('#searchBtn').click(function(){
	var adminFirstName = $('#adminFirstName').val();
	var adminFirstNameOperation = $('#adminFirstNameOperation').val();
	var adminFirstNameOperator = $('#adminFirstNameOperator').val();
	
	var adminLastName = $('#adminLastName').val();
	var adminLastNameOperation = $('#adminLastNameOperation').val();
	var adminLastNameOperator = $('#adminLastNameOperator').val();
	
	var adminEmail = $('#adminEmail').val();
	var adminEmailOperation = $('#adminEmailOperation').val();
	var adminEmailOperator = $('#adminEmailOperator').val();
	
	var adminMobileNumber = $('#adminMobileNumber').val();
	var adminMobileNumberOperation = $('#adminMobileNumberOperation').val();
	var adminMobileNumberOperator = $('#adminMobileNumberOperator').val();
	
	var adminAge = $('#adminAge').val();
	var adminAgeOperation = $('#adminAgeOperation').val();
	var adminAgeOperator = $('#adminAgeOperator').val();
	
	var adminGender = $('#adminGender').val();
	var adminGenderOperation = $('#adminGenderOperation').val();
	var adminGenderOperator = $('#adminGenderOperator').val();

	if($.trim(adminFirstName) !== "")	{
		if($.trim(adminFirstNameOperation) === "")	{
			$('#adminFirstNameOperation').addClass('form-control form-control-sm border-danger');
		}
		if($.trim(adminFirstNameOperator) === "")	{
			$('#adminFirstNameOperator').addClass('form-control form-control-sm border-danger');
		}
	}
	
});
</script>
</body>
</html>