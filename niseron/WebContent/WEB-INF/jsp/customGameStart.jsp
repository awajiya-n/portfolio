<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.CardDate,model.GameConfig"%>

<%
User user = (User)session.getAttribute("user");
%>
<%
User rivalUser = (User)session.getAttribute("rivalUser");
%>
<%
CardDate userCardDate = (CardDate)session.getAttribute("userCardDate");
%>
<%
CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate");
%>
<% GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カスタムゲーム</title>
</head>
<body>

</body>
</html>