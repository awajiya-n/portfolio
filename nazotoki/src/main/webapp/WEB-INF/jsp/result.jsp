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
<title>結果発表</title>
</head>
<body>
<h3>結果</h3>
<p>問1：<%=answer.getQ1Result() %></p>
<p>問2：<%=answer.getQ2Result() %></p>
<p>問3：<%=answer.getQ3Result() %></p>
<p>問4：<%=answer.getQ4Result() %></p>
<p><%=answer.getQ5Result() %></p>
<p>問1～問4を全て正解すると最終問題が出題されるよ！</p>
<% session.invalidate(); %>
 <input type="button" value="再チャレンジ" onclick = "location.href = '/nazotoki/RiddleServlet'">
</body>
</html>