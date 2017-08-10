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
			<div id="searchpage-left" class="searchpage">
				<div class="search-title">Jobs</div>
				<hr style="width: 90%;" />
				<!--<div class="search-job search-son">
					<div class="search-jobname search-left-attr">
						JobName:
						<a href="#">Manager</a>
					</div>
					<div class="search-jobgodetails">
						<a href="#">Details></a>
					</div>
					<div class="search-jobcount search-left-attr">
						Count:
						<p>12</p>
					</div>
					<div class="search-jobcompany search-left-attr">
						<p>Companies:</p>
						<div>
							<a href="#">Manager</a>
							<p>,</p>
							<a href="#" class="right-more search-more">...</a>
						</div>
					</div>
				</div>
				<div class="search-job search-son">
					<div class="search-jobname search-left-attr">
						JobName:
						<a href="#">Manager</a>
					</div>
					<div class="search-jobgodetails">
						<a href="#">Details></a>
					</div>
					<div class="search-jobcount search-left-attr">
						Count:
						<p>12</p>
					</div>
					<div class="search-jobcompany search-left-attr">
						<p>Companies:</p>
						<div>
							<a href="#">Manager</a>
							<p>,</p>
							<a href="#" class="right-more search-more">...</a>
						</div>
					</div>
				</div>
			-->
			</div>
			<div id="searchpage-middle" class="searchpage">
				<div class="search-title">Vacancies</div>
				<hr style="width: 90%;" />
				<!--<div class="search-vacancy search-son">
					<div class="search-vacancyjobname search-left-attr">
						Job:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancygodetails">
						<a href="#">Details></a>
					</div>
					<div class="search-vacancycompany search-left-attr">
						Company:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancylastdate search-left-attr">
						Last Date:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancyskills search-left-attr">
						<p>Skills:</p>
						<div>
							<a href="#"> Database, JQuery, Database,Database, JQuery, Database</a>
						</div>
					</div>
				</div>
				<div class="search-vacancy search-son">
					<div class="search-vacancyjobname search-left-attrm">
						Job:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancytype search-left-attrm">
						Type:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancygodetails">
						<a href="#">Details></a>
					</div>
					<div class="search-vacancycompany search-left-attr">
						Company:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancylastdate search-left-attr">
						Last Date:
						<a href="#">Manager</a>
					</div>
					<div class="search-vacancyskills search-left-attr">
						<p>Skills:</p>
						<div>
							<a href="#"> Database, JQuery, Database,Database, JQuery, Database</a>
						</div>
					</div>
				</div>-->

			</div>
			<div id="searchpage-right" class="searchpage">
				<div class="search-title">Companies</div>
				<hr style="width: 90%;" />
				<!--<div class="search-vacancy search-son">
					<div class="search-left-attr search-companyname">
						<br/> CompanyName:
						<a href="#">Manager</a>
					</div>
					<div class="search-companygodetails">
						<a href="#">Details></a>
					</div>
				</div>
				<div class="search-vacancy search-son">
					<div class="search-left-attr search-companyname">
						<br/> CompanyName:
						<a href="#">Manager</a>
					</div>
					<div class="search-companygodetails">
						<a href="#">Details></a>
					</div>
				</div>-->
			</div>
		</div>
	</body>

	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/search.js"></script>

</html>