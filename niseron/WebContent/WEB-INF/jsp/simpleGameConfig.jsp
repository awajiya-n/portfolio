<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.CardDate,model.GameConfig,model.UseCard"%>
<%
User user = (User)session.getAttribute("user");
User rivalUser = (User)session.getAttribute("rivalUser");
CardDate userCardDate = (CardDate)session.getAttribute("userCardDate");
CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");
GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");
UseCard userUseCard = new UseCard();
UseCard rivalUseCard = new UseCard();
session.setAttribute("userUseCard", userUseCard);
session.setAttribute("rivalUseCard",rivalUseCard);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプルゲーム</title>
</head>
<body>
<h3>先攻後攻を決めてください</h3>
<form action="/niseron/GameSettingServlet" method="post">
<input type="radio" name="fristPlayer" value="user"><%= user.getName() %><br>
<input type="radio" name="fristPlayer" value="rival"><%= rivalUser.getName() %><br>
<input type="radio" name="fristPlayer" value="random" checked>ランダム<br>
<input type="hidden" name="settingFlag" value="1">
<input type="submit" value="決定">
</form>
<br>

<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>