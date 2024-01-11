<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import ="model.User,model.CardDate,model.GameConfig"%>
<% User user = (User)session.getAttribute("user"); %>
<% User rivalUser = (User)session.getAttribute("rivalUser"); %>
<% CardDate userCardDate = (CardDate)session.getAttribute("userCardDate"); %>
<% CardDate rivalCardDate = (CardDate)session.getAttribute("rivalCardDate"); %>
<% GameConfig gameConfig = (GameConfig)session.getAttribute("gameConfig"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプルゲーム</title>
</head>
<body>
<h3>プレイヤー『<%= user.getName() %>』の数字カード</h3>
<br>
0 : <%= userCardDate.getNo_0() %><br>
1 : <%= userCardDate.getNo_1() %><br>
2 : <%= userCardDate.getNo_2() %><br>
3 : <%= userCardDate.getNo_3() %><br>
4 : <%= userCardDate.getNo_4() %><br>
5 : <%= userCardDate.getNo_5() %><br>
6 : <%= userCardDate.getNo_6() %><br>
7 : <%= userCardDate.getNo_7() %><br>
8 : <%= userCardDate.getNo_8() %><br>
9 : <%= userCardDate.getNo_9() %><br>
<br>
<br>
<h3>対戦相手『<%= rivalUser.getName() %>』の数字カード</h3>
<br>
0 : <%= rivalCardDate.getNo_0() %><br>
1 : <%= rivalCardDate.getNo_1() %><br>
2 : <%= rivalCardDate.getNo_2() %><br>
3 : <%= rivalCardDate.getNo_3() %><br>
4 : <%= rivalCardDate.getNo_4() %><br>
5 : <%= rivalCardDate.getNo_5() %><br>
6 : <%= rivalCardDate.getNo_6() %><br>
7 : <%= rivalCardDate.getNo_7() %><br>
8 : <%= rivalCardDate.getNo_8() %><br>
9 : <%= rivalCardDate.getNo_9() %><br>
<br>
<br>
<h3>ゲーム設定</h3>
<br>
MODE     : <%= gameConfig.getGameMode() %><br>
DOUBLE   : <%= gameConfig.getDouble_m() %><br>
HIGH&amp;LOW : <%= gameConfig.getHighlow_m() %><br>
TARGET   : <%= gameConfig.getTarget_m() %><br>
SLASH    : <%= gameConfig.getSlash_m() %><br>
SHUFFLE  : <%= gameConfig.getShuffle_m() %><br>
CHANGE   : <%= gameConfig.getChange_m() %><br>
<br>
<a href="/niseron/top.jsp">トップへ</a>
</body>
</html>