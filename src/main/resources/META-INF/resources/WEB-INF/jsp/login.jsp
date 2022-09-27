<html>
	<head>
		<title> My first HTML Page - login page</title>
	</head>
	<body>
		<h1>welcome to login page!</h1>
		
		<pre>${errorMessage}</pre>
		<form method="post">
		  Name: <input type="text" name="name">
		  Password: <input type="text" name="password">
		  <input type="submit">
		</form>
<%@ include file="common/footer.jspf"%>