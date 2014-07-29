<%@page import="org.training.jsonParser.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<head>
<title>Edit Event</title>
<link rel="stylesheet" type="text/css" href="css/pagestyle.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("table tr:nth-child(odd)").addClass("odd-row");
		$("table td:first-child, table th:first-child").addClass("first");
		$("table td:last-child, table th:last-child").addClass("last");
	});
</script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="js/script.js"></script>
<!-- <link rel="stylesheet" href="css/runnable.css" /> -->

</head>
<body>
	<div id="content">
		<a href="adminHome.jsp">Home</a>&nbsp|
		<h2>Edit Event</h2>
		<%
			Object value = null;
			value = request.getAttribute("msg");
			if (value != null) {

				JSONObject js = new JSONObject(value.toString());
		%>
		<form action="UpdateEvent?key=<%=js.get("id").toString()%>"
			method="post">
			
			<table>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="date" id="datepicker" required value=<%=js.get("date").toString()%>></td>
					<%-- <td><input type="text" name="date"
						value=<%=js.get("date").toString()%>></td> --%>
				</tr>
				<tr>
					<td>Time:</td>
					<td><input type="text" name="time"
						value="<%=js.get("time").toString()%>"></td>
				</tr>
				<tr>
					<td>Topic:</td>
					<td><select name="topic">
							<option value="<%=js.get("topic").toString()%>"><%=js.get("topic").toString()%></option>
							<option value="AXIS2">AXIS2</option>
							<option value="Wso2 Products">Wso2 Products</option>
							<option value="REST">REST</option>
							<option value="ESB">ESB</option>
							<option value="Remote Debuging">Remote Debuging</option>
							<option value="Carbon">Carbon</option>
					</select></td>
				</tr>
				<tr>
					<td>Group:</td>
					<td><select name="group">
							<option value="<%=js.get("group").toString()%>"><%=js.get("group").toString()%></option>
							<option value="GroupA">GroupA</option>
							<option value="GroupB">GroupB</option>
							<option value="GroupC">GroupC</option>
							<option value="GroupD">GroupD</option>
							<option value="GroupE">GroupE</option>
					</select></td>
				</tr>

				<tr>
					<td>Location:</td>
					<td><select name="location">
							<option value="<%=js.get("location").toString()%>"><%=js.get("location").toString()%></option>
							<option value="Boiler">Boiler</option>
							<option value="Area52">Area52</option>
							<option value="Carbon">Carbon</option>
							<option value="Kernel">Kernel</option>
							<option value="Cpu">Cpu</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Update"></td>

				</tr>
			</table>
		</form>
		<%
			}
		%>
	</div>
</body>
</html>