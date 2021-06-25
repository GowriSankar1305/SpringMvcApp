<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing</title>
<%@include file="css.jsp"%>
<script src="https://kit.fontawesome.com/e0debb8dfe.js" crossorigin="anonymous"></script>
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
div.blockUI.blockMsg.blockElement	{
	border:none,
	width:0%
}
</style>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">
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
									<h4 class="card-title" id="basic-layout-form">Facilities</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
										<form class="form" action="save-facility" method="POST"
											id="facilityForm">
											<div class="form-body">
												<h4 class="form-section">
													<i class="icon-head"></i>Hotel facility
												</h4>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label for="projectinput1">Facility Name</label> <input
																type="text" id="facilityName" class="form-control"
																name="facilityName" required="required"
																data-parsley-pattern="^[a-zA-Z ]+$">
														</div>
													</div>
													<div class="col-md-6">
													<div class="form-group">
														<label for="projectinput1">Facility Icon</label> <input
																type="text" id="facilityIcon" class="form-control"
																name="facilityIcon" required="required"
																data-parsley-pattern="^[a-zA-Z0-9- ]+$">
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions">
												<button type="button" class="btn btn-warning mr-1">
													<i class="icon-spinner11"></i> Reset
												</button>
												<button type="submit" class="btn btn-primary" id="submitBtn">
													<i class="icon-check2"></i> Save
												</button>
											</div>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" id="csrf"/>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="card" id="facilitiesTable">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-form">Facilities list</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
                    <table class="table table-bordered mb-0">
                        <thead class="thead-inverse">
                            <tr>
                                <th>Facility id</th>
                                <th>Facility icon</th>
                                <th>Icon class</th>
                                <th>Facility name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyId">
                        	<c:choose>
                        		<c:when test="${facilities ne null and facilities.size() > 0}">
                        			<c:forEach items="${facilities }" var="facility" varStatus="index">
                        			<tr>
                        				<th scope="row" id="facilityId${index.count }">${facility.facilityId }</th>
                        				<td><i class="${facility.facilityIcon }"></i></td>
                        				<td id="iconClass${index.count }">${facility.facilityIcon }</td>
                        				<td id="facilityName${index.count}">${facility.facilityName }</td>
                        				<td><a href="javascript:editFacility(${index.count });"><i class="icon-pencil2"></i></a></td>
                        			</tr>	
                        			</c:forEach>
                        		</c:when>
                        		<c:otherwise>
                        			<tr>
                        			<td colspan="4" align="center" style="color:red;">No records found</td>
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

	<div class="modal fade text-xs-left" id="inlineForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel33" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form id="facilityUpdateForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<label class="modal-title text-text-bold-600" id="myModalLabel33">Edit facility</label>
				</div>
					<div class="modal-body">
						<label>Icon Class</label>
						<div class="form-group">
							<input type="text" class="form-control" id="editIconClass" required="required" data-parsley-pattern="^[a-zA-Z0-9- ]+$">
						</div>
						<label>Facility Name</label>
						<div class="form-group">
							<input type="text" class="form-control" id="editFacilityName" required="required" data-parsley-pattern="^[a-zA-Z ]+$">
						</div>
						<label>Facility Icon</label>
						<div class="form-group">
							<div class="col-md-4 col-sm-6 col-xs-12 fonticon-container">
                            <div class="fonticon-wrap"><i id="editIcon"></i></div>
                          	</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="reset" class="btn btn-outline-secondary" data-dismiss="modal" value="close">
						<input type="button" class="btn btn-outline-primary" value="Save changes" id="editBtn">
					</div>
			</div>
			</form>
		</div>
	</div>
</body>
<%@ include file="scripts.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#facilityForm').parsley();
		$('#submitBtn').click(function(event) {
			if ($('#facilityForm').parsley().isValid()) {
				$('#submitBtn').html('<i class="icon-spinner3"></i> Saving');
				$('#submitBtn').attr('disbaled', true);
			}
		});
	});
	function editFacility(index) {
		var iconClass = $('#iconClass'+index).html();
		var facilityName = $('#facilityName'+index).html();
		var facilityId = $('#facilityId'+index).html();
		$('#editIconClass').val(iconClass);
		$('#editFacilityName').val(facilityName);
		$('#editIcon').removeAttr('class');
		$('#editIcon').addClass(iconClass);
		$('#inlineForm').modal('show');
		
		$('#facilityUpdateForm').parsley();
		$('#editBtn').click(function(event) {
			if ($('#facilityUpdateForm').parsley().isValid()) {
				$.ajax({
					url : 'update-facility',
					headers: {'X-CSRF-TOKEN': $("#csrf").val()},
					type : 'POST',
					contentType: 'application/json',
					data : JSON.stringify({
							 'facilityId': Number.parseInt(facilityId),
							 'facilityIcon': $('#editIconClass').val(),
							 'facilityName': $('#editFacilityName').val()}),
					async: false,
					success: function(data)	{
						$('#inlineForm').modal('hide');
					 	$('#tbodyId').empty();
					 	$('#facilitiesTable').block({
							message : "<img src='resources/images/loading.gif' height='30px' widht='30px'>",
							css : {
								border : 'none',
								width : '0%'
							}
						});
					 	$.each(data,function(index,facility){
					 		var count = index + 1;
					 		var	row = "<tr>";
            				row+= "<th scope='row' id='facilityId"+count+"'>"+facility.facilityId+"</th>";
            				row+= "<td><i class='"+facility.facilityIcon+"'></i></td>";
            				row+= "<td id='iconClass"+count+"'>"+facility.facilityIcon+"</td>";
            				row+= "<td id='facilityName"+count+"'>"+facility.facilityName+"</td>";
            				row+= "<td><a href='javascript:editFacility("+count+");'><i class='icon-pencil2'></i></a></td>";
            				row+= "</tr>";
            				$('#tbodyId').append(row);
					 	});
						$("#facilitiesTable").unblock();
					}
				});
				$('#editBtn').html('<i class="icon-spinner3"></i> Saving');
				$('#editBtn').attr('disbaled', true);
			}
		});
	}
</script>
</html>