<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file="/css/Style.css" %>
</style>
<title>ログイン</title>
</head>
<body>
<h2>ログイン</h2>
<form action="/MinnadeOsoziChan/LoginCheckServlet" method="post">
<p>家族ID：<input type="text" name="group_id"></p>
<p>ユーザーパスワード：<input type="text" name="user_pass"></p>
<input type="submit" value="ログイン">
</form>
</body>
</html>