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
			<div id="student-details">
				<p style="font-size: 20px;display: block;height: 30px;line-height: 60px;">Student Details</p>
				<div id="sd_id" class="cd-companyName cd-attr2">
					<p class="cd-attr-left">Student ID:</p>
				</div>
				<div id="sd_name" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Name:</p>
				</div>
				<div id="sd_sex" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Sex:</p>
				</div>
				<div id="sd_region" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Region:</p>
				</div>
				<div id="sd_grade" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Grade:</p>
				</div>
				<div id="sd_inst" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Institute:</p>
				</div>
				<div id="sd_spec" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Specialize:</p>
				</div>
				<div id="sd_phone" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Phone:</p>
				</div>
				<div id="sd_email" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Email:</p>
				</div>
				<div id="sd_qw" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">QQ or Wechat:</p>
				</div>
				<div id="sd_others" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Others:</p>
				</div>
				<div id="sd_company" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Company:</p>
				</div>
				<div id="sd_skills" class="cd-jobs cd-attr2">
					<p class="cd-attr-left">Skills:</p>
				</div>
				<!--<div id="vd_createtime" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Create Time:</p>
				</div>
				<div id="vd_lastdate" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Last Date:</p>
				</div>
				<div id="vd_applycount" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Applicants Count:</p>
				</div>
				<div id="vd_selectcount" class="cd-jobs cd-attr">
					<p class="cd-attr-left">Selections Count:</p>
				</div>-->
			</div>
		</div>
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/student.js"></script>

</html>