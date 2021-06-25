<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Countries list</title>
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
								<h4 class="card-title">Countries list</h4>
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
									<c:if test="${numbers ne null and numbers.size() gt 0}">
									<div class="col-md-2">
										<div class="form-group">
											<label for="pageDropdown">Page No</label>
											<select id="pageDropdown" class="form-control">
												<c:forEach items="${numbers }" var="no">
												<option value="${no.commaSeparatedIds }" ${no.isActive eq true ? 'selected' : '' }>${no.pageNumber }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									</c:if>
								</div>
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead class="thead-inverse">
												<tr>
													<th>SNo</th>
													<th>Country Id</th>
													<th>Country Name</th>
													<th>Country Code</th>
													<th>Country Flag</th>
													<th>Phone Code</th>
												</tr>
											</thead>
											<tbody id="tbody">
												<c:choose>
													<c:when test="${countries ne null and countries.size() > 0}">
														<c:forEach items="${countries }" var="country" varStatus="index">
															<tr>
															<th scope="row">${index.count }</th>
															<th scope="row" id="countryId${index.count }">${country.countryId }</th>
															<td id="countryName${index.count }">${fn:toUpperCase(country.countryName) }</td>
															<td id="countryCode${index.count }">${country.countryCode }</td>
															<td><i class="flag-icon flag-icon-${fn:toLowerCase(country.countryCode) }"></i></td>
															<td id="phoneCode${index.count }">${country.phoneCode }</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
													<tr>
													<td colspan="5" align="center" style="color: red;font-weight: bold;">No Records Found...</td>
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
	$('#pageDropdown').change(function(){
		$.ajax({
			url : 'get-countries-by-ids',
			type: 'GET',
			data: {'ids':$(this).val()},
			success: function(data)	{
				$('#tbody').empty();
				$.each(data,function(index,country){
			 		var count = index + 1;
			 		var name = country.countryName.toUpperCase();
			 		var code = country.countryCode.toLowerCase();
			 		var	row = "<tr>";
			 		row+= "<th scope='row'>"+count+"</th>";
    				row+= "<th scope='row' id='countryId"+count+"'>"+country.countryId+"</th>";
    				row+= "<td id='countryName"+count+"'>"+name+"</td>";
    				row+= "<td id='countryCode"+count+"'>"+country.countryCode+"</td>";
    				row+= "<td><i class='flag-icon flag-icon-"+code+"'></i></td>";
    				row+= "<td id='phoneCode"+count+"'>"+country.phoneCode+"</td>";
    				row+= "</tr>";
    				$('#tbody').append(row);
				});
			}
		});		
	});
});
</script>
</html>