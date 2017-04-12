<%@ include file="./include.jsp"%>
<html>
<head>
	<title>New Student Information</title>
	<style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style>
</head>
<body>
<%@ include file="./homeNavbar.jsp"%>
<center>
<h1>Please Enter Your Profile</h1>

  <form:form action="./processNewStudentProfile" method="POST" commandName="student">
  <table>
  	<tr>
  	<td><fmt:message key="lastnameLabel" /></td>
        <td><form:input path="lastName" />
            <form:errors path="lastName" cssClass="error"/>
        </td>
    </tr>
    <tr>
  	<td><form:label path="firstName">First Name</form:label></td>
        <td><form:input path="firstName" />
            <form:errors path="firstName" cssClass="error"/>
        </td>
    </tr>
    <tr>
    <td><form:label path="age">Age</form:label></td>
        <td><form:input path="age" />
            <form:errors path="age" cssClass="error"/>
        </td>
    </tr>
    <tr>
    <td><form:label path="gender">Gender</form:label></td>
    <td><form:radiobutton path="gender" value="Male" checked="true"/> Male<br>
	<form:radiobutton path="gender" value="Female"/> Female<br></td>
	</tr>
	<tr>
    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
    </tr>
    </table>
  </form:form>
 </center>
</body>
</html>
