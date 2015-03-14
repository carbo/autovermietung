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
	<center><h1>Autovermietung</h1>
		<form action="leihe" method="post">
  			<p>Geben Sie Ihre Wunsch an:</p>
  			<table style="width:40%">
  				<c:forEach var="auto" items="${autos}">
  				<tr style="height:30px">
					<td><input type="submit" ${ auto.frei ? '' : 'disabled="disabled"'} name="${auto.kennzeichen}" value="Ausleihen"></td><td><input type="submit" ${ auto.frei ? 'disabled="disabled"' : ''} name="${auto.kennzeichen}" value="Zur&uuml;ckgeben"></td><td> ${auto.kennzeichen}</td>
  				</tr>
				</c:forEach>
  			</table>
		</form>
		<br>
		<br>
		<form action="createOrDelete">
		<table style="width:40%">
			<td><input type="submit" name="anlegen" value="Neues KFZ anlegen"/></td><td><input type="submit" value="KFZ löschen"/></td>
		</table>
		</form>
	</center>
</html>