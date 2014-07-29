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
<link rel="stylesheet" href="css/runnable.css" />

</head>
<body>
	<div id="content">
		<h3>Create New Event</h3>
		<form action="#" method="post">
			<table>
				<tr>
					<td>Date:</td>
					<td><input type="text" name="date" id="datepicker" required></td>
				</tr>
				<tr>
					<td>Time:</td>
					<td><input type="Time" name="time" required></td>
				</tr>
				<tr>
					<td>Group:</td>
					<td><select name="group">
							<option value="group1">Group 1</option>
							<option value="group2">Group 2</option>
							<option value="group3">Group 3</option>
							<option value="group4">Group 4</option>
							<option value="group5">Group 5</option>
					</select></td>
				</tr>
				<tr>
					<td>Topic :</td>
					<td><select name="topic">
							<option value="ESB">ESB</option>
							<option value="ESB">AS</option>
							<option value="ESB">IS</option>
							<option value="ESB">Carbon</option>
					</select></td>
				</tr>
				<tr>
					<td>Location :</td>
					<td><select name="location">
							<option value="location">kenel</option>
							<option value="location">3rd floor</option>
							<option value="location">4th</option>
							<option value="location">7th</option>
					</select></td>
				</tr>

				<tr>
					<td>Trainer :</td>
					<td><input type="text" name="traniner" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>