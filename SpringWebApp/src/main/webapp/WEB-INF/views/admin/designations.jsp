<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Designations</title>
<%@ include file="css.jsp"%>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">
				<!-- Basic Tag Input start -->
				<section id="basic-tag-input">
					<div class="row match-height">
						<div class="col-xl-12 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Department</h4>
								</div>
								<div class="card-body">
									<div class="card-block">
										<ul class="nav nav-tabs">
											<li class="nav-item"><a class="nav-link active"
												id="base-tab1" data-toggle="tab" aria-controls="tab1"
												href="#tab1" aria-expanded="true">Create Department</a></li>
											<li class="nav-item"><a class="nav-link" id="base-tab2"
												data-toggle="tab" aria-controls="tab2" href="#tab2"
												aria-expanded="false">View Departments</a></li>
										</ul>
										<div class="tab-content px-1 pt-1">
											<div role="tabpanel" class="tab-pane active" id="tab1"
												aria-expanded="true" aria-labelledby="base-tab1">
												<div class="col-md-12">
													<div class="card">
														<div class="card-body collapse in">
															<div class="card-block">
																<form class="form" action="save-document-types"
																	method="POST" id="roomtypeForm">
																	<div class="form-body">
																		<div class="row">
																			<div class="col-md-8">
																				<div class="form-group">
																					<label for="roomTypeName">Department name</label> <input
																						type="text" id="roomTypeName" class="form-control"
																						name="roomTypeName" required="required"
																						data-parsley-pattern="^[a-zA-Z ]+$">
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-actions">
																		<button type="button" class="btn btn-warning mr-1">
																			<i class="icon-cross2"></i> Reset
																		</button>
																		<button type="submit" class="btn btn-primary"
																			id="submitBtn">
																			<i class="icon-check2"></i> Save
																		</button>
																	</div>
																	<input type="hidden" name="${_csrf.parameterName}"
																		value="${_csrf.token}" />
																</form>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="tab-pane" id="tab2" aria-labelledby="base-tab2">
												<div class="col-md-12">
													<div class="card">
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
																			<c:when
																				test="${roomTypes ne null and roomTypes.size() > 0 }">
																				<c:forEach items="${roomTypes }" var="type"
																					varStatus="item">
																					<tr>
																						<th scope="row">${item.count }</th>
																						<td>${type.roomTypeId }</td>
																						<td>${type.roomTypeName }</td>
																					</tr>
																				</c:forEach>
																			</c:when>
																			<c:otherwise>
																				<tr>
																					<td colspan="3" align="center" class="text-danger">No
																						records found....</td>
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
										</div>
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
<%@ include file="scripts.jsp"%>
</html>