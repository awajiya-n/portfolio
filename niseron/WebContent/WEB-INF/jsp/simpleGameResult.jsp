<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.CardDate,model.GameSetting,model.GuessResult,model.UseCard"%>
<%
User user = (User)session.getAttribute("user");
User rivalUser = (User)session.getAttribute("rivalUser");
GameSetting gameSetting = (GameSetting)session.getAttribute("gameSetting");
GuessResult guessResult = (GuessResult)session.getAttribute("guessResult");
UseCard userUseCard = (UseCard)session.getAttribute("userUseCard");
UseCard rivalUseCard = (UseCard)session.getAttribute("rivalUseCard");
%>
<%
User turnPlayer = new User();
if(gameSetting.getFirstPlayer().equals("user")){
	if(gameSetting.getTurnCount()%2 == 0){
		turnPlayer = user;
		}
	else if(gameSetting.getTurnCount()%2 == 1){
		turnPlayer = rivalUser ;
		}
}else if(gameSetting.getFirstPlayer().equals("rival")){
	if(gameSetting.getTurnCount()%2 == 0){
		turnPlayer = rivalUser;
		}
	else if(gameSetting.getTurnCount()%2 == 1){
		turnPlayer = user ;
		}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予想結果</title>
</head>
<body>
<h2><%= turnPlayer.getName() %>さんの選択結果</h2>
<h1><%= guessResult.getEat() %>&nbsp;EAT&nbsp;&nbsp;<%= guessResult.getBite() %>&nbsp;BITE</h1>
<br>
<form action="/niseron/GamePlayServlet" method="get">
<input type="hidden" name="flag" value=2>
<input type="submit" value="相手のターンへ">
 </form>
</body>
</html>