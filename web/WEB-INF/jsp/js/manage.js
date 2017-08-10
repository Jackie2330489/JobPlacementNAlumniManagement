(function($) {
	$.refreshUser = function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/member/all",
			dataType: "json",
			success: function(data) {
				if(data.success) {
					$(".manage-btn").val("Add User");
					$(".manage-btn").attr("id", "add_user");
					//模态框
					$("#form_name").html("Add User");
					$(".form_content").html("<div class='form_li'><p>UserId:</p><input id='user_userid' type='text'/></div>" +
						"<div class='form_li'><p>Password:</p><input id='user_password' type='text'/></div>");
					$(".form_btnn").attr("id", "user_btn");
					//table
					$("#show_table").html("<tr><th>UserId</th><th>Password</th><th>Status</th><th>——</th></tr>");
					$.each(data.data, function(i, item) {
						$("#show_table").append("<tr><td>" + item.memberId + "</td><td>" + item.password + "</td><td>" + item.memberStatus + "</td><td><input class='user_activate' id='" + item.memberId + "' type='button' value='activate'/></td></tr>");
					});
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
	$.refreshStudent = function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/student/all",
			dataType: "json",
			success: function(data) {
				if(data.success) {
					$(".manage-btn").val("Add Student");
					$(".manage-btn").attr("id", "add_student");
					//table
					$("#show_table").html("<tr><th>StudentId</th><th>Name</th><th>Sex</th><th>Region</th><th>Grade</th><th>Institute</th><th>Specialize</th><th>Phone</th><th>Email</th><th>QQorWechat</th><th>Others</th><th>——</th></tr>");
					$.each(data.data, function(i, item) {
						$("#show_table").append("<tr><td>" + item.studentId + "</td><td>" + item.name + "</td><td>" + item.sex + "</td><td>" + item.region + "</td><td>" + item.grade + "</td><td>" + item.institute + "</td><td>" + item.specialize + "</td><td>" + item.phone + "</td><td>" + item.email + "</td><td>" + item.qqOrWechat + "</td><td>" + item.others + "</td><td><input class='student_update' id='" + item.studentId + "' type='button' value='update'/></td></tr>");
					});
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
	$.refreshCompany = function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/company/all",
			dataType: "json",
			success: function(data) {
				if(data.success) {
					$(".manage-btn").val("Add Company");
					$(".manage-btn").attr("id", "add_company");
					//table
					$("#show_table").html("<tr><th>CompanyId</th><th>CompanyName</th><th>——</th></tr>");
					$.each(data.data, function(i, item) {
						$("#show_table").append("<tr><td>" + item.companyId + "</td><td>" + item.companyName + "</td><td><input class='company_update' id='" + item.companyId + "' type='button' value='update'/></td></tr>");
					});
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
	$.refreshVacancy = function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/vacancy/all",
			dataType: "json",
			success: function(data) {
				if(data.success) {

					$(".manage-btn").val("Add Vacancy");
					$(".manage-btn").attr("id", "add_vacancy");
					//table
					$("#show_table").html("<tr><th>VacancyId</th><th>Status</th><th>Type</th><th>Company</th><th>Job</th><th>Skills</th><th>Create Time</th><th>Last Date</th><th>——</th><th>——</th></tr>");
					$.each(data.data, function(i, item) {
						var listsOfSkills = "";
						$.each(data.list3[i], function(n,ntem) {
							listsOfSkills+=ntem.skillName+"&nbsp;";
						});
						var ccName="";
						if(data.list1[i]!=null)ccName=data.list1[i].companyName;
						var jjName="";
						if(data.list2[i]!=null)jjName=data.list2[i].jobName;
						$("#show_table").append("<tr><td>" + item.vacancyId + "</td><td>" + item.vacancyStatus + "</td><td>" + item.type + "</td><td>" + ccName + "</td><td>" + jjName + "</td><td>" + listsOfSkills + "</td><td>" + $.unixToDate(item.createTime) + "</td><td>" + $.unixToDate(item.lastDate) + "</td><td><input class='vacancy_update' id='u" + item.vacancyId + "' type='button' value='update'/></td><td><input class='vacancy_send' id='s" + item.vacancyId + "' type='button' value='Send Notis'/></td></tr>");
					});
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
})(jQuery);
$(document).ready(function() {
	$("#ml-user").click(function() {
		$.refreshUser();
	});
	$("#ml-student").click(function() {
		$.refreshStudent();
	});
	$("#ml-company").click(function() {
		$.refreshCompany();
	});
	$("#ml-vacancy").click(function() {
		$.refreshVacancy();
	});
	//模态框
	$(".manage-btn").click(function() {　　
		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$(".bg-model-ok").click(function() {　　
		$(".bg-model").hide();　　
		$("body").css({
			"overflow": "visible"
		});
	});
	//初始进入页面
	$.refreshUser();
	//激活
	$("#show_table").delegate('.user_activate', 'click', function() {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/member/activate",
			dataType: "json",
			data: {
				"memberId": $(this).attr("id"),
			},
			success: function(data) {
				if(data.success) {
					alert(data.msg);
					$.refreshUser();
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});
	//模态框添用户
	$(".model-content").delegate('#user_btn', 'click', function() {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/member/add",
			dataType: "json",
			data: {
				"memberId": $("#user_userid").val(),
				"password": $("#user_password").val(),
			},
			success: function(data) {
				$(".bg-model").hide();　　
				$("body").css({
					"overflow": "visible"
				});
				if(data.success) {
					alert(data.msg);
					$.refreshUser();
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});

	$("#show_table").delegate('.student_update', 'click', function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/student/id",
			dataType: "json",
			data: {
				"studentId": $(this).attr("id"),
			},
			success: function(data) {
				if(data.success) {
					//模态框
					$("#form_name").html("Update Student");
					$(".form_content").html("<div class='form_li'><p>StudentId:</p><input id='student_stuid' type='text' value='" + data.data.studentId + "' disabled='diabled'/></div>" +
						"<div class='form_li'><p>Name:</p><input id='student_name' type='text' value='" + data.data.name + "'/></div>" +
						"<div class='form_li'><p>Sex:</p><input id='student_sex' type='text' value='" + data.data.sex + "'/></div>" +
						"<div class='form_li'><p>Region:</p><input id='student_region' type='text' value='" + data.data.region + "'/></div>" +
						"<div class='form_li'><p>Grade:</p><input id='student_grade' type='text' value='" + data.data.grade + "'/></div>" +
						"<div class='form_li'><p>Institute:</p><input id='student_institute' type='text' value='" + data.data.institute + "'/></div>" +
						"<div class='form_li'><p>Specialize:</p><input id='student_specialize' type='text' value='" + data.data.specialize + "'/></div>" +
						"<div class='form_li'><p>Phone:</p><input id='student_phone' type='text' value='" + data.data.phone + "'/></div>" +
						"<div class='form_li'><p>Email:</p><input id='student_email' type='text' value='" + data.data.email + "'/></div>" +
						"<div class='form_li'><p>QQorWechat:</p><input id='student_qqOrWechat' type='text' value='" + data.data.qqOrWechat + "'/></div>" +
						"<div class='form_li'><p>Others:</p><input id='student_others' type='text' value='" + data.data.others + "'/></div>");
					$(".form_btnn").attr("id", "student_btn");
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$("#manage-right").delegate('#add_student', 'click', function() {

		//模态框
		$("#form_name").html("Add Student");
		$(".form_content").html("<div class='form_li'><p>StudentId:</p><input id='student_stuid' type='text' /></div>" +
			"<div class='form_li'><p>Name:</p><input id='student_name' type='text' /></div>" +
			"<div class='form_li'><p>Sex:</p><input id='student_sex' type='text' /></div>" +
			"<div class='form_li'><p>Region:</p><input id='student_region' type='text' /></div>" +
			"<div class='form_li'><p>Grade:</p><input id='student_grade' type='text' /></div>" +
			"<div class='form_li'><p>Institute:</p><input id='student_institute' type='text' /></div>" +
			"<div class='form_li'><p>Specialize:</p><input id='student_specialize' type='text' /></div>" +
			"<div class='form_li'><p>Phone:</p><input id='student_phone' type='text' /></div>" +
			"<div class='form_li'><p>Email:</p><input id='student_email' type='text' /></div>" +
			"<div class='form_li'><p>QQorWechat:</p><input id='student_qqOrWechat' type='text' /></div>" +
			"<div class='form_li'><p>Others:</p><input id='student_others' type='text' /></div>");
		$(".form_btnn").attr("id", "student_btn");

		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$(".model-content").delegate('#student_btn', 'click', function() {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/student/saveOrUpdate",
			dataType: "json",
			data: {
				"studentId": $("#student_stuid").val(),
				"name": $("#student_name").val(),
				"sex": $("#student_sex").val(),
				"region": $("#student_region").val(),
				"grade": $("#student_grade").val(),
				"institute": $("#student_institute").val(),
				"specialize": $("#student_specialize").val(),
				"phone": $("#student_phone").val(),
				"email": $("#student_email").val(),
				"qqOrWechat": $("#student_qqOrWechat").val(),
				"others": $("#student_others").val(),
			},
			success: function(data) {
				$(".bg-model").hide();　　
				$("body").css({
					"overflow": "visible"
				});
				if(data.success) {
					alert(data.msg);
					$.refreshStudent();
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});

	/////////////////Company
	$("#show_table").delegate('.company_update', 'click', function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/company/id",
			dataType: "json",
			data: {
				"companyId": $(this).attr("id"),
			},
			success: function(data) {
				if(data.success) {
					//模态框
					$("#form_name").html("Update Company");
					$(".form_content").html("<div class='form_li'><p>CId:</p><input id='company_cid' type='text' value='" + data.data.companyId + "' disabled='diabled'/></div>" +
						"<div class='form_li'><p>CName:</p><input id='company_cname' type='text' value='" + data.data.companyName + "'/></div>");
					$(".form_btnn").attr("id", "company_btn");
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$("#manage-right").delegate('#add_company', 'click', function() {

		//模态框
		$("#form_name").html("Add Company");
		$(".form_content").html("<div class='form_li'><p>CId:</p><input id='company_cid' type='text' /></div>" +
			"<div class='form_li'><p>CName:</p><input id='company_cname' type='text' /></div>");
		$(".form_btnn").attr("id", "company_btn");

		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$(".model-content").delegate('#company_btn', 'click', function() {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/company/saveOrUpdate",
			dataType: "json",
			data: {
				"companyId": $("#company_cid").val(),
				"companyName": $("#company_cname").val(),
			},
			success: function(data) {
				$(".bg-model").hide();　　
				$("body").css({
					"overflow": "visible"
				});
				if(data.success) {
					alert(data.msg);
					$.refreshCompany();
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});

	var foruse = "";
	///////Vacancy
	$("#show_table").delegate('.vacancy_update', 'click', function() {
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/vacancy/id",
			dataType: "json",
			data: {
				"vacancyId": $(this).attr("id").substr(1, 12),
			},
			success: function(data) {
				if(data.success) {
					//模态框
					var selectCompanies = "<select id='vacancy_company'>";
					$.each(data.list4, function(i, item) {
						selectCompanies += "<option value='" + item.companyId + "'>" + item.companyName + "</option>";
					});
					selectCompanies += "</select>";
					
					var selectJobs = "<select id='vacancy_job'>";
					$.each(data.list5, function(i, item) {
						selectJobs += "<option value='" + item.jobId + "'>" + item.jobName + "</option>";
					});
					selectJobs += "</select>";
					
					var selectSkills = "<select id='vacancy_skills' multiple='multiple'>";
					$.each(data.list6, function(i, item) {
						selectSkills+="<optgroup label='"+item.scName+"'>";
						$.each(data.list7[i], function(n,ntem) {
							selectSkills+="<option value='"+ntem.skillId+"'>"+ntem.skillName+"</option>";
						});
						selectSkills+="</optgroup>";
					});
					selectSkills += "</select>";
					
					$("#form_name").html("Update Vacancy");
					$(".form_content").html("<div class='form_li'><p>VId:</p><input id='vacancy_vid' type='text' value='" + data.data.vacancyId + "' disabled='diabled'/></div>" +
						"<div class='form_li'><p>Status:</p><input id='vacancy_status' type='text' value='" + data.data.vacancyStatus + "'/></div>" +
						"<div class='form_li'><p>Type:</p><input id='vacancy_type' type='text' value='" + data.data.type + "'/></div>" +
						"<div class='form_li'><p>Company:</p>" + selectCompanies + "</div>" +
						"<div class='form_li'><p>Job:</p>" + selectJobs + "</div>" +
						"<div class='form_li'><p>Skills</p>" + selectSkills + "</div>" +
						"<div class='form_li'><p>CreTime:</p><input id='vacancy_createTime' type='text' value='" + $.unixToDate(data.data.createTime) + "'/></div>" +
						"<div class='form_li'><p>LastDate:</p><input id='vacancy_lastDate' type='text' value='" + $.unixToDate(data.data.lastDate) + "'/></div>");
					foruse = "<div class='form_li'><input id='vacancy_vid' type='hidden'/></div>" +
						"<div class='form_li'><p>Status:</p><input id='vacancy_status' type='text'/></div>" +
						"<div class='form_li'><p>Type:</p><input id='vacancy_type' type='text' /></div>" +
						"<div class='form_li'><p>Company:</p>" + selectCompanies + "</div>" +
						"<div class='form_li'><p>Job:</p>" + selectJobs + "</div>" +
						"<div class='form_li'><p>Skills:</p>" + selectSkills + "</div>" +
						"<div class='form_li'><input id='vacancy_createTime' type='hidden' /></div>"+
						"<div class='form_li'><p>LastDate:</p><input id='vacancy_lastDate' type='text' /></div>";
					$(".form_btnn").attr("id", "vacancy_btn");
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$("#manage-right").delegate('#add_vacancy', 'click', function() {

		//模态框
		$("#form_name").html("Add Vacancy");
		///
		$(".form_content").html(foruse);
		//////
		$(".form_btnn").attr("id", "vacancy_btn");

		$(".bg-model").fadeTo(300, 1)　　
		$("body").css({
			"overflow": "hidden"
		});
	});
	$(".model-content").delegate('#vacancy_btn', 'click', function() {
//		alert($("#vacancy_vid").val());
//		alert($("#vacancy_status").val());
//		alert($("#vacancy_type").val());
//		alert($("#vacancy_company").val());
//		alert($("#vacancy_job").val());
//		alert($("#vacancy_skills").val());
//		alert($("#vacancy_createTime").val());
//		alert($("#vacancy_lastDate").val());
		var vvid=$("#vacancy_vid").val();
		if(vvid=="")vvid=0;
//		alert(vvid);
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/vacancy/saveOrUpdate",
			dataType: "json",
			traditional: true,
			data: {
				"vacancyId": vvid,
				"status": $("#vacancy_status").val(),
				"type": $("#vacancy_type").val(),
				"companyId": $("#vacancy_company").val(),
				"jobId": $("#vacancy_job").val(),
				"skills":$("#vacancy_skills").val(),
				"cTime": $("#vacancy_createTime").val(),
				"lDate": $("#vacancy_lastDate").val(),
			},
			success: function(data) {
				$(".bg-model").hide();　　
				$("body").css({
					"overflow": "visible"
				});
				if(data.success) {
					alert(data.msg);
					$.refreshVacancy();
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});
	$("#show_table").delegate('.vacancy_send', 'click', function() {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/vacancy/sendnotis",
			dataType: "json",
			data: {
				"vacancyId": $(this).attr("id").substr(1, 12),
			},
			success: function(data) {
				if(data.success) {
					alert(data.msg);
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	});
});