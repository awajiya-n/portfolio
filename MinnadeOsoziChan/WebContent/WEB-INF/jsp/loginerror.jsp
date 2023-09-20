<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file="/css/Style.css" %>
</style>
<title>ログインエラー</title>
</head>
<body>
<h3>ログインに失敗しました。<br></h3>
<a>トップからやり直してください。<br></a>
<br>
<form name="top" action="/MinnadeOsoziChan/StartServlet" method="POST"></form>
<a href="javascript:document.top.submit()">トップへ</a>
</body>
</html>