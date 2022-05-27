<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인<br>
<p>
<%
String errMsg = (String)request.getAttribute("errMsg");
if(errMsg!=null && !errMsg.equals("")){
%>
<%=errMsg %>
<%
}
%>
<%=request.getParameter("id") %>
</p>
<form action="login" method="post">
id:<input type="text" name="id" value="test"><br>
pw:<input type="text" name="pw" value="1234"><br>
<button type="submit">로그인</button>
</form>
</body>
</html>


<!--  
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
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
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
test
-->