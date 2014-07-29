<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create New Event</title>


<link rel="stylesheet" type="text/css" href="css/pagestyle.css">
<script type="text/javascript" src="jquery.min.js"></script>
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
<!-- link rel="stylesheet" href="css/runnable.css" /> --> 



</head>
<body>
	<div id="content">
	<a href="adminHome.jsp">Home</a>&nbsp|
		<h2>Create New Event</h2>
		<form action="AddEvent" method="post">
			<table>
				<tr>
					<td>Date :</td>
					<td><input type="text" name="date" id="datepicker" required></td>
					<!-- <td><input type="text" name="date" required></td> -->
				</tr>
				<tr>
					<td>Time (hh:mm):</td>
					<td><input type="Time" name="time" required></td>
				</tr>
				<tr>
					<td>Group:</td>
					<td><select name="group">
							<option value="GroupA">Group A</option>
							<option value="GroupB">Group B</option>
							<option value="GroupC">Group C</option>
							<option value="GroupD">Group D</option>
							<option value="GroupE">Group E</option>
							
					</select></td>
				</tr>
				<tr>
					<td>Topic :</td>
					<td><select name="topic">
						<option value="AXIS2">AXIS2</option>
							<option value="Wso2 Products">Wso2 Products</option>
							<option value="REST">REST</option>
							<option value="ESB">ESB</option>
							<option value="Remote Debuging">Remote Debuging</option>
							<option value="Carbon">Carbon</option>
					</select></td>
				</tr>
				<tr>
					<td>Location :</td>
					<td><select name="location"> 			
							<option value="Area52">Area52</option>
							<option value="Kernel">Kernel</option>
							<option value="Boiler">Boiler</option>
							<option value="Cpu">Cpu</option>
					</select></td>
				</tr>

				<!-- <tr>
					<td>Trainer :</td>
					<td><input type="text" name="traniner" required></td>
				</tr> -->
				<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Add"></td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>