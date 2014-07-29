<%@page import="org.training.dao.EventDAO"%>
<%@page import="org.training.model.Event"%>
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
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("index.html");
%>
<div class="call top-call-to-action">
  <div class="row">
    <div class="large-12 columns">
      <div class="social-icons">      
      </div>
   
      <span><a href="editUserbyuser.jsp?id_email=<%=userName%>">Hi <%=userName %></a></span> </div>
  </div>
</div>




	<div id="content">
		<h2>My Training Details</h2>
	
		<table cellspacing="0">

			<th>No</th>
			<th>Training Date</th>
			<th>Training Time</th>
			<th>Training Topic</th>
			<th>Training Group</th>
			<th>Training Location</th>						
			<%
				EventDAO dao = new EventDAO();
				int i = 1;
				for (Event e : dao.findAll()) {
					out.print("<tr>");
					out.print("<td>" + i + "</td>");
					out.print("<td>" + e.getDate() + "</td>");
					out.print("<td>" + e.getTime() + "</td>");
					out.print("<td>" + e.getTopic() + "</td>");
					out.print("<td>" + e.getGroup() + "</td>");
					out.print("<td>" + e.getLocation() + "</td>");
					i++;		
				}
			%>
		</table>
		
		<hr>

	<form action="index.html" method="POST" >
<input type="submit" value="logout" />
</form>

	</div>
</body>
</html>