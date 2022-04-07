<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>접속확인부터 합니다.</h1>
  ${board }
  <hr/>
  <table border="1">
      <tr>
        <th>회원번호</th>
        <th>글제목</th>
        <th>글내용</th>
        <th>글쓴이</th>
        <th>등록날짜</th>
        <th>수정날짜</th>
      </tr>
     <c:forEach var="detail" items="${board}">
	      <tr>
	          <td>${board.bno}</td>
	          <td>${board.title}</td>
	          <td>${board.writer}</td>
	          <td>${board.regdate}</td>
	          <td>${board.updatedate}</td>
	       </tr>
      </c:forEach>  
  </table>
</body>
</html>