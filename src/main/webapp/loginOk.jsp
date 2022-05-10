<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.omi.dto.UserDto" %>
    
<% UserDto user = (UserDto)session.getAttribute("user");%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=user.getId() %>님 환영합니다.
<form action="logoutAction">
<button type="submit">로그아웃</button>
</form>
</body>
</html>