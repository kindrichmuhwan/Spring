<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <h1>연결확인부터 합니다.</h1>
        ${boardList }
       <hr/>
       <hr/>
       
        <table border="1">
           <tr>
             <th>글번호</th>
             <th>제목</th>
             <th>작성자</th>
             <th>쓴날짜</th>
             <th>수정날짜</th>
           </tr>
           <c:forEach var="board" items="${boardList}">
	            <tr>
	                <td>${board.bno}</td>
	                <td><a href="/boardDetail">${board.title}</td>
	                <td>${board.writer}</td>
	                <td>${board.regdate}</td>
	                <td>${board.updatedate}</td>
	            </tr>
           </c:forEach>   
        </table>
</body>
</html>
             
	              