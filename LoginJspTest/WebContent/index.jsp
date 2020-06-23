<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String errMsg = null;
	if("POST".equalsIgnoreCase(request.getMethod())&&request.getParameter("submit")!=null){
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		if("admin".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)){
			out.println("登陆成功");
			return;
		}else{
			errMsg = "账号或者密码错误";
		}
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 340px;height: 200px;margin: 0 auto; margin-top: 12%;background-color: #2b4b6b;">
		<h2>登陆</h2>
		<form method="post">
			<% if(errMsg != null){ %>
				<span style="color:red;"><% out.print(errMsg); %></span>
			<% } %>	
			账号: <input type="text" name="userName"/><br/>
			密码: <input type="passWord" name="password"/><br/><br/>
			<button type="submit" name="submit">登陆</button>
			<button type="reset">重置</button>
		</form>
	</div>
</body>n
</html>