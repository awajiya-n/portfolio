<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file="/css/Style.css" %>
	h1{
		font-size:50px;
		font-family:"ヒラギノ丸ゴ Pro W4","Hiragino Maru Gothic Pro",sans-serif;
		color:#97cdf3;
		display:flex;
		justify-content:center;
		margin-top:20%;
	}
	#admin{
		font-size:30px;
		font-weight:bold;
		font-family:"ヒラギノ丸ゴ Pro W4","Hiragino Maru Gothic Pro",sans-serif;
		background:#97cdf3;
		color:#ffffff;
		border-radius:20%;
		padding:18px 32px;
		dispay:flex;
		justify-content:space-between;
	}
	#user{
		font-size:30px;
		font-weight:bold;
		font-family:"ヒラギノ丸ゴ Pro W4","Hiragino Maru Gothic Pro",sans-serif;
		background:#97cdf3;
		color:#ffffff;
		border-radius:20%;
		padding:15px 30px;
		dispay:flex;
		justify-content:space-between;
	}
</style>
<title>トップページ</title>
</head>
<body>
<h1>みんなでお掃除ちゃん</h1>
<form action="?" method="GET">
 <button formaction="/MinnadeOsoziChan/SignUpServlet" ID="admin">利用者登録</button>
 <button formaction="/MinnadeOsoziChan/LoginServlet" ID="user">ログイン</button>
</form>
</body>
</html>