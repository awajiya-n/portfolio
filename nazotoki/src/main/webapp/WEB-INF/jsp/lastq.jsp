<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Answer,model.RiddleLogic" %>
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
<title>最終問題</title>
</head>
<body>
<form name="wrong" action="/nazotoki/RiddleServlet" method="POST">
<input type=hidden onsubmit="<% answer.setNext(6); session.setAttribute("answer",answer);%>" name="q5" value="wrong">
</form>
<form name="correct" action="/nazotoki/RiddleServlet" method="POST">
<input type=hidden onsubmit="<% answer.setNext(6); session.setAttribute("answer",answer);%>" name="q5" value="correct">
</form>

<a onclick="javascript:document.wrong.submit()"><h2><p>おめでとうございます！4問全て正解です！</p></h2>
<p>優秀なあなたへ最後の問題をプレゼントします！<br>なお、クリックできるのは1回だけです！</p></a>
<h2><a onclick="javascript:document.correct.submit()">L</a><a onclick="javascript:document.wrong.submit()">AST QUESTION</a></a></h2>
<div class="lastq"><a onclick="javascript:document.wrong.submit()"><img src="img/lastquestion.png" alt="最終問題"></a></div>
</body>
</html>