<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.CardDate,model.GameConfig,model.GameSetting,model.UseCard"%>
<% User user = (User)session.getAttribute("user"); %>
<% User rivalUser = (User)session.getAttribute("rivalUser"); %>
<% GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting"); %>
<%
String firstPlayer = gameSetting.getFirstPlayer();

User turnPlayer = new User();
if(firstPlayer.equals("user")){
	if(gameSetting.getTurnCount()%2 == 1){turnPlayer = user; }
	else if(gameSetting.getTurnCount()%2 == 0){turnPlayer = rivalUser;}
}else if(firstPlayer.equals("rival")){
	if(gameSetting.getTurnCount()%2 == 1){turnPlayer = rivalUser; }
	else if(gameSetting.getTurnCount()%2 == 0){turnPlayer = user;}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= turnPlayer.getName() %>さんのターン</title>

</head>
<body>
<h1><% if(gameSetting.getTurnCount()==1){ %>GAME START!!<% } %></h1>
<h2><%= turnPlayer.getName() %>さんのターンです。</h2>
次からの画面は<%= turnPlayer.getName() %>さんだけが見るようにしてください。<br>
<form action="/niseron/GamePlayServlet" method="get">
<input type="hidden" name="flag" value=1>
<input type="submit" value="数字推測へ">
</form>
</body>
</html>