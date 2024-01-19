<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User"%>
<% User user = (User)session.getAttribute("user"); %>
<% double winningRate = (double)user.getWinPoint()/((double)user.getWinPoint()+(double)user.getLosePoint());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プレイヤー対戦設定</title>

<style>
.pr1 {text-decoration: underline;}
fieldset {width:110px}
h4 {background:lightgreen; padding:10px; width:180px; height:15px; padding:5px;}
</style>

</head>
<body>

<h2>ようこそ <%=user.getName() %>さん！</h2>
<% if(user.getUserType().equals("u")){ %>
<br>
<h3>対戦成績</h3>
<%= user.getWinPoint() %>勝 <%= user.getLosePoint() %>敗

<% if(user.getWinPoint()+user.getLosePoint()!=0){ %>
<br>
勝率：<%= (double)Math.round(winningRate*1000)/10 %> %
<% } %>
<br>
<% } %>
<br>
<form action="/niseron/CardCheckServlet" method="post">
<dl>
<dt class="pr1"><h3>モード選択</h3></dt>
<dd><h4>シンプルモード</h4></dd>
<dd>アイテム：なし</dd>
<dd><input type="submit" value="シンプルモード"></dd>
</dl>
<input type="hidden" name="double" value="off">
<input type="hidden" name="highlow" value="off">
<input type="hidden" name="target" value="off">
<input type="hidden" name="slash" value="off">
<input type="hidden" name="shuffle" value="off">
<input type="hidden" name="change" value="off">
<input type="hidden" name="gameMode" value="s">
</form>

<form action="/niseron/CardCheckServlet" method="post">

<dl>

<dd><h4>カスタムモード(準備中)</h4></dd>
<dd>アイテム</dd>

<dd>
<fieldset>
<legend>DOUBLE</legend>
<label><input type="radio" name="double" value="on">ON</label>
<label><input type="radio" name="double" value="off" checked>OFF</label>
</fieldset>
</dd>

<dd>
<fieldset>
<legend>HIGH&LOW</legend>
<label><input type="radio" name="highlow" value="on">ON</label>
<label><input type="radio" name="highlow" value="off" checked>OFF</label>
</fieldset>
</dd>

<dd>
<fieldset>
<legend>TARGET</legend>
<label><input type="radio" name="target" value="on">ON</label>
<label><input type="radio" name="target" value="off" checked>OFF</label>
</fieldset>
</dd>

<dd>
<fieldset>
<legend>SLASH</legend>
<label><input type="radio" name="slash" value="on">ON</label>
<label><input type="radio" name="slash" value="off" checked>OFF</label>
</fieldset>
</dd>

<dd>
<fieldset>
<legend>SHUFFLE</legend>
<label><input type="radio" name="shuffle" value="on">ON</label>
<label><input type="radio" name="shuffle" value="off" checked>OFF</label>
</fieldset>
</dd>

<dd>
<fieldset>
<legend>CHANGE</legend>
<label><input type="radio" name="change" value="on">ON</label>
<label><input type="radio" name="change" value="off" checked>OFF</label>
</fieldset>
</dd>
<dd><input type="submit" value="カスタムモード"></dd>

</dl>
<input type="hidden" name="gameMode" value="c">
</form>
<% if(user.getUserType().equals("u")){ %>
<button onclick="location.href='/niseron/UserResetServlet'">ユーザー情報リセット画面へ</button><br>
<br>
<button onclick="location.href='/niseron/UserDeleteServlet'">ユーザー削除画面へ</button><br>
<% } %>
</body>
</html>