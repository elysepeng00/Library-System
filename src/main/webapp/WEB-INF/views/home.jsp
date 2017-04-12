<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Library Home Page</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./homeNavbar.jsp"%>
<center>
<h1>Welcome to P. Library</h1>
<img src="${context}/resources/images/libraryhome.jpg" width="800" height="300">
<br>
<br>
<br>
</center>
</div>
</body>
</html>
