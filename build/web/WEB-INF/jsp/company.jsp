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
			<div id="company-details">
				<p style="font-size: 20px;display: block;height: 30px;line-height: 60px;">Company Details</p>
				<div class="cd-companyName cd-attr">
					<p class="cd-attr-left">Company Name:</p>
					<p id="cd_companyName">...</p>
				</div>
				<div id="cd_jobs" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Jobs:</p>
				</div>
				<div id="cd_vacancies" class="cd-vacancies cd-attr">
					<p class="cd-attr-left" style="float: left;">Vacancies:</p>
					<!--<div class="cd-vacancy-item">
						<p>Work</p>
						<p>Football Player</p>
						<p>2014-07-03</p>
						<a href="#">>></a>
					</div>-->
				</div>
				<div id="cd_students" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Students On Duty:</p>
					<!--<a href="#">Apple Inc.</a>,<p>Apple Inc.</p>-->
				</div>
			</div>
		</div>
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/company.js"></script>

</html>