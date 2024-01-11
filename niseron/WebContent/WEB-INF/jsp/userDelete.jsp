<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User"%>
<% User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報削除処理</title>
<style>
.coution {font-weight: bold; color: red}
</style>
</head>
<body>
<%=user.getName() %>さんの情報を全て削除します。<br>
<br>
よろしいですか？<br>
<a class="coution">※ 復旧は出来ません ※</a>
<form action="/niseron/UserDeleteServlet" method="post">
<input type="submit" value="実行">
</form><br>
<br>
<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>