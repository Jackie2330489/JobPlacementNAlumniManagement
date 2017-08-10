$(document).ready(function(){
	var studentId=$.getUrlParam("studentId");
	if(studentId==null){
		alert("No Such StudentId");
		window.location.href="index.jsp";
	}else{
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/student/id",
			dataType: "json",
			data: {
				"studentId": studentId,
			},
			success: function(data) {
				if(data.success) {
					$("#sd_id").append(data.data.studentId);
					$("#sd_name").append(data.data.name);
					$("#sd_sex").append(data.data.sex);
					$("#sd_region").append(data.data.region);
					$("#sd_grade").append(data.data.grade);
					$("#sd_inst").append(data.data.institute);
					$("#sd_spec").append(data.data.specialize);
					$("#sd_phone").append(data.data.phone);
					$("#sd_email").append(data.data.email);
					$("#sd_qw").append(data.data.qqOrWechat);
					$("#sd_others").append(data.data.others);
					$("#sd_company").append("<a href='company.jsp?companyId="+data.data2.companyId+"'>"+data.data2.companyName+"</a>");
					$.each(data.list1, function(i,item) {
						$("sd_skills").append(item.skillName+",");
					});
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
