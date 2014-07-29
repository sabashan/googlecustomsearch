<%@page import="org.training.dao.EventDAO"%>
<%@page import="org.training.model.Event"%>
<%@page import="org.training.controller.GetEvent"%>
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

				<span><a href="editUserbyuser.jsp?id_email=<%=userName%>">Hi
						<%=userName%></a></span>
			</div>
		</div>
	</div>

	<div id="content">
	<a href="adminHome.jsp">Home</a>
		
		
		<%
			Object value = null;
			value = request.getAttribute("msg");
			if (value != null) {
		%>
	
	
		<h2>Training Details</h2>
		<hr>
		<form action="addnewEvent.jsp" method="POST">
			<input type="submit" value="Add Event" />
		</form> 
		<table cellspacing="0">

			<th>No</th>
			<th>Training_Date</th>
			<th>Training_Time</th>
			<th>Training_Topic</th>
			<th>Trainer</th>
			<th>Training_Group</th>
			<th>Training_Location</th>
			<th>Edit</th>
			<th>Delete</th>
	

			<%
				JSONArray jsonArray = new JSONArray(value.toString());

					for (int j = 0; j < jsonArray.length(); j++) {
						JSONObject jsonObject = new JSONObject(jsonArray.get(j)
								.toString());
			%>
			<tr>
				<td><%=j+1%></td>
				<td><%=jsonObject.get("date").toString()%></td>
				<td><%=jsonObject.get("time").toString()%></td>
				<td><%=jsonObject.get("topic").toString()%></td>
				<td><%=jsonObject.get("trainer").toString()%></td>
				<td><%=jsonObject.get("group").toString()%></td>
				<td><%=jsonObject.get("location").toString()%></td>
				<td>


					<form
						action="EditEvent?eventId=<%=jsonObject.get("id").toString()%>"
						method="POST">
						<input type="image" src="img/edit.png" alt="Submit" value="edit" />
					</form>
				</td>
				<td>					
					<form
						action="DeleteEvent?eventId=<%=jsonObject.get("id").toString()%>"
						method="POST">
						<input type="image" src="img/delete.png" alt="Submit" value="delete" />
					</form>

				</td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<hr>
		<%
			}
		%>

	</div>
</body>
</html>