<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User"%>
<% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー成績情報リセット</title>
</head>
<body>
<%=user.getName() %>さんの以下の情報をリセットします。<br>
<br>
〇 勝敗情報（0勝0敗に）<br>
〇 所有カード（全て1枚に）<br>
<br>
よろしいですか？
<form action="/niseron/UserResetServlet" method="post">
<input type="submit" value="実行">
</form><br>
<br>
<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>