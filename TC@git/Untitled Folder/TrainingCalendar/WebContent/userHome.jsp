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
<body >
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

		<h2>Welcome User</h2>
		<span style="float:left;">
		<form action="User" method="POST">
			<input type="submit" value="View" />
		</form>
		</span>
		<span style="float:right;">
		<form action="EditUser?key=<%=userName%>" method="POST">
			<input type="submit" value="Edit" />
		</form>
		<span style="float:right;">
		<form action="Logout" method="POST">
			<input type="submit" value="logout" />
		</form></span></span>
		
		<hr>
		<%
			Object value = null;
			value = request.getAttribute("msg");
			if (value != null) {
		%>

		<table cellspacing="0">

			<th>No</th>
			<th>Training_Date</th>
			<th>Training_Time</th>
			<th>Training_Topic</th>
			<!-- <th>Training_Group</th> -->
			<th>Trainer</th>
			<th>Training_Location</th>
			<%
				JSONArray jsonArray = new JSONArray(value.toString());
					for (int j = 0; j < jsonArray.length(); j++) {
						JSONObject jsonObject = new JSONObject(jsonArray.get(j)
								.toString());
			%>
			<tr>
				<td>
					<%
						out.print(j + 1);
					%>
				</td>
				<td><%=jsonObject.get("date").toString()%></td>
				<td><%=jsonObject.get("time").toString()%></td>
				<td><%=jsonObject.get("topic").toString()%></td>
				<td><%=jsonObject.get("trainer").toString()%></td>
				<td><%=jsonObject.get("location").toString()%></td>
				
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
			else
			{
			//out.print("Still we didn't allocate Training Schedule for your group");
			}
		%>
		<br>
		<hr>


	</div>
</body>
</html>