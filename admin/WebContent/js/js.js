function userlist(page) {
	$.ajax({
		type : "get",
		url : "ProductAction?action_flag=userlist&pageNumU=" + page,
		success : function(json, textStatus) {
			$("#rounded-corner").empty();
			var tbBody = "<thead> <tr> <th>工号</th> <th>姓名</th> <th>状态</th> </tr> </thead> <tbody>";
			$("#rounded-corner").append(tbBody);
			$.each(json,function(i, n) {
				if (n.username != null) {
					tbBody = "";
					tbBody += "<tr class='odd'><td class='listuser'><a>"
							+ +n.username
							+ "</a></td><td>"
							+ n.realname
							+ "</td><td>"
							+ n.status
							+ "</tr>";
					$("#rounded-corner").append(tbBody);
				} else {
					tbBody = "</tbody> <tfoot> <tr> <td colspan='6' align=center><span>共"
							+ n.pageCount
							+ "页 </span> <a href='javascript:userlist(1)'>首页</a> <a href='javascript:userlist("
							+ (n.currentPage - 1)
							+ ")'>上一页</a> <a href='javascript:userlist("
							+ (n.currentPage + 1)
							+ ")'>下一页</a> <a href='javascript:userlist("
							+ n.pageCount
							+ ")'>尾页</a></td> </tr> </tfoot>";
					$("#rounded-corner").append(tbBody);
				}
				$(".odd").click(function() {
					var username=$(this).find("a").text();
					$.ajax({
						type : "get",
						url : "ProductAction?action_flag=searchuser&username="
								+ escape(username),
						success : function(data, textStatus) {
							$("#res_username").html(data.username);
							$("#res_realname").val(data.realname);
							$("#res_status").val(data.status);
							$("#res_userPswd").val("");
						}
					});
					return false;
				});
			});
		}
	});
}

function productlist(page) {
	$.ajax({
		type : "get",
		url : "ProductAction?action_flag=productlist&pageNumP=" + page,
		success : function(json, textStatus) {
			$("#rounded-corner").empty();
			var tbBody = "<thead> <tr> <th>单号</th> <th>状态</th> <th>最后操作时间</th> <th>操作人(工号)</th> </tr> </thead> <tbody>";
			$("#rounded-corner").append(tbBody);
			$.each(json,function(i, n) {
				if (n.number != null) {
					var tbBody = "";
					tbBody += "<tr class='odd'><td>"
							+ n.number + "</td><td>"
							+ n.status + "</td><td>"
							+ n.date + "</td><td>"
							+ n.name + "</td></tr>";
					$("#rounded-corner").append(tbBody);
				} else {
					tbBody = "</tbody> <tfoot> <tr> <td colspan='5' align=center><span>共"
							+ n.pageCount
							+ "页 </span> <a href='javascript:productlist(1)'>首页</a> <a href='javascript:productlist("
							+ (n.currentPage - 1)
							+ ")'>上一页</a> <a href='javascript:productlist("
							+ (n.currentPage + 1)
							+ ")'>下一页</a> <a href='javascript:productlist("
							+ n.pageCount
							+ ")'>尾页</a></td> </tr> </tfoot>";
					$("#rounded-corner").append(tbBody);
				}
			});
		}
	});
}

$(function() {
	$("#button").click(function() {
		var username = document.getElementById("username");
		$.ajax({
			type : "get",
			url : "ProductAction?action_flag=searchuser&username="
					+ escape(username.value),
			success : function(data, textStatus) {
				$("#res_username").html(data.username);
				$("#res_realname").val(data.realname);
				$("#res_status").val(data.status);
				$("#res_userPswd").val("");
			}
		});
	});
	
	$("#button2").click(function() {
		var number = document.getElementById("number");
		$.ajax({
			type : "get",
			url : "ProductAction?action_flag=searchpro&number="
					+ escape(number.value),
			success : function(data, textStatus) {
				$("#res_number").html(data.number);
				$("#res_pstatus").html(data.status);
				$("#res_date").html(data.date);
				$("#res_name").html(data.name);
			}
		});
	});
	
	$("#form_button").click(function() {
		var realname = $("#res_realname").val();
		var status = $("#res_status").val();
		var userPswd = $("#res_userPswd").val();
		var username = document.getElementById("res_username").innerHTML;
		$.ajax({
			type : "post",
			data : "action_flag=changeuser&realname=" + realname
				+ "&status=" + status
				+ "&username=" + username
				+ "&userPswd=" + userPswd,
			url : "ProductAction",
			success : function() {
				$("#res_change").html("success!");
			}
		});
	});
	
});