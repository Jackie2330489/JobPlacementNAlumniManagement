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
			<div id="left">
				<div id="filter">
					<ul id="index_selectli" class="select">
						<!--<li class="select_list">-->
						<!--<dl class="dl">
								<dt>Web：</dt>
								<div class="dd_list">
									<dd class="selection select-1">
										<a href="#">JQuery</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-2">
										<a href="#">AngularJS</a>
									</dd>
									<dd class="selection select-3">
										<a href="#">VueJS</a>
									</dd>
								</div>
							</dl>-->

						<!--</li>-->
						<!--<li class="notedown">
							<dl class="dl">
								<dt style="font-weight: bold;color: darkgray;">Clicked:</dt>
								<div class="dd_list click_list">
									<input type="hidden" value="" />
									<dd class="choice">AngularJS
										<a class="close" href="#">X</a>
									</dd>
									<dd class="choice">AngularJS
										<a class="close" href="#">X</a>
									</dd>
								</div>
							</dl>
						</li>-->
					</ul>
				</div>
				<hr width="90%" />
				<div id="filter_value">
					<!--<div class="search-vacancy search-son2">
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
					<!--<div class="search-vacancy search-son" style="margin: 0;">
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
					<!--<div class="fv_job">
								Job:
								<a href="#">Manager</a>
							</div>
							<div class="fv_goDetails">
								<a href="#">Details></a>
							</div>
							<div class="fv_company">
								Company:
								<a href="#">Apple</a>
							</div>
							<div class="fv_lastdate">
								Last Date:
								<a href="#">2017-12-7</a>
							</div>
							<div class="fv_skills">
								<p class="skills">Skills:</p>
								<div>
									<a href="#">  Database, JQuery, Database,Database, JQuery, Database</a>
								</div>
							</div>-->
				</div>
			</div>
			<div id="right">
				<div class="first10table">
					<ul id="rright-ul" class="right-ul">
						<h4>Top 10 Trending Jobs</h4>
						<!--<li class="right-li">
							<p class="right-rank">1st</p>
							<img src="photo/up.svg" />
							<p class="right-jobname">None</p>
							<p class="right-companyname">CO.:
								<a href="#">None</a>
								<a href="#" class="right-more">...</a>
							</p>
						</li>-->
					</ul>
				</div>
			</div>
		</div>
	</body>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/gogogo.js"></script>
	<script src="js/index.js"></script>

</html>