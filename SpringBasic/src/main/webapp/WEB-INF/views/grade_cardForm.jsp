<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>성적 입력창입니다.</h1>
   <form action="/score" method="post">
 수 학 :   <input type="number" name="math" placeholder="수학점수"><br/>
 영 어 :   <input type="number" name="eng" placeholder="영어점수"><br/>
 언 어 :   <input type="number" name="lan" placeholder="언어점수"><br/>
 사 탐 :   <input type="number" name="social" placeholder="사탐점수"><br/>
 컴퓨터 :   <input type="number" name="computer" placeholder="컴퓨터점수"><br/>
   <input type="submit" value="제출">
   </form>
</body>
</html>