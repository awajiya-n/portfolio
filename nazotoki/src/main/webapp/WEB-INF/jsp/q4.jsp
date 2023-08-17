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
<title>問4</title>
</head>
<body>
<h3>第4問</h3>
<h2><p class="mondaibun">『T い O』これ、誰？</p> </h2>  
<div class="onepiece">
	<form name="op1" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=1>
	</form>
	<form name="op2" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=2>
	</form>	
	<form name="op3" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=3>
	</form>
	
	<a href="javascript:document.op1.submit()"><img src="img/onepiece01_luffy.png" alt="ルフィ" width=100px></a>
	<a href="javascript:document.op2.submit()"><img src="img/onepiece02_zoro_bandana.png" alt="ゾロ" width=100px></a>
	<a href="javascript:document.op3.submit()"><img src="img/onepiece03_nami.png" alt="ナミ" width=100px></a>

	<form name="op4" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=4>
	</form>
	<form name="op5" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=5>
	</form>
	<form name="op6" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=6>
	</form>
	
	<a href="javascript:document.op4.submit()"><img src="img/onepiece04_usopp_sogeking.png" alt="ウソップ" width=100px></a>
	<a href="javascript:document.op5.submit()"><img src="img/onepiece05_sanji.png" alt="サンジ" width=100px></a>
	<a href="javascript:document.op6.submit()"><img src="img/onepiece06_chopper.png" alt="チョッパー" width=100px></a>

	<form name="op7" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=7>
	</form>
	<form name="op8" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=8>
	</form>
	<form name="op9" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=9>
	</form>

	<a href="javascript:document.op7.submit()"><img src="img/onepiece07_robin.png" alt="ロビン" width=100px></a>
	<a href="javascript:document.op8.submit()"><img src="img/onepiece08_franky.png" alt="フランキー" width=100px></a>
	<a href="javascript:document.op9.submit()"><img src="img/onepiece09_brook.png" alt="ブルック" width=100px></a>

	<form name="op10" action="/nazotoki/RiddleServlet" method="POST">
		<input type=hidden onsubmit="<% 	answer.setNext(5); session.setAttribute("answer",answer); %>" name="q4" value=10>
	</form>
	<a href="javascript:document.op10.submit()"><img src="img/onepiece10_jinbe.png" alt="ジンベエ" width=100px></a>

</body>
</html>