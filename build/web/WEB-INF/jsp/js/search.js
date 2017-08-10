$(document).ready(function() {
	var content=$.getUrlParam("content");
	$("#search-input").val(content);
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/job/search",
		dataType: "json",
		data: {
			"content": content,
		},
		success: function(data) {
			if(data.success) {
//				var i=data.data.length;
				$.each(data.data, function(i,item) {
					$("#searchpage-left").append("<div class='search-job search-son'><div class='search-jobname search-left-attr'>"+
					"JobName:<a href='job.jsp?jobId="+item.jobId+"'>"+item.jobName+"</a></div><div class='search-jobgodetails'><a href='job.jsp?jobId="+item.jobId+"'>Details></a>"+
					"</div><div class='search-jobcount search-left-attr'>Count:<p>"+item.count+"</p></div><div class='search-jobcompany search-left-attr'>"+
					"<p>Companies:</p><div><a href='company.jsp?companyId="+data.list1[i].companyId+"'>"+data.list1[i].companyName+"</a><p>,</p><a href='job.jsp?jobId="+item.jobId+"' class='right-more search-more'>...</a></div></div></div>");
//					alert(item.jobName+data.list1[i].companyName);
				});
			}else{
				$("#searchpage-left").append("Not Found Matched Jobs");
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/vacancy/search",
		dataType: "json",
		data: {
			"content": content,
		},
		success: function(data) {
			if(data.success) {
//				var i=data.data.length;
				$.each(data.data, function(i,item) {
					var skills="";
					$.each(data.list1[i], function(n,ntem) {
						skills=skills+ntem.skillName;
					});
					$("#searchpage-middle").append("<div class='search-vacancy search-son'><div class='search-vacancyjobname search-left-attrm'>Job:<a href='job.jsp?jobId="+data.list2[i].jobId+"'>"+data.list2[i].jobName+"</a>"+
					"</div><div class='search-vacancytype search-left-attrm'>Type:<a href='#'>"+item.type+"</a></div><div class='search-vacancygodetails'><a href='vacancy.jsp?vacancyId="+data.data[i].vacancyId+"'>Details></a></div><div class='search-vacancycompany search-left-attr'>"+
					"Company:<a href='company.jsp?companyId="+data.list3[i].companyId+"'>"+data.list3[i].companyName+"</a></div><div class='search-vacancylastdate search-left-attr'>Last Date:<a href='#'>"+$.unixToDate(item.lastDate)+"</a>"+
					"</div><div class='search-vacancyskills search-left-attr'><p>Skills:</p><div><a href='#'> "+skills+"</a></div></div></div>");
				});
			}else{
				$("#searchpage-middle").append("Not Found Matched Vacanies");
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/company/search",
		dataType: "json",
		data: {
			"content": content,
		},
		success: function(data) {
			if(data.success) {
				var flag=0;
				$.each(data.data, function(i,item) {
					flag=1;
					$("#searchpage-right").append("<div class='search-vacancy search-son'><div class='search-left-attr search-companyname'><br/> CompanyName:<a href='#'>"+item.companyName+"</a></div><div class='search-companygodetails'><a href='#'>Details></a></div></div>");
				});
				if(flag==0){
					$("#searchpage-right").append("Not Found Matched Companies");
				}
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
});