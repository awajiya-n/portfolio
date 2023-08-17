<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/css/nazotoki.css" %>
</style>
<title>Congratulations!</title>
</head>
<body>
<h1>最終問題正解！</h1>
<h2>おめでとうございます！</h2>
<% session.invalidate(); %>
 <input type="button" value="TOPへ" onclick = "location.href = '/nazotoki/top.jsp'">
</body>
</html>