<%@page import="org.training.jsonParser.JSONArray"%>
<%@page import="org.training.jsonParser.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="css/foundation.min.css" type="text/css">
<link rel="stylesheet" href="css/superfish.css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<title>Update User By Admin</title>
<link rel="stylesheet" type="text/css" href="css/pagestyle.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("table tr:nth-child(odd)").addClass("odd-row");
		$("table td:first-child, table th:first-child").addClass("first");
		$("table td:last-child, table th:last-child").addClass("last");
	});
</script>

</head>
<body>
	<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("index.html");
	%>
	<div class="call top-call-to-action">
		<div class="row">
			<div class="large-12 columns">
				<div class="social-icons"></div>

				<span><a href="#">Hi
						<%=userName%></a></span>
			</div>
		</div>
	</div>
	<div id="content">

		<!-- <form action="userHome.jsp" method="POST">
			<input type="image" src="img/user.png" alt="Submit" value="Home"
				width="25" height="25" />
		</form> -->

		<a href="adminHome.jsp">Home</a>&nbsp|
		<h2>User Updates by Admin</h2>
		<%
			Object value = null;
			value = request.getAttribute("msg");
			if (value != null) {
				JSONArray jsonArray = new JSONArray("[" + value.toString()
						+ "]");
				JSONObject jsonObject = new JSONObject(jsonArray.get(0)
						.toString());
				//out.println(jsonObject.get("group"));
		%>
		<form action="UpdateUser" method="post">
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstname" readonly
						value=<%=jsonObject.get("firstName").toString()%>></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastname" readonly
						value=<%=jsonObject.get("lastName").toString()%>></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><input type="email" name="email" readonly
						value=<%=jsonObject.get("email").toString()%>></td>
				</tr>
				<tr>
					<td>Group:</td>
					<td><select name="group">
							<option value="<%=jsonObject.get("group").toString()%>"><%=jsonObject.get("group").toString()%>
							</option>
							<option value="groupA">GroupA</option>
							<option value="groupB">GroupB</option>
							<option value="groupC">GroupC</option>
							<option value="groupD">GroupD</option>
							<option value="groupE">GroupE</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
		<!-- <form action="Logout" method="POST">
			<input type="image" src="img/out.png" alt="Submit" value="Logout"
				width="25" height="25" />
		</form> -->
		<%
			}
		%>
	</div>
</body>
</html>