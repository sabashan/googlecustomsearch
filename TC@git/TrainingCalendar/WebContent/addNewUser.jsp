<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Training Calendar | User Register</title>
<link rel="stylesheet" type="text/css" href="css/pagestyle.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("table tr:nth-child(odd)").addClass("odd-row");
		$("table td:first-child, table th:first-child").addClass("first");
		$("table td:last-child, table th:last-child").addClass("last");
	});
	function checkForm(form) {
		if (form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
			if (form.pwd1.value.length < 6) {
				alert("Error: Password must contain at least six characters!");
				form.pwd1.focus();
				return false;
			}

			re = /[0-9]/;
			if (!re.test(form.pwd1.value)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.pwd1.focus();
				return false;
			}
			re = /[a-z]/;
			if (!re.test(form.pwd1.value)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.pwd1.focus();
				return false;
			}
			re = /[A-Z]/;
			if (!re.test(form.pwd1.value)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.pwd1.focus();
				return false;
			}
		} else {
			alert("Error: Please check that you've entered and confirmed your password!");
			form.pwd1.focus();
			return false;
		}
	}
</script>

</head>
<body>
	<div id="content">
		<h2>Register New User</h2>
		<form onsubmit="return checkForm(this);" action="AddUser"
			method="POST">
			<table>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstname" required></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastname" required></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td><label for="pass1">Password:</label></td>
					<td><input name="pwd1" id="pwd1" type="password" required></td>
				</tr>
				<tr>
					<td><label for="pass2">Confirm-Password:</label></td>
					<td><input name="pwd2" id="pwd2"
						onkeyup="checkPass(); return false;" type="password" required>
						<span id="confirmMessage" class="confirmMessage"></span></td>
				</tr>

				<tr>
					<td>Group:</td>
					<td><select name="group">
							<option value="GroupA">GroupA</option>
							<option value="GroupB">GroupB</option>
							<option value="GroupC">GroupC</option>
							<option value="GroupD">GroupD</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><input type="text" name="role" value="user" readonly></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Add"></td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>
