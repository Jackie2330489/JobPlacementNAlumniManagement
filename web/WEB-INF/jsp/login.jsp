<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
				<div id="status_unlogin" class="unlogin-nav" >
					<a href="login.jsp">Register</a> |
					<a href="login.jsp">Login</a>
				</div>
				<div id="status_login" class="login-nav" style="display: none;">
					<img id="login-img" src="../../../build/web/WEB-INF/jsp/photo/man_128px_1174196_easyicon.net.png" />
					<a id="login-a" href="#">....</a>
				</div>
				<div style="clear: both;"></div>
			</div>
			<br>
			<div class="loginpage-left">
				<div class="register-div">
					<table class="register-table">
						<th style="text-align: center;padding-bottom: 10px;">Register Form</th>
						<tr>
							<td colspan="2" style="text-align: left;font-size: 15px;color: darkgray;">User and Password(For Login):</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">UserID</td>
							<td class="register-td">
								<input id="register-uid" type="text" maxlength="12" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Password</td>
							<td class="register-td">
								<input id="register-pwd" type="password" maxlength="20" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">RePassword</td>
							<td class="register-td">
								<input id="register-repwd" type="password" maxlength="20" />
							</td>
						</tr>
						<tr style="height: 17px;">
							<td colspan="2"><p class="msg" id="register-uid-msg"></p></td>
						</tr>
						
						<tr>
							<td colspan="2" style="text-align: left;font-size: 15px;color: darkgray;padding-top: 10px;">Student Details(For Activaction):</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">StudentID</td>
							<td class="register-td">
								<input id="register-stuid" type="text" maxlength="12"/>
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Name</td>
							<td class="register-td">
								<input id="register-name" type="text" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Sex</td>
							<td class="register-td">
								<input name="sex" type="radio" value="male" />Male
								<input name="sex" type="radio" value="female" />Female
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Grade</td>
							<td class="register-td">
								<input id="register-grade" type="number" maxlength="4"/>
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Region</td>
							<td class="register-td">
								<input id="register-region" type="text" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Institute</td>
							<td class="register-td">
								<input id="register-inst" type="text" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Specialize</td>
							<td class="register-td">
								<input id="register-spec" type="text" />
							</td>
						</tr>
						<tr class="register-tr">
							<td class="register-td">Phone</td>
							<td class="register-td">
								<input id="register-phone" type="text" maxlength="11"/>
							</td>
						</tr>
						<tr style="height: 17px;">
							<td colspan="2"><p class="msg" id="register-stu-msg"></p></td>
						</tr>
						<tr class="register-tr">
							<td class="register-td" colspan="2" style="text-align: right;"><input type="button" id="register-btn" value="Register" /></td>
						</tr>
						<tr style="height: 17px;">
							<td colspan="2"><p class="msg" id="register-btn-msg"></p></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="loginpage-right">
				<div class="login-div">
					<table class="login-table">
						<th style="text-align: center;padding-bottom: 10px;">Login Form</th>
						<tr class="login-tr">
							<td class="login-td login-label">UserID</td>
							<td class="login-td login-input">
								<input id="login-uid" type="text" maxlength="12"/>
							</td>
						</tr>
						<tr class="login-tr">
							<td class="login-td login-label">Password</td>
							<td class="login-td login-input">
								<input id="login-pwd" type="password" maxlength="20"/>
							</td>
						</tr>
						<tr style="height: 17px;">
							<td colspan="2"><p class="msg" id="login-msg"></p></td>
						</tr>
						<tr class="login-tr">
							<td class="login-td login-button" colspan="2" style="text-align: right;">
								<input id="login-btn" type="button" value="Login" />
							</td>
						</tr>
						<tr style="height: 17px;">
							<td colspan="2"><p class="msg" id="login-btn-msg"></p></td>
						</tr>
					</table>
				</div>
				<div class="login-ps">
					<p>PS:</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;After registration, students can only login if once verified and allowed by the manager to mark as active user.</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Students can update the profile and login infomations after activaction.</p>
				</div>
			</div>
		</div>
	</body>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>

</html>