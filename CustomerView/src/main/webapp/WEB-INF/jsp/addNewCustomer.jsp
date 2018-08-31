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
	<form action="addNewCustomer" method="post">
		<input type="text" name="id" id="id" placeholder="id" /> <input
			type="text" name="name" id="name" placeholder="name" /> <input
			type="text" name="address" id="addres" placeholder="address" /> <input
			type="submit" value="Submit">
	</form>
</body>