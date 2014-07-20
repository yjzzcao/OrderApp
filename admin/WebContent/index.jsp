<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单号系统后台管理</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- jQuery file -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset=utf-8></script>
<script src="js/js.js" type="text/javascript" charset=utf-8></script>
<script type="text/javascript">
	var $ = jQuery.noConflict();
	$(function() {
		$("#tab2").hide();
		$("#search2").hide();
		$("#usernav").click(function() {
			$("#tab2").hide();
			$("#search2").hide();
			$("#tab1").show("slow");
			$("#search1").show();
			return false;
		});
		$("#productnav").click(function() {
			$("#tab1").hide();
			$("#search1").hide();
			$("#tab2").show("slow");
			$("#search2").show();
			return false;
		});
	});
</script>
<body onload="userlist(1)">
	<div id="panelwrap">

		<div class="header">
			<div class="title">
				<a href="#">单号系统后台管理</a>
			</div>
			<div class="header_right">
				Welcome
				<%=name%>
				<a href="Logout" class="logout">Logout</a>
			</div>
		</div>

		<div class="center_content">

			<div id="right_wrap">
				<div id="right_content">
					<h2>项目列表（点击就可查询）</h2>

					<table id="rounded-corner">
					<!-- result list -->
					</table>

					<div class="form_sub_buttons" id="search1">
						<input type="button" id="button" class="tabsmenu" value="工号查询" />
						<input type="text" id="username" class="search_input" />
					</div>
					<div class="form_sub_buttons" id="search2">
						<input type="button" id="button2" class="tabsmenu" value="单号查询" />
						<input type="text" id="number" class="search_input" />
					</div>

					<ul id="tabtitle1" class="tabtitle">
						<li class="active"><a href="#tab1">查询信息</a></li>
					</ul>

					<div id="tab1" class="tabcontent">
						<h3>员工信息修改</h3>
						<div class="form">
							<div class="form_row">
								<label>工号：</label> <label id="res_username"></label>
							</div>

							<div class="form_row">
								<label>姓名：</label> <input type="text" class="form_input"
									id="res_realname" value="" />
							</div>

							<div class="form_row">
								<label>状态：</label> <select class="form_select" id="res_status">
									<option value="OK">OK</option>
									<option value="PAUSE">PAUSE</option>
								</select>
							</div>

							<div class="form_row">
								<label>修改密码：<br />(不修改请为空)</label> <input type="password" class="form_input"
									id="res_userPswd" value="" />
							</div>

							<div class="form_row">
								<input type="button" id="form_button" class="form_submit"
									value="修改" />
							</div>
							<div class="clear" id="res_change"></div>
						</div>
					</div>

					<div id="tab2" class="tabcontent">
						<h3>单号信息</h3>
						<div class="form">
							<div class="form_row">
								<label>单号:</label> <label id="res_number"></label>
							</div>

							<div class="form_row">
								<label>状态:</label> <label id="res_pstatus"></label>
							</div>

							<div class="form_row">
								<label>最后操作时间:</label> <label id="res_date"></label>
							</div>

							<div class="form_row">
								<label>操作人员:</label> <label id="res_name"></label>
							</div>

							<div class="clear" id="res_change"></div>
						</div>
					</div>


				</div>
			</div>
			<!-- end of right content-->


			<div class="sidebar" id="sidebar">
				<h2>选项</h2>
				<ul>
					<li><input type="button" id="usernav" onclick="userlist(1)"
						value="员工管理" /></li>
					<li><input type="button" id="productnav"
						onclick="productlist(1)" value="单号列表" /></li>
					<li><input type="button" id="pswdnav" onclick="" value="密码修改" /></li>
				</ul>

				<h2>未完成</h2>
				<ul>
					<li><strike>*员工分页</strike></li>
					<li><strike>*单号分页</strike></li>
					<li><strike>*单号查询</strike></li>
					<li><strike>员工点击查询<br />(只需要实现jquery获取工号)
					</strike></li>
					<li><strike>单号列表时间显示<br />(目前已经获取到date型数据)
					</strike></li>
					<li><strike>单号添加操作人数据</strike></li>
					<li><strike>*jquery查询智能显示</strike></li>
					<li><strike>中文乱码</strike></li>
					<li><strike>*系统登出</strike></li>
					<li><strike>员工密码重置</strike></li>
					<li>管理员密码修改</li>
					<li>数据库密码未用md5加密</li>
				</ul>
			</div>

			<div class="clear"></div>
		</div>
		<!--end of center_content-->

		<div class="footer"></div>

	</div>
</body>
</html>