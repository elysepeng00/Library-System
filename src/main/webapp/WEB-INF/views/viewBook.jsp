<%@ include file="./include.jsp"%>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/tablebook.css" />

<html>
	<head>
		<title>Book Information</title>
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
				<table>
					<tr>
						<th>Book Name</th>
						<th>Author</th>
					</tr>
					
						<tr>
		   					<td>${bookToSearch.name}</td><td>${bookToSearch.author}</td>
						</tr>
					
				</table>
			</div>
			
		</center>
		


	</body>
</html>