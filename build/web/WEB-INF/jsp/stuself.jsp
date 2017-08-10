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
			<div id="stuself-left">
				<table class="stu-table" style="font-size: 20px;">
					<tr><td colspan="4" style="text-align: center;font-size: 30px;">Student Details</td></tr>
					<tr>
						<td colspan="2" style="color: darkgray;text-align: left;">User(For Login)</td>
					</tr>
					<tr>
						<td class="stu-label">UserID:</td>
						<td><input id="stu-uid" type="text" disabled="disabled" /></td>
					</tr>
					<tr>
						<td class="stu-label">Password:</td>
						<td><input id="stu-password" type="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><input id="update-login" type="button" value="Update" /></td>
					</tr>
					<tr>
						<td colspan="2" style="color: darkgray;text-align: left;">Student(For Show)</td>
					</tr>
					<tr>
						<td class="stu-label">StudentID:</td>
						<td><input id="stu-stuid" type="text" /></td>
						<td class="stu-label">Sex:</td>
						<td><input id="stu-sex" type="text" /></td>
					</tr>
					<tr>
						<td class="stu-label">Name:</td>
						<td><input id="stu-name" type="text" /></td>
						<td class="stu-label">Region:</td>
						<td><input id="stu-region" type="text" /></td>
					</tr>
					<tr>
						<td class="stu-label">Institute:</td>
						<td><input id="stu-inst" type="text" /></td>
						<td class="stu-label">Specialize:</td>
						<td><input id="stu-spec" type="text" /></td>
					</tr>
					<tr>
						<td class="stu-label">Grade:</td>
						<td><input id="stu-grade" type="text" /></td>
						<td class="stu-label">Phone:</td>
						<td><input id="stu-phone" type="text" /></td>
					</tr>
					<tr>
						<td class="stu-label">QQorWechat:</td>
						<td><input id="stu-qw" type="text" /></td>
						<td class="stu-label">Others:</td>
						<td><input id="stu-others" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2" style="color: darkgray;text-align: left;">Work(For Show)</td>
					</tr>
					<tr>
						<td class="stu-label">Company:</td>
						<td>
							<select style="width: 100%;" id="stu-company">
							</select>
						</td>
						<td class="stu-label">Job:</td>
						<td>
							<select style="width: 100%;" id="stu-job" />
						</td>
					</tr>
					<tr>
						<td class="stu-label">Skills:</td>
						<td>
							<select id="stu-skills" multiple="multiple" style="width: 100%;">
								<!--<option>fffff</option>
								<option>fffff</option>
								<option>fffff</option>-->
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input id="update-details" type="button" value="Update" /></td>
					</tr>
				</table>
			</div>
			<div id="stuself-right">
				<p style="font-weight: bold;font-size: 20px;margin-bottom: 10px;">Notifications</p>
				<!--<div class="notis">
					<p class="noti-com">Apple Inc.:</p>
					<br/>
					<p class="noti-msg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</p>
				</div>-->
				<!--<div class="notis">
					<p class="noti-com">Apple Inc.:</p>
					<br/>
					<p class="noti-msg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</p>
				</div>
				<div class="notis">
					<p class="noti-com">Apple Inc.:</p>
					<br/>
					<p class="noti-msg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss</p>
				</div>-->
			</div>
		</div>
		<!--<div class="bg-model">
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
					</div>
				</div>
				<div class="form_btn">
					<input class="form_btnn" type="button" value="Submit" />
				</div>
			</div>
		</div>-->
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/stuself.js"></script>

</html>