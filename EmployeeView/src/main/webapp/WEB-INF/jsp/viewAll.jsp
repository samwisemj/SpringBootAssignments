<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>

<body>
				<h1 align="center">Account Details</h1>
				<jstl:if test="${requestScope.allCustomer.size() > 0 }">
					<table align="center">
						<tr>
							
							<th>Customer ID</th>
							<th>CustomerName</th>
							<th>Address</th>
						</tr>
						<jstl:forEach var="customer" items="${requestScope.allCustomer}">
							<tr>
								<td>${customer.id}</td>
								<td>${customer.name}</td>
								<td>${customer.address}</td>
							</tr>
						</jstl:forEach>
					</table>
				</jstl:if>
				<jstl:if test="${requestScope.allCustomer.size() == 0 }">
					<h4 align="center">No Customers Found!</h4>
				</jstl:if>
			</div>
			<div></div>
		</div>

