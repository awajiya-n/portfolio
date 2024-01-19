<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.CardDate,model.GameConfig,model.GameSetting,model.UseCard"%>
<% User user = (User)session.getAttribute("user"); %>
<% User rivalUser = (User)session.getAttribute("rivalUser"); %>
<% CardDate userCardDate = (CardDate)session.getAttribute("userCardDate"); %>
<% CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate"); %>
<% GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig"); %>
<% GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting"); %>
<% UseCard userUseCard =(UseCard)session.getAttribute("userUseCard"); %>
<% UseCard rivalUseCard =(UseCard)session.getAttribute("rivalUseCard"); %>
<%
String firstPlayer = gameSetting.getFirstPlayer();
CardDate turnPlayerCardDate = new CardDate();

if(firstPlayer.equals("user")){turnPlayerCardDate = userCardDate;}
else if(firstPlayer.equals("rival")){turnPlayerCardDate = rivalCardDate;}

User turnPlayer = new User();
if(firstPlayer.equals("user")){turnPlayer = user; }
else if(firstPlayer.equals("rival")){turnPlayer = rivalUser;}

UseCard turnPlayerUseCard = new UseCard();
if(firstPlayer.equals("user")){turnPlayerUseCard = userUseCard;}
else if(firstPlayer.equals("rival")){turnPlayerUseCard = rivalUseCard;}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= turnPlayer.getName() %>さんのカード選択確認</title>
</head>
<body>
<h4><%= turnPlayer.getName() %>さんの選択カードは</h4>
<h2><%= Integer.valueOf(turnPlayerUseCard.getFirstNumber()).toString()+turnPlayerUseCard.getSecondNumber()+turnPlayerUseCard.getThirdNumber() %></h2>
<br>
です。<br>
ボタンをクリックして次の画面に進んでください。<br>
<br>
<button onclick="location.href='/niseron/CardChoiceConfServlet'">次の画面へ</button>
</body>
</html>