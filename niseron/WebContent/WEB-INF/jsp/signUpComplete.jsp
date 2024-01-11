<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "model.User"%>
<% User signUpUser = (User)session.getAttribute("signUpUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<h2>登録が完了しました！</h2>
ユーザー名:<%= signUpUser.getName() %><br>
パスワード:<%= signUpUser.getPass() %><br>
<br>
<a href="/niseron/top.jsp" onclick='<% session.removeAttribute("signUpUser"); %>'>トップへ</a>
</body>
</html>