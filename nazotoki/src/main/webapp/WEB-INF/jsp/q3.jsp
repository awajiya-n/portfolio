<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Answer , model.RiddleLogic" %> 
<%
Answer answer = (Answer) session.getAttribute("answer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/css/nazotoki.css" %>
</style>
<title>問3</title>
</head>
<body>
     <div class="question3">
       <h3>第3問</h3>
       <form action="/nazotoki/RiddleServlet" method="post">
       <h2><p class="mondaibun">宇宙に行くと御飯がおいしく感じなくなる理由は？</p></h2>   
       <select name="q3">
         <option value=1>▼ここから選択▼</option>
         <option value=2>宇宙食が美味しくないから</option>
         <option value=3>人間の体の問題</option>
         <option value=4>空気が無くなるから</option>
         <option value=5>重力が無くなるから</option>
         <option value=6>緊張するから</option>
        </select>
         <br>
         <br>
         <input class="button" type="submit" onsubmit="<% 	answer.setNext(4); session.setAttribute("answer",answer); %>" value="解答">
       </form>
     </div>
</body>
</html>