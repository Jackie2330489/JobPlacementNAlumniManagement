(function($) {
	$.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	}
	$.add0=function(m){
		return m<10?'0'+m:m;
	}
	$.unixToDate = function(timestamp) {
		var time = new Date(timestamp);
		var year = time.getFullYear();
		var month = time.getMonth() + 1;
		var date = time.getDate();
//		var hours = time.getHours();
//		var minutes = time.getMinutes();
//		var seconds = time.getSeconds();
		return year + '-' + $.add0(month) + '-' + $.add0(date);
//		+ ' ' + $.add0(hours) + ':' + $.add0(minutes) + ':' + $.add0(seconds)
	}
})(jQuery);
$(document).ready(function() {
	/*Cookies 记住登录*/
	var cookie_uid = $.cookie("uid");
	var cookie_md5 = $.cookie("md5");
	if(cookie_uid == null || cookie_md5 == null) {
		$("#status_unlogin").css("display", "inline-block");
		$("#status_login").css("display", "none");
	} else {
		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8084/H6Project/member/rememberLogin",
			dataType: "json",
			data: {
				"uid": cookie_uid,
				"md5": cookie_md5,
			},
			success: function(data) {
				if(data.success) {
					$("#status_unlogin").css("display", "none");
					$("#status_login").css("display", "inline-block");
					$("#login-a").html(data.msg);
					$("#login-a").attr("href","stuself.jsp");
				} else {
					alert(data.msg);
				}
			},
			error: function(jqXHR) {
				alert("Error:" + jqXHR.status + jqXHR.Message);
			}
		});
	}
	/*验证注册输入*/
	$("#register-uid").blur(function() {
		if($("#register-uid").val().length < 9) {
			$("#register-uid-msg").html("UserID's length should more than 9");
		} else {
			$("#register-uid-msg").html("");
		}
	});
	$("#register-pwd").blur(function() {
		if($("#register-pwd").val().length < 8) {
			$("#register-uid-msg").html("Password's length should more than 8");
		} else {
			$("#register-uid-msg").html("");
		}
	});
	$("#register-repwd").blur(function() {
		if($("#register-repwd").val() != $("#register-pwd").val()) {
			$("#register-uid-msg").html("RePassword should be same as Password");
		} else {
			$("#register-uid-msg").html("");
		}
	});

	$("#register-stuid").blur(function() {
		if(isNaN($("#register-stuid").val())) {
			$("#register-stu-msg").html("StudentID should be number");
		} else if($("#register-stuid").val().length != 12) {
			$("#register-stu-msg").html("StudentID's length should be 12");
		} else {
			$("#register-stu-msg").html("");
		}
	});
	//注册请求
	$("#register-btn").click(function() {
		if($("#register-uid").val().length < 9 || $("#register-pwd").val().length < 8 || $("#register-repwd").val() != $("#register-pwd").val() ||
			isNaN($("#register-stuid").val()) || $("#register-stuid").val().length != 12) {
			$("#register-btn-msg").html("Mistakes Exists Above");
		} else {
			//发post请求
			$.ajax({
				type: "POST",
				url: "http://127.0.0.1:8084/H6Project/member/register",
				dataType: "json",
				data: {
					"memberId": $("#register-uid").val(),
					"password": $("#register-pwd").val(),
					"studentId": $("#register-stuid").val(),
					"name": $("#register-name").val(),
					"sex": $("input[type='radio']:checked").val(),
					"region": $("#register-region").val(),
					"grade": $("#register-grade").val(),
					"institute": $("#register-inst").val(),
					"specialize": $("#register-spec").val(),
					"phone": $("#register-phone").val(),
				},
				success: function(data) {
					if(data.success) {
						$.cookie("uid", $("#register-uid").val(), {
							"expires": 10,
							"path": "/"
						});
						$.cookie("md5", data.msg, {
							"expires": 10,
							"path": "/"
						});
						window.location.reload();
					} else {
						alert(data.msg);
					}
				},
				error: function(jqXHR) {
					alert("Error:" + jqXHR.status + jqXHR.Message);
				}
			});
		}
	});
	//验证登录
	$("#login-uid").blur(function() {
		if($("login-uid").val().length < 9) {
			$("#login-msg").html("UserID's length should more than 9");
		} else {
			$("#login-msg").html("");
		}
	});
	$("#login-btn").click(function() {
		if($("#login-uid").val().length < 9) {
			$("#login-msg").html("UserID's length should more than 9");
		} else {
			$.ajax({
				type: 'POST',
				url: "http://127.0.0.1:8084/H6Project/member/login",
				dataType: "json",
				data: {
					"memberId": $("#login-uid").val(),
					"password": $("#login-pwd").val(),
				},
				success: function(data) {
					if(data.success) {
						$.cookie("uid", $("#login-uid").val(), {
							"expires": 10,
							"path": "/"
						});
						$.cookie("md5", data.msg, {
							"expires": 10,
							"path": "/"
						});
						window.location.reload();
					} else {
						alert(data.msg);
					}
				},
				error: function(jqXHR) {
					alert("Error:" + jqXHR.status + jqXHR.Message);
				}
			});
		}
	});

	//搜索
	$("#search-btn").click(function() {
		var content = $("#search-input").val();
		if(content != null) {
			window.location.href = "search.jsp?content=" + content;
		}
	});
});