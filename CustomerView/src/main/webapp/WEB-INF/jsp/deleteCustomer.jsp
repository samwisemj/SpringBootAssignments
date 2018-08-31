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
	<form action="deleteCustomer" method="post">
		<input type="text" name="id" id="id" placeholder="id" /> 
		<input type="submit" value="Submit">
	</form>
</body>