(function($) {
	$.refreshpage = function(name) {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/member/details",
			dataType: "json",
			data: {
				"uid": $.cookie("uid"),
				"md5": $.cookie("md5"),
			},
			success: function(data) {
				if(data.success) {
					$("#stu-uid").val(data.data.memberId);
					$("#stu-password").val(data.data.password);

					$("#stu-stuid").val(data.data2.studentId);
					$("#stu-sex").val(data.data2.sex);
					$("#stu-name").val(data.data2.name);
					$("#stu-region").val(data.data2.region);
					$("#stu-inst").val(data.data2.institute);
					$("#stu-spec").val(data.data2.specialize);
					$("#stu-grade").val(data.data2.grade);
					$("#stu-phone").val(data.data2.phone);
					$("#stu-qw").val(data.data2.qqOrWechat);
					$("#stu-others").val(data.data2.others);
					var dacompany = "";
					if(data.data3 != null) {
						dacompany = data.data3.companyId;
					}
					var dajob = "";
					if(data.data4 != null) {
						dajob = data.data4.jobId;
					}
					$("#stu-company").val(dacompany);
					$("#stu-job").val(dajob);
					var skills = "";
					if(data.list1 != null) {
						//						var skills = data.list1[0].skillId;
						$.each(data.list1, function(i, item) {
							//							if(i != 0) {
							skills += "," + item.skillId;
							//							}
						});
						$("#stu-skills").val(skills);
					}
				} else {
					alert(data.msg);
					window.location.href = "index.jsp";
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
})(jQuery);
$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/company/all",
		dataType: "json",
		success: function(data) {
			if(data.success) {
				$.each(data.data, function(i, item) {
					$("#stu-company").append("<option value='" + item.companyId + "'>" + item.companyName + "</option>");
				});
			} else {
				alert(data.msg);
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/job/all",
		dataType: "json",
		success: function(data) {
			if(data.success) {
				$.each(data.data, function(i, item) {
					$("#stu-job").append("<option value='" + item.jobId + "'>" + item.jobName + "</option>");
				});
			} else {
				alert(data.msg);
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/sc/all",
		dataType: "json",
		success: function(data) {
			if(data.success) {
				$.each(data.data, function(i, item) {
					$("#stu-skills").append("<optgroup label='" + item.scName + "'>");
					$.each(data.list1[i], function(n, ntem) {
						$("#stu-skills").append("<option value='" + ntem.skillId + "'>" + ntem.skillName + "</option>");
					});
					$("#stu-skills").append("</optgroup>");
				});
			} else {
				alert(data.msg);
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	$.ajax({
		type: "POST",
		url: "http://127.0.0.1:8084/H6Project/notis/id",
		dataType: "json",
		data: {
			"uid": $.cookie("uid"),
		},
		success: function(data) {
			if(data.success) {
				$.each(data.data, function(i,item) {
					$("#stuself-right").append("<div class='notis'><p class='noti-com'>"+data.list1[i].companyName+":</p><br/><p class='noti-msg'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+item.content+"</p></div>");
				});
			} else {
				alert(data.msg);
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	$.refreshpage();
	//	var cook_uid = $.cookie("uid");
	//	var cook_md5 = $.cookie("md5");
	//	if(cook_uid==null||cook_md5==null){
	//		window.location.href="login.jsp";
	//	}else{
	//		
	//	}
});