<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import ="model.User,model.CardDate,model.GameConfig,model.GameSetting"%>
<% User user = (User)session.getAttribute("user"); %>
<% User rivalUser = (User)session.getAttribute("rivalUser"); %>
<% CardDate userCardDate = (CardDate)session.getAttribute("userCardDate"); %>
<% CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate"); %>
<% GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig"); %>
<% GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting"); %>
<%
String firstPlayer = gameSetting.getFirstPlayer();
CardDate turnPlayerCardDate = new CardDate();

if(firstPlayer.equals("user")){turnPlayerCardDate = userCardDate;}
else if(firstPlayer.equals("rival")){turnPlayerCardDate = rivalCardDate;}

User turnPlayer = new User();
if(firstPlayer.equals("user")){turnPlayer = user; }
else if(firstPlayer.equals("rival")){turnPlayer = rivalUser;}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= turnPlayer.getName() %>さんの選択</title>
</head>
<body>
<h2><% if(gameSetting.getPlayerSettingFlag()==1){ %><%= turnPlayer.getName() %>さんが先攻です<% } %></h2>
<h3><%= turnPlayer.getName() %>さんはカードを選択してください。</h3>
次からの画面は<%= turnPlayer.getName() %>さんだけが見るようにしてください。<br>
<br>
<form action="/niseron/GameSettingServlet" method="get">
<input type="hidden" name="goFlag" value="1">
<input type="submit" value="カード選択へ">
</form>
</body>
</html>