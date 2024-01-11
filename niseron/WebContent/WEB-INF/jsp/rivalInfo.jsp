<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>対戦相手設定</title>
</head>
<body>

<form action="/niseron/GameStartServlet" method="post">
<dl>
<dt class="pr1"><h3>対人戦</h3></dt>
<dd><h4>ユーザーと対戦</h4></dd>
<dd>ユーザー名 <input type="text" name="name" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数20文字以内" required></dd>
<dd>パスワード <input type="password" name="pass" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数20文字以内" required></dd>
<dd><input type="submit" value="ユーザーと対戦"></dd>
</dl>
<input type="hidden" name="rivalMode" value="u">
</form>

<br>

<form action="/niseron/GameStartServlet" method="post">
<dl>
<dd><h4>ゲストログイン</h4></dd>
<dd>ユーザー名</dd>
<dd><input type="text" name="name" placeholder="未入力の場合は「ゲスト」"></dd>
<dd><input type="submit" value="ゲストユーザーと対戦"></dd>
</dl>
<input type="hidden" name="rivalMode" value="g">
</form>

<br>

<!-- <form action="/niseron/GameStartServlet" method="post"> -->
<dl>
<dt class="pr1"><h3>CPU戦</h3></dt>
<dd><input type="submit" value="CPUと対戦(未実装)"></dd>
</dl>
<!-- <input type="hidden" name="rivalMode" value="c">
</form> -->
</body>
</html>