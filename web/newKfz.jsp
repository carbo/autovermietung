<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>
<html>
<head>
      <title>Bootstrap 101 Template</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Bootstrap -->
      <link href="css/bootstrap.css" rel="stylesheet">
      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
         queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page
           via file:// -->
   <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/
         html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/
         respond.min.js"></script>
   <![endif]-->
</head>
<a href="<c:url value="logout" />" > Logout</a>
	<center><h1>Autovermietung-Neue KFZs</h1>
		<form action="saveCar" method="post">
		<table style="width:40%">
		<tr style="height:30px">
  				<td>Kennzeichen: </td><td><input type="text" name="kennzeichen"></td>
  		</tr>
  		<tr style="height:30px">
  				<td>Kilometer: </td><td><input type="text" name="km"></td>
  		</tr>
  		</table>
  		<input type="submit" value="Save">
		</form>
	</center>
</html>