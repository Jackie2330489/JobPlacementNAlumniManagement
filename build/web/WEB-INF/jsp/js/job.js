$(document).ready(function(){
	var jobId=$.getUrlParam("jobId");
	if(jobId==null){
		alert("No Such JobId");
		window.location.href="index.jsp";
	}else{
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/job/id",
			dataType: "json",
			data: {
				"jobId": jobId,
			},
			success: function(data) {
				if(data.success) {
					$("#jd_jobName").html(data.data.jobName);
					$("#jd_count").append("<p>"+data.data.count+"</p>");
					$("#jd_rating").append("<p>"+data.data.nowRating+"</p>");
					$.each(data.list1, function(i,item) {
						$("#jd_companies").append("<a href='company.jsp?companyId="+item.companyId+"'>"+item.companyName+"</a>,");
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

