$(document).ready(function(){
	var vacancyId=$.getUrlParam("vacancyId");
	if(vacancyId==null){
		alert("No Such vacancyId");
		window.location.href="index.jsp";
	}else{
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/vacancy/id",
			dataType: "json",
			data: {
				"vacancyId": vacancyId,
			},
			success: function(data) {
				if(data.success) {
					$("#vd_status").append("<p>"+data.data.vacancyStatus+"</p>");
					$("#vd_type").append("<p>"+data.data.type+"</p>");
					$("#vd_company").append("<a style='display:inline-block;' href='company.jsp?companyId="+data.data2.companyId+"'>"+data.data2.companyName+"</a>");
					$("#vd_job").append("<a style='display:inline-block;' href='job.jsp?jobId="+data.data3.jobId+"'>"+data.data3.jobName+"</a>");
					$.each(data.list1, function(i,item) {
						$("#vd_skills").append("<p>"+item.skillName+"</p>,");
					});
					$("#vd_createtime").append("<p>"+$.unixToDate(data.data.createTime)+"</p>");
					$("#vd_lastdate").append("<p>"+$.unixToDate(data.data.lastDate)+"</p>");
					var applicants=0;
					$.each(data.list2, function() {
						applicants+=1;
					});
					$("#vd_applycount").append("<p>"+applicants+"</p>");
					var selections=0;
					$.each(data.list3, function() {
						selections+=1;
					});
					$("#vd_selectcount").append("<p>"+selections+"</p>");
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

