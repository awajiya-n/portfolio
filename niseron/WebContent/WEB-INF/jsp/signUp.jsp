<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h2>ユーザー登録</h2>
<h3>以下の項目を入力して登録を実施してください</h3>
<form action="/niseron/SignUpServlet" method="post">
ユーザー名：<input type="text" name="name" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数 20文字以内" required><br>
パスワード：<input type="text" name="pass" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数 20文字以内" required>
<input type="submit" value="決定">
</form>
<br>
<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>