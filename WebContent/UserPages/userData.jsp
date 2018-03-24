<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User data!!!</h1>
	<h3>${ loggedInUser.username }'s data!</h3>
	<ul>
		<li>Broker name: ${ loggedInUser.portfolio.broker.name }</li>
		<li>Shares:
			<ul>
				<c:forEach items="${ loggedInUser.portfolio.stocks }" var="stock">
					<li>${ stock.symbol }: ${ stock.companyName }</li>
				</c:forEach>
			</ul>
		</li>
	</ul>
	<a href="logout">Log out</a>
</body>
</html>