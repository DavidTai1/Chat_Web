<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Style/registerStyle.css"/>
<link rel="stylesheet" href="Style/grid.css"/>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>Login to site</title>
</head>
<body>
<div class="row" id="toprow">

	<div class="col-12" style="padding: 0px 10px 0px 15px;"><h1 >Chat System</h1></div>

</div>
<div class="row">
<div class="hiddenspace" style="visibility: hidden" > _</div>
<div class="col-4">
	<h3 class="reg">Login</h3>
	<div class="inputs">
		<form action="login" method="post">
			Username:<input type="text" name="username" /><br /> Password:<input
				type="password" name="password" /><br /> <input type="submit"
				value="Login" />
		</form>
		<form action="back" method="post">
		<input type="submit"
				value="Back" />
		</form>
	</div >
	<c:if test='${ not empty param.err }'>
		<div class="error">
			<c:choose>
				<c:when test="${ param.err == '1.jsp' }">
					<h5>The username/password is incorrect</h5>
				</c:when>
				<c:when test="${ param.err == '2.jsp' }">
					<h5>The username is empty</h5>
				</c:when>
			</c:choose>
		</div>
	</c:if>
</div>
</div>
</body>
</html>