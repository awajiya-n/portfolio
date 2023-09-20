<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	<%@ include file="/css/Style.css" %>
	#touroku{
		font-size:20px;
		font-weight:bold;
		font-family:"ヒラギノ丸ゴ Pro W4","Hiragino Maru Gothic Pro",sans-serif;
		background:#97cdf3;
		color:#ffffff;
		border-radius:20％;
		padding:18px 32px;
	}
	h2{
		font-size:35px;
		font-family:"ヒラギノ丸ゴ Pro W4","Hiragino Maru Gothic Pro",sans-serif;
		color:#97cdf3;
		display:flex;
		justify-content:center;
		margin-top:5%;
	}
</style>
<title>利用管理者登録画面</title>
</head>
<script type="text/javascript" charset="UTF-8">
function check() {
  if(document.forms[0].groupName.value == "" |
     document.forms[0].userName.value == "" |
     document.forms[0].userPass.value == "") {
       alert('空欄、もしくは入力情報が　半角英数字15字　以内ではないようです');
       return false;
    }
    return true;
}
</SCRIPT>
<body>
<h2>アプリの管理者の登録を行います</h2>
<form action="/MinnadeOsoziChan/SignUpCheckServlet" method="POST">
<p>あなたの家族名やグループ名:<input type="text" name="groupName" placeholder="*半角英数15文字以内" ID="text"></p><br>
<p>あなたのお名前:<input type="text" name="userName" placeholder="*半角英数15文字以内" ID="text"></p><br>
<p>あなたのパスワード:<input type="text" name="userPass" placeholder="*半角英数15文字以内" ID="text"></p><br>
<input type="hidden" name="adminFlg" value=1>
<input type="hidden" name="userId" value=0>
<input type="submit" value="登録する" ID="touroku" onclick='return check()'>
</form>
</body>
</html>