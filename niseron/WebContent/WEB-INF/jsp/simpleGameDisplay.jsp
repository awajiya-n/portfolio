<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.IOException,java.util.ArrayList,model.User,model.GameConfig,model.UseCard,model.GameSetting,model.GuessResult"%>
<%
User user = (User)session.getAttribute("user");
User rivalUser = (User)session.getAttribute("rivalUser");
GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");
GameSetting gameSetting =(GameSetting)session.getAttribute("gameSetting");
UseCard userUseCard = (UseCard)session.getAttribute("userUseCard");
UseCard rivalUseCard = (UseCard)session.getAttribute("rivalUseCard");
GuessResult guessResult = (GuessResult)session.getAttribute("guessResult");
%>
<%
String firstPlayer = gameSetting.getFirstPlayer();
User turnPlayer = new User();
UseCard turnPlayerUseCard = new UseCard();

if(gameSetting.getTurnCount()%2==1){
	switch(firstPlayer){
		case "user":
			turnPlayer = user; turnPlayerUseCard = userUseCard;
			break;
		case "rival":
			turnPlayer = rivalUser; turnPlayerUseCard = rivalUseCard; }
	}
else if(gameSetting.getTurnCount()%2==0){
	switch(firstPlayer){
	case "user":
		turnPlayer = rivalUser; turnPlayerUseCard = rivalUseCard;
		break;
	case "rival":
		turnPlayer = user; turnPlayerUseCard = userUseCard; }
}

ArrayList<ArrayList<Integer>> result = guessResult.getResult();
ArrayList<ArrayList<Integer>> guessNumber = guessResult.getGuessNumber();
%>
<!DOCTYPE html>
<html>
<style>

</style>
<head>
<meta charset="UTF-8">
<title><%= gameSetting.getTurnCount() %>ターン目 <%= turnPlayer.getName() %>さんのターン</title>
</head>
<body>
<h3><%= gameSetting.getTurnCount() %>ターン目</h3>
<h2><%= turnPlayer.getName() %>さんのターン</h2>
<h3><%= turnPlayer.getName() %>さんの数字：<%= turnPlayerUseCard.getFirstNumber() %><%= turnPlayerUseCard.getSecondNumber() %><%= turnPlayerUseCard.getThirdNumber() %></h3>
<br>
相手の数字
<form action="/niseron/GamePlayServlet" method="post">
<a class="guess">
<select name="firstGuess" size="10">
	<option value="0" selected>&nbsp;0&nbsp;</option>
	<option value="1">&nbsp;1&nbsp;</option>
	<option value="2">&nbsp;2&nbsp;</option>
	<option value="3">&nbsp;3&nbsp;</option>
	<option value="4">&nbsp;4&nbsp;</option>
	<option value="5">&nbsp;5&nbsp;</option>
	<option value="6">&nbsp;6&nbsp;</option>
	<option value="7">&nbsp;7&nbsp;</option>
	<option value="8">&nbsp;8&nbsp;</option>
	<option value="9">&nbsp;9&nbsp;</option>
</select>
</a>
<a class="guess">
<select name="secondGuess" size="10">
	<option value="0" selected>&nbsp;0&nbsp;</option>
	<option value="1">&nbsp;1&nbsp;</option>
	<option value="2">&nbsp;2&nbsp;</option>
	<option value="3">&nbsp;3&nbsp;</option>
	<option value="4">&nbsp;4&nbsp;</option>
	<option value="5">&nbsp;5&nbsp;</option>
	<option value="6">&nbsp;6&nbsp;</option>
	<option value="7">&nbsp;7&nbsp;</option>
	<option value="8">&nbsp;8&nbsp;</option>
	<option value="9">&nbsp;9&nbsp;</option>
</select>
</a>
<a class="guess">
<select name="thirdGuess" size="10">
	<option value="0" selected>&nbsp;0&nbsp;</option>
	<option value="1">&nbsp;1&nbsp;</option>
	<option value="2">&nbsp;2&nbsp;</option>
	<option value="3">&nbsp;3&nbsp;</option>
	<option value="4">&nbsp;4&nbsp;</option>
	<option value="5">&nbsp;5&nbsp;</option>
	<option value="6">&nbsp;6&nbsp;</option>
	<option value="7">&nbsp;7&nbsp;</option>
	<option value="8">&nbsp;8&nbsp;</option>
	<option value="9">&nbsp;9&nbsp;</option>
</select>
</a>
<input type="submit" value="確定"><br>
<br>
<%-- 全ての履歴を表示させる場合 --%>

<% for(int i = 0;i < result.size();i++){ %>
	<%-- ターン数表示 --%>
	<%= i+1 %>ターン目&nbsp;
	<%-- プレイヤー名表示 --%>
	<% if(i%2 == 0){
		if(gameSetting.getFirstPlayer().equals("user")){ %>
			<%= user.getName() %>&nbsp;
		<% }else if(gameSetting.getFirstPlayer().equals("rival")){ %>
			<%= rivalUser.getName() %>&nbsp;
		<% }
		}else if(i%2 == 1){
			if(gameSetting.getFirstPlayer().equals("user")){ %>
			<%= rivalUser.getName() %>&nbsp;
		<% }else if(gameSetting.getFirstPlayer().equals("rival")){ %>
			<%= user.getName() %>&nbsp;
		<% }
		}
	%>
	<%-- 予想履歴表示 --%>
	予想数字:<%= guessNumber.get(i).get(0) %><%= guessNumber.get(i).get(1) %><%= guessNumber.get(i).get(2) %>&nbsp;&nbsp;
	<%= result.get(i).get(0) %>EAT&nbsp;
	<%= result.get(i).get(1) %>BITE<br>
<% } %>


<%-- 自分の選択のみ表示する場合 --%>
<%--
<%
if(gameSetting.getTurnCount()%2==1)
	{for(int i = 0;i < result.size();i+=2)
	{
%>
	<%= i+1 %>ターン目&nbsp;
	if(gameSetting.getFirstPlayer().equals("user")){ %>
		<%= user.getName() %>&nbsp;
	<% }else if(gameSetting.getFirstPlayer().equals("rival")){ %>
		<%= rivalUser.getName() %>&nbsp;
	予想数字:<%= guessNumber.get(i).get(0) %><%= guessNumber.get(i).get(1) %><%= guessNumber.get(i).get(2) %>&nbsp;&nbsp;
	<%= result.get(i).get(0) %>EAT&nbsp;
	<%= result.get(i).get(1) %>BITE<br>
<%
		}
	}
else if(gameSetting.getTurnCount()%2==0){
	for(int i = 1;i < result.size();i+=2)
	{
%>
	<%= i+1 %>ターン目&nbsp;
	if(gameSetting.getFirstPlayer().equals("user")){ %>
		<%= rivalUser.getName() %>&nbsp;
	<% }else if(gameSetting.getFirstPlayer().equals("rival")){ %>
		<%= user.getName() %>&nbsp;
	予想数字:<%= guessNumber.get(i).get(0) %><%= guessNumber.get(i).get(1) %><%= guessNumber.get(i).get(2) %>&nbsp;&nbsp;
	<%= result.get(i).get(0) %>EAT&nbsp;
	<%= result.get(i).get(1) %>BITE<br>
<%
	}
}
%>
--%>

</form>

</body>

</html>