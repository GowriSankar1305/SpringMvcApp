<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room types</title>
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
					<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title" id="basic-layout-form">Room type creation</h4>
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
						<form class="form" action="save-document-types" method="POST" id="roomtypeForm">
							<div class="form-body">
								<h4 class="form-section"><i class="icon-clipboard2"></i> Room type name</h4>
								<div class="row">
									<div class="col-md-8">
										<div class="form-group">
											<label for="roomTypeName">Room Type</label>
											<input type="text" id="roomTypeName" class="form-control" 
											name="roomTypeName" required="required" data-parsley-pattern="^[a-zA-Z ]+$">
										</div>
									</div>
								</div>
							</div>
							<div class="form-actions">
								<button type="button" class="btn btn-warning mr-1">
									<i class="icon-cross2"></i> Reset
								</button>
								<button type="submit" class="btn btn-primary" id="submitBtn">
									<i class="icon-check2"></i> Save
								</button>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
				<h4 class="card-title" id="basic-layout-colored-form-control">Room types list</h4>
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
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="thead-inverse">
                            <tr>
                                <th>S.no</th>
                                <th>Room type id</th>
                                <th>Room type</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                            	<c:when test="${roomTypes ne null and roomTypes.size() > 0 }">
                            	<c:forEach items="${roomTypes }" var="type" varStatus="item">
                            	<tr>
                                	<th scope="row">${item.count }</th>
                                	<td>${type.roomTypeId }</td>
                                	<td>${type.roomTypeName }</td>
                            	</tr>
                            	</c:forEach>
                            	</c:when>
                            	<c:otherwise>
                                <tr>
                                	<td colspan="3" align="center" class="text-danger">No records found....</td>
                            	</tr>
                            	</c:otherwise>
                            </c:choose>
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
	$('#roomtypeForm').parsley();
	$('#submitBtn').click(function(event){
		if($('#roomtypeForm').parsley().isValid())	{
			$('#submitBtn').html('<i class="icon-spinner3"></i> Saving');
			$('#submitBtn').attr('disbaled',true);
		}
	});
});
</script>
</html>