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
			<div id="job-details">
				<p style="font-size: 20px;display: block;height: 30px;line-height: 60px;">Job Details</p>
				<div class="cd-jobName cd-attr">
					<p class="cd-attr-left">Job Name:</p>
					<p id="jd_jobName">...</p>
				</div>
				<div id="jd_count" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Count:</p>
				</div>
				<div id="jd_rating" class="cd-vacancies cd-attr">
					<p class="cd-attr-left" style="float: left;">Rating:</p>
					<!--<p>1230</p>-->
				</div>
				<div id="jd_companies" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Companies:</p>
					<!--<p>Apple Inc.</p>-->
				</div>
			</div>
		</div>
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/job.js"></script>

</html>