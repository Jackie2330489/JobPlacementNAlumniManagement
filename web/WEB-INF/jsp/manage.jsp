<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width" initial-scale="1" />
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<title>Job Placement and Alumni Management</title>
	</head>

	<body>
		<div id="page" style="text-align: center;">
			<div id="header">
				<div id="logo">
					<a href="index.jsp">Riviera University</a>
					<br>
					<a href="index.jsp" style="font-size: 15px;text-shadow: none;">Job Placement N Alumni Management</a>
				</div>
				<div id="search">
					<input id="search-input" placeholder="Search for jobs, vacancies, companies" autofocus="true" style="width:400px;" />
					<input id="search-btn" type="submit" value="Search" />
				</div>
				<div id="status_unlogin" class="unlogin-nav">
					<a href="login.jsp">Register</a> |
					<a href="login.jsp">Login</a>
				</div>
				<div id="status_login" class="login-nav" style="display: none;">
					<img id="login-img" src="../../../build/web/WEB-INF/jsp/photo/man_128px_1174196_easyicon.net.png" />
					<a id="login-a" href="#">....</a>
				</div>
				<div style="clear: both;"></div>
			</div>
			<br/>
			<div id="manage-left">
				<div id="ml-user">User</div>
				<div id="ml-student">Student</div>
				<div id="ml-company">Company</div>
				<div id="ml-vacancy">Vacancy</div>
			</div>
			<div id="manage-right">
				<input class="manage-btn" type="button" value="Add User" />
				<div style="clear: both;"></div>
				<br>
				<table id="show_table" class="gridtable">
					<!--<tr>
						<th>aaa</th>
						<th>bbb</th>
						<th>ccc</th>
						<th>ddd</th>
					</tr>
					<tr>
						<td>123</td>
						<td>123</td>
						<td>321</td>
						<td>232</td>
					</tr>-->
				</table>
			</div>
		</div>
		<div class="bg-model">
			<div class='model-content'>
				<a class="bg-model-ok" href="#">X</a>
				<div style="clear: both;"></div>
				<div id="form_name">Add User</div>
				<div class="form_content">
					<!--<div class="form_li">
						<p>UserId:</p>
						<input id="for" type="text" />
					</div>
					<div class="form_li">
						<p>UserId:</p>
						<input type="text" />
					</div>
					<div class="form_li">
						<p>UserId:</p>
						<input type="text" />
					</div>-->
				</div>
				<div class="form_btn">
					<input class="form_btnn" type="button" value="Submit" />
				</div>
			</div>
		</div>
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/manage.js"></script>

</html>