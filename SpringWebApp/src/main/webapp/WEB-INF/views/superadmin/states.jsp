<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>States list</title>
<%@include file="css.jsp"%>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">States list</h4>
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
								<div class="card-block card-dashboard">
									<div class="col-md-3">
										<div class="form-group">
											<label for="countryDropdown">Select country</label>
											<select id="countryDropdown" class="form-control text-bold-500">
												<c:forEach items="${countries }" var="country">
												<option value="${country.countryId }" class="text-bold-500">${country.countryName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label for="pageNo">Page No</label>
											<select id="pageNo" class="form-control text-bold-500">
												<c:forEach items="${numbers }" var="no">
												<option value="${no.commaSeparatedIds }" class="text-bold-500">${no.pageNumber }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead class="thead-inverse">
												<tr>
													<th>SNo</th>
													<th>State Id</th>
													<th>State Name</th>
													<th>Country Id</th>
												</tr>
											</thead>
											<tbody id="tbody">
												<c:choose>
													<c:when test="${states ne null and states.size() > 0}">
														<c:forEach items="${states }" var="state" varStatus="index">
															<tr>
															<th scope="row">${index.count }</th>
															<th scope="row" id="stateId${index.count }">${state.stateId }</th>
															<td id="stateName${index.count }">${fn:toUpperCase(state.stateName) }</td>
															<td id="countryId${index.count }">${state.countryId }</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
													<tr>
													<td colspan="4" align="center" class="text-bold-500 red">No Records Found...</td>
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
</body>
<%@ include file="scripts.jsp"%>
<script type="text/javascript">
$(function(){
	$('#countryDropdown').change(function(){
		blockTable('tbody');
		$.ajax({
			url: 'get-state-page-numbers-by-country',
			type: 'GET',
			data: {'countryId':$(this).val()},
			success: function(data)	{
				$('#pageNo').empty();
				$.each(data,function(index,dto){
					$('#pageNo').append( $('<option>',{value:dto.commaSeparatedIds,text:dto.pageNumber}));
				});
				getStates($('#pageNo').val());
			}
		});
	});
	$('#pageNo').change(function(){
		blockTable('tbody');
		getStates($(this).val());
	});
	
	function getStates(ids)	{
		$.ajax({
			url: 'get-states-by-ids',
			type: 'GET',
			data: {'commaSeparatedIds':ids},
			success: function(data)	{
				$('#tbody').empty();
				$.each(data,function(index,state){
					var count = index + 1;
			 		var name = state.stateName.toUpperCase();
			 		var	row = "<tr>";
			 		row+= "<th scope='row'>"+count+"</th>";
					row+= "<th scope='row' id='stateId"+count+"'>"+state.stateId+"</th>";
					row+= "<td id='stateName"+count+"'>"+name+"</td>";
					row+= "<td id='countryId"+count+"'>"+state.countryId+"</td>";
					row+= "</tr>";
					$('#tbody').append(row);
				});
				unblockTable('tbody');
			}
		});
	}
	function blockTable(id)	{
		$('#'+id).block({
			message : "<img src='resources/images/loading.gif' height='30px' widht='30px'>",
			css : {
				border : 'none',
				width : '0%'
			}
		});
	}
	function unblockTable(id)	{
		$('#'+id).unblock();
	}
});
</script>
</html>