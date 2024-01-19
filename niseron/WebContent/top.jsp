<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ニセロンTOP</title>

<style>
.pr1 {text-decoration: underline}
</style>

</head>
<body>

<h2>ニセロンへようこそ！</h2>
<dl>
<dt class="pr1"><h3>ニセロンとは？</h3></dt>
<dd>ヌ〇ロンのパクリです</dd>
<dd>〇メロンのルールについては<a href="https://ja.wikipedia.org/wiki/Numer0n#%E3%83%AB%E3%83%BC%E3%83%AB" target="_blank">コチラ</a>を参照</dd>
</dl>

<dl>
<dt class="pr1"><h3>新規登録</h3></dt>
<dd><a href="/niseron/SignUpServlet">登録画面へ</a></dd>
</dl>

<form action="/niseron/LoginServlet" method="post">
<dl>
<dt class="pr1"><h3>ログイン</h3></dt>
<dd><h4>ユーザーログイン</h4></dd>
<dd>ユーザー名 <input type="text" name="name" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数 4文字以上 20文字以内" required></dd>
<dd>パスワード <input type="password" name="pass" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数 4文字以上 20文字以内" required></dd>
<dd><input type="submit" value="ログイン"></dd>
</dl>
<input type="hidden" name="userType" value="u">
</form>

<form action="/niseron/LoginServlet" method="get">
<dl>
<dd><h4>ゲストログイン</h4></dd>
<dd>ユーザー名</dd>
<dd><input type="text" name="name" placeholder="未入力の場合は「ゲスト」" maxlength="20" pattern="{a-z}[A-Z][0-9]" title="半角英数 4文字以上 20文字以内"></dd>
<dd><input type="submit" value="ゲストとしてログイン"></dd>
</dl>
</form>

</body>
</html>