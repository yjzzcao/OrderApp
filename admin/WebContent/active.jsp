<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台活动</title>
</head>
<body>
	<div>
		<p>receive</p>
		<form name="receive" action="ReceiveAction" method="post">
			number:<input type=text name="re_number" />name:<input type=text
				name="username" /> <input type="submit" value="ok" />
		</form>
	</div>
	<div>
		<p>send</p>
		<form name="send" action="SendAction" method="post">
			number:<input type=text name="se_number" />name:<input type=text
				name="username" /> <input type="submit" value="ok" />
		</form>
	</div>

</body>
</html>