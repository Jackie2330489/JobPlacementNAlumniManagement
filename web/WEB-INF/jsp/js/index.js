$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8084/H6Project/job/first10",
		dataType: "json",
		success: function(data) {
			if(data.success) {
				$.each(data.data, function(i,item) {
					var rank="";
					if(i+1==1){
						rank="1st";
					}else if(i+1==2){
						rank="2nd";
					}else if(i+1==3){
						rank="3rd";
					}else{
						rank=(i+1)+"th";
					}
					var img="";
					if(item.nowRating>item.oldRating){
						img="<img src='photo/up.svg' />";
					}else if(item.nowRating==item.oldRating){
						img="<img src='photo/wave.svg' />";
					}else{
						img="<img style='transform:rotate(180deg);' src='photo/down.svg' />";
					}
					var cName="None";
					var cId="0";
					$.each(data.list1[i], function(n,ntem) {
						if(n==0){
							cName=ntem.companyName;
							cId=ntem.companyId;
						}
					});
//					alert(rank+img+cName+cId);
					$("#rright-ul").append("<li class='right-li'><p class='right-rank'>"+rank+"</p>"+img+"<p class='right-jobname'>"+item.jobName+"</p><p class='right-companyname'>CO.:<a href='company.jsp?companyId="+cId+"'>"+cName+"</a><a href='job.jsp?jobId="+item.jobId+"' class='right-more'>...</a></p></li>");
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
					$("#index_selectli").prepend("</dl></li><div style='clear: both;'></div>");
					$.each(data.list1[i], function(n, ntem) {
						$("#index_selectli").prepend("<dd id='select_" + i + "_" + n + "' class='selection select-1'><a href='#'>" + ntem.skillName + "</a></dd>");
					});
					$("#index_selectli").prepend("<li class='select_list'><dl class='dl'><dt style='font-weight:bold;'>" + item.scName + "：</dt>");
				});
			} else {
				alert(data.msg);
			}
		},
		error: function(jqXHR) {
			alert("Error:" + jqXHR.status + jqXHR.Message);
		}
	});
	var arr = new Array();
	$("#index_selectli").delegate('.selection', 'click', function() {
		var flag=1;
		var aaa=$(this).find("a").html();
		$.each(arr, function(i,item) {
			if(aaa==item){
				flag=0;
				arr.splice(i,1);
			}
		});
		if(flag==1){
			arr.push($(this).find("a").html());
			$(this).css("background","linear-gradient(to bottom,#fff,#eee)");
		}else{
			$(this).css("background","none");
		}
//		alert(arr);	
		$.ajax({
			type: "GET",
			url: "http://127.0.0.1:8084/H6Project/vacancy/filter",
			dataType: "json",
			data: {
				"arr": arr,
			},
			traditional: true,
			success: function(data) {
				if(data.success) {
					$("#filter_value").html("");
					$.each(data.data, function(i,item) {
						var skills="";
						$.each(data.list3[i],function(n,ntem){
							skills+=ntem.skillName;
						});
						$("#filter_value").append("<div class='search-vacancy search-son2'><div class='search-vacancyjobname search-left-attrm'>Job:<a href='job.jsp?jobId="+data.list2[i].jobId+"'>"+data.list2[i].jobName+"</a></div><div class='search-vacancytype search-left-attrm'>"+
						"Type:<a href='#'>"+item.type+"</a></div><div class='search-vacancygodetails'><a href='vacancy.jsp?vacancyId="+item.vacancyId+"'>Details></a></div><div class='search-vacancycompany search-left-attr'>Company:<a href='company.jsp?companyId="+data.list1[i].companyId+"'>"+data.list1[i].companyName+"</a>"+
						"</div><div class='search-vacancylastdate search-left-attr'>Last Date:<a href='#'>"+item.lastDate+"</a></div><div class='search-vacancyskills search-left-attr'><p>Skills:</p><div><a href='#'>"+skills+"</a>"+
						"</div></div></div>");
					});
				} else {
					$("#filter_value").html("<div style='text-align:center;'>"+data.error+"</div>");
				}
			},
			error: function(jqXHR) {
				$("#filter_value").html("");
			}
		});
	});
});