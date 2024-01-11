<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.GameConfig,model.UseCard,model.GameSetting"%>
<%
User user = (User)session.getAttribute("user");
User rivalUser = (User)session.getAttribute("rivalUser");
GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");
GameSetting gameSetting =(GameSetting)session.getAttribute("gameSetting");
UseCard userUseCard = (UseCard)session.getAttribute("userUseCard");
UseCard rivalUseCard = (UseCard)session.getAttribute("rivalUseCard");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>準備中</title>
</head>
<body>
準備中です<br>
<br>
<%= user.getName() %>の選択した数字<Br>
<%= userUseCard.getFirstNumber() %><%= userUseCard.getSecondNumber() %><%= userUseCard.getThirdNumber() %><br>
<br>
<%= rivalUser.getName() %>の選択した数字<Br>
<%= rivalUseCard.getFirstNumber() %><%= rivalUseCard.getSecondNumber() %><%= rivalUseCard.getThirdNumber() %><br>
<br>
<br>
ゲーム設定<br>
ゲームモード：<%if(gameConfig.getGameMode().equals("s")){ %>シンプルモード<% }
			    else if(gameConfig.getGameMode().equals("c")){ %>カスタムモード<% }; %><br>
初手プレイヤー：<%if(gameSetting.getFirstPlayer().equals("user")){ %><%= user.getName() %><% }
				else if(gameSetting.getFirstPlayer().equals("rival")){ %><%= rivalUser.getName() %><% }; %>
</body>
</html>