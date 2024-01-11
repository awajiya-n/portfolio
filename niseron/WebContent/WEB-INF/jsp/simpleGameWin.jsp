<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.IOException,java.util.ArrayList,model.User,model.GameConfig,model.UseCard,model.GameSetting,model.GuessResult"%>
<%
User user = (User)session.getAttribute("user");
User rivalUser = (User)session.getAttribute("rivalUser");
GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting");
GuessResult guessResult = (GuessResult)session.getAttribute("guessResult");
UseCard userUseCard = (UseCard)session.getAttribute("userUseCard");
UseCard rivalUseCard = (UseCard)session.getAttribute("rivalUseCard");

User turnPlayer = new User();
if(gameSetting.getTurnCount()%2 == 1){
	turnPlayer = user;
	}
else if(gameSetting.getTurnCount()%2 == 0){
	turnPlayer = rivalUser ;
	}

ArrayList<ArrayList<Integer>> result = guessResult.getResult();
ArrayList<ArrayList<Integer>> guessNumber = guessResult.getGuessNumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= turnPlayer.getName() %>さんの勝利！</title>
</head>
<body>
<h1><%= turnPlayer.getName() %>さんの勝利！</h1>
<br>
<h3>予想履歴</h3>
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
<br>
<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>