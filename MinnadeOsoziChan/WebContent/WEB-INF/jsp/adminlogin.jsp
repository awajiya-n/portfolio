<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.Account" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%-- <%
 Account ac = (Account)session.getAttribute("account");
 %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file="/css/Style.css" %>
</style>
<title>ログイン画面選択</title>
</head>
<body>
<h3>どちらにログインしますか？</h3><br>
	<form name="admin" action="/MinnadeOsoziChan/UserPageServlet" method="GET">
		<input type=hidden name="Login_Flg" value=0>
	</form>
<a href="javascript:document.admin.submit()">管理者画面へ</a>

	<form name="user" action="/MinnadeOsoziChan/UserPageServlet" method="GET">
		<input type=hidden name="Login_Flg" value=1>
	</form>
<a href="javascript:document.user.submit()">ユーザー画面へ</a>
</body>
</html>