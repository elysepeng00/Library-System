<%@ include file="./include.jsp"%>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/tablebook.css" />

<html>
	<head>
		<title>Search Books</title>
	</head>

	<body>
	<%@ include file="./homeNavbar.jsp"%>
		<center>
			<div>
				<form name="GetBookForm" action="./bookInfo.html" method="GET">
   				 	Book Name: <input type="TEXT" name="bookName">
   				 	<input type="submit" value="Search">
				</form>
			</div>
			
			<div>
				<table BORDER="1"  cellspacing="25" cellpadding="20">
					<tr>
						<th>Book Name</th>
						<th>Author</th>
					</tr>
					<c:forEach var="curBook" items="${bookList}">
						<tr>
		   					<td>${curBook.name}</td><td>${curBook.author}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		</center>
		


	</body>
</html>