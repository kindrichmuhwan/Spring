<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>성적 결과</h1>
    <p>과목별 성적
   수학 점수 : ${math }<br/>
   영어 점수 : ${eng }<br/>
   언어 점수 : ${lan }<br/>
   사회탐구 점수 : ${social }<br/>
   컴퓨터 점수 : ${com }<br/>
 <hr/>  
 <p>총점 과 평균</p>
   성적 총점 : ${total }<br/>
   평균 점수 : ${avg } 입니다.
</body>
</html>