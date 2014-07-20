<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>单号系统后台管理 - 登陆</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<body>
	<div id="loginpanelwrap">

		<div class="loginheader">
			<div class="logintitle">
				<a href="#">单号系统后台管理</a>
			</div>
		</div>
		<form name="" action="ManageAction" method="post">
			<div class="loginform">

				<div class="loginform_row">
					<label>Manager:</label> <input type="text" class="loginform_input"
						name="name" />
				</div>
				<div class="loginform_row">
					<label>Password:</label> <input type="password"
						class="loginform_input" name="pswd" />
				</div>
				<div class="loginform_row">
					<input type="submit" class="loginform_submit" value="Login" />
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</body>
</html>