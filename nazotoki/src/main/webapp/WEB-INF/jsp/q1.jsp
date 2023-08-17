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
<title>問1</title>
</head>
<body>
     <div class="question1">
       <h3>第1問</h3>
       <h2><p class="mondaibun">ビデオ÷お寿司＝？</p></h2>
       <form action="/nazotoki/RiddleServlet" method="post" >
       		解答入力欄 <input type="text" name="q1"><br>
       		<br>
       		<input class="button" type="submit" onsubmit="<% answer.setNext(2); session.setAttribute("answer",answer); %>" value="解答">
       </form>
     </div>
</body>
</html>