<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>member 주소</h1>
       <sec:authorize access="isAuthenticated()">
			<!-- 로그인 한(인증된)사용자인 경우 --> 
			   <a href="/customLogout">로그아웃</a>
			 </sec:authorize>  
       
       
       <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
       	 <a href="/secu/admin">관리자페이지로 가기</a>
       </sec:authorize> 
</body>
</html>