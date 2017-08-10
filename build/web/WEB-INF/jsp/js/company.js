$(document).ready(function(){
	var companyId=$.getUrlParam("companyId");
	if(companyId==null){
		alert("No Such CompanyId");
		window.location.href="index.jsp";
	}else{
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/company/id",
			dataType: "json",
			data: {
				"companyId": companyId,
			},
			success: function(data) {
				if(data.success) {
					var flag1=0;
					var flag2=0;
					var flag3=0;
					$("#cd_companyName").html(data.data.companyName);
					$.each(data.list1, function(i,item) {
						flag1=1;
						$("#cd_jobs").append("<a style='display:inline-block;' href='job.jsp?jobId="+item.jobId+"'>"+item.jobName+"</a>,");
					});
					$.each(data.list2, function(i,item) {
						flag2=1;
						$("#cd_vacancies").append("<div class='cd-vacancy-item'><p>"+data.list2[i].type+"</p><p>"+data.list3[i].jobName+"</p><p>"+$.unixToDate(data.list2[i].lastDate)+"</p><a href='vacancy.jsp?vacancyId="+data.list2[i].vacancyId+"'>>></a></div>");
					});
					$.each(data.list4, function(i,item){
						flag3=1;
						$("cd_students").append("<a href='student.jsp?studentId="+item.studentId+"'>"+item.name+"</a>,");
					});
					if(flag1==0){
						$("#cd_jobs").append("Jobs Not Found");
					}
					if(flag2==0){
						$("#cd_vacancies").append("Vacancies Not Found");
					}
					if(flag3==0){
						$("#cd_students").append("Students Not Found");
					}
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
