<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/foundation.min.css" type="text/css">
<link rel="stylesheet" href="css/superfish.css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/pagestyle.css">
<title>Training Calendar | Training Details</title>

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

				<span><a href="#">Hi <%=userName%></a></span>
			</div>
		</div>
	</div>
	<div id="content">
		<h2>Welcome Admin</h2>
		<span style="float: left;">
			<form action="GetUsers" method="POST">
				<input type="submit" value="users" />
			</form>
			<form action="GetEvent" method="POST">
				<input type="submit" value="events" />
			</form>
		</span> <span style="float: right;">
			<form action="Logout" method="POST">
				<input type="submit" value="logout" />
			</form>
		</span>

	<!-- 	<hr>
		<table cellspacing="0">

			<th>No</th>
			<th>Training_Date</th>
			<th>Training_Time</th>
			<th>Training_Topic</th>
			<th>Training_Group</th>
			<th>Trainer</th>
			<th>Training_Location</th>
			<th>Edit</th>
			<th>Delete</th>
			
		</table>

		<br> -->
		<hr>

	</div>
</body>
</html>