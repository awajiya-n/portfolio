<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.RiddleLogic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/css/nazotoki.css" %>
</style>
<title>謎解き道場</title>
</head>
<body>
 <div class="main">
 <h3>謎解きとは</h3>
 <p class="kimarimonku">クイズのように「知識」が無ければ解けないものではなく、<br>「ひらめき」を駆使して問題を解くもの</p>
 <input type="button" value="スタート" onclick = "location.href = '/nazotoki/RiddleServlet'">
</body>
</html>