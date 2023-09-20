<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.entity.Account"%>
<%
//セッションスコープから入力情報を取得
Account ac =(Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="admin.js"></script>
<title>みんなでお掃除ちゃん</title>
<style><%@include file="/css/Style.css"%></style>

</head>
<body>
<nav>
        <h1>管理者初期登録・確認画面</h1>
        <ul>
            <li class="list1">家族ID: <%= ac.getGroupId() %></li>
            <li class="list2">家族名: <%= ac.getGroupName() %></li>
            <li class="list3">USERID: <%= ac.getUserId() %></li>
            <li class="list4">USERNAME: <%= ac.getUserName() %></li>
        </ul>
    </nav>
<div class="side">
 <div class="list">
<form id="accountform">
<h2>・アプリの利用者を登録</h2><br>
名前:<input type="text" name="userName" placeholder="*半角英数15文字以内"><br>
パスワード:<input type="text" name="userPass"placeholder="*半角英数15文字以内"><br>
<input type="radio" name="admin_flg" value="admin">管理者
<input type="radio" name="admin_flg" value="user">ユーザー<br>
<button type="button" onclick="createAccountList()">追加</button>
</form>
<table border="1" id="accountList">

<thead>
	<tr>
		<th>NO</th>
		<th>名前</th>
		<th>パスワード</th>
		<th>権限</th>
	</tr>
</thead>
<tbody></tbody>
</table>
</div>

<div class="list">
<form id="locationform">
<h2>・掃除を管理する場所を登録する</h2><br>
場所:<input type="text" name="locationName"placeholder="*例 子供部屋"><br>
キャラクター:<select name="characterName">
<option value="/bath1_3.png">お風呂</option>
<option value="/cactus1_3.png">サボテン</option>
<option value="/cat1_3.png">猫1</option>
<option value="/cat2_3.png">猫2</option>
<option value="/cat3_3.png">猫3</option>
<option value="/flower1.png">花</option>
<option value="/plant1_3.png">木</option>
<option value="/poodle_3.png">犬</option>
<option value="/rabbit1_3.png">ウサギ</option>
</select><br>
場所:<select name="roomPhoto">
<option value="/entrance1.jpg">玄関</option>
<option value="/entrance2.jpg">玄関2</option>
<option value="/entrance3.jpg">玄関3</option>
<option value="/kids1.jpg">子供部屋1</option>
<option value="/kids2.jpg">子供部屋2</option>
<option value="/kids3.jpg">子供部屋3</option>
<option value="/kitchen1.jpg">キッチン</option>
<option value="/lady2.jpg">ベッドルーム</option>
<option value="/lady1.jpg">リビング</option>
<option value="/living1.jpg">リビング2</option>
<option value="/living2.jpg">リビング3</option>
<option value="/oneroom1.jpg">リビング4</option>
<option value="/restroom1.jpg">トイレ</option>
<option value="/restroom2.jpg">トイレ2</option>
</select><br>
頻度:<select name="frequency">
<option value="1">1日間</option>
<option value="2">2日間</option>
<option value="3">3日間</option>
<option value="4">4日間</option>
<option value="5">5日間</option>
<option value="7">7日間</option>
<option value="10">10日間</option>
<option value="14">14日間</option>
</select><br>
獲得ポイント:<select name="setPoint">
<option value="10">10point</option>
<option value="20">20point</option>
<option value="30">30point</option>
<option value="50">50point</option>
<option value="70">70point</option>
<option value="100">100point</option>
<option value="150">150point</option>
<option value="200">200point</option>
</select><br>
<button type="button" onclick="createLocationList()">追加</button>
</form>
<table border="1" id="locationList">
<thead>
	<tr>
		<th>NO</th>
		<th>場所</th>
		<th>キャラクター</th>
		<th>場所画像</th>
		<th>頻度</th>
		<th>POINT</th>
	</tr>
</thead>
<tbody></tbody>
</table>
</div>
<div class="list">
<form id="trophyform">
<h2>・ご褒美の内容を登録する</h2><br>
ご褒美の内容:<input type="text" name="details"placeholder="*例 お小遣い500円"><br>
必要ポイント:<select name="needpoint">
<option value="100">100point</option>
<option value="300">300point</option>
<option value="500">500point</option>
<option value="800">800point</option>
<option value="1000">1000point</option>
<option value="2000">2000point</option>
<option value="3000">3000point</option>
<option value="5000">5000point</option>
</select><br>
<button type="button" onclick="createTrophyList()">追加</button>
</form>
<table border="1" id="trophyList">
<thead>
	<tr>
		<th>NO</th>
		<th>ご褒美の内容</th>
		<th>必要なPOINT</th>
	</tr>
</thead>
<tbody></tbody>
</table>
</div>
</div>



<form id="myform" action="/MinnadeOsoziChan/FirstAdminRegistServlet" method="post">
<button onClick="list()">登録</button>
</form>
</body>
</html>