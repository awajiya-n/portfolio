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
<title><%= turnPlayer.getName() %>さんのカード選択</title>
</head>
<body>
<h2><%= turnPlayer.getName() %>さん</h2>
<h3><%= gameSetting.getCardChoiceCount() %>つめの数字を選んでください</h3>
<form action="/niseron/GameSettingServlet" method="post">
<% if(turnPlayerCardDate.getNo_0()>0 && turnPlayerUseCard.getFirstNumber()!=0 && turnPlayerUseCard.getSecondNumber()!=0){ %><input type="radio" name="number" value="0"><% } %>
<% if(turnPlayerCardDate.getNo_0()==0 || turnPlayerUseCard.getFirstNumber()==0 || turnPlayerUseCard.getSecondNumber()==0){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
0 ：残り<%= turnPlayerCardDate.getNo_0() %>枚
<br>
<% if(turnPlayerCardDate.getNo_1()>0 && turnPlayerUseCard.getFirstNumber()!=1 && turnPlayerUseCard.getSecondNumber()!=1){ %><input type="radio" name="number" value="1"><% } %>
<% if(turnPlayerCardDate.getNo_1()==0 || turnPlayerUseCard.getFirstNumber()==1 || turnPlayerUseCard.getSecondNumber()==1){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
1 ：残り<%= turnPlayerCardDate.getNo_1() %>枚
<br>
<% if(turnPlayerCardDate.getNo_2()>0 && turnPlayerUseCard.getFirstNumber()!=2 && turnPlayerUseCard.getSecondNumber()!=2){ %><input type="radio" name="number" value="2"><% } %>
<% if(turnPlayerCardDate.getNo_2()==0 || turnPlayerUseCard.getFirstNumber()==2 || turnPlayerUseCard.getSecondNumber()==2){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
2 ：残り<%= turnPlayerCardDate.getNo_2() %>枚
<br>
<% if(turnPlayerCardDate.getNo_3()>0 && turnPlayerUseCard.getFirstNumber()!=3 && turnPlayerUseCard.getSecondNumber()!=3){ %><input type="radio" name="number" value="3"><% } %>
<% if(turnPlayerCardDate.getNo_3()==0 || turnPlayerUseCard.getFirstNumber()==3 || turnPlayerUseCard.getSecondNumber()==3){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
3 ：残り<%= turnPlayerCardDate.getNo_3() %>枚
<br>
<% if(turnPlayerCardDate.getNo_4()>0 && turnPlayerUseCard.getFirstNumber()!=4 && turnPlayerUseCard.getSecondNumber()!=4){ %><input type="radio" name="number" value="4"><% } %>
<% if(turnPlayerCardDate.getNo_4()==0 || turnPlayerUseCard.getFirstNumber()==4 || turnPlayerUseCard.getSecondNumber()==4){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
4 ：残り<%= turnPlayerCardDate.getNo_4() %>枚
<br>
<% if(turnPlayerCardDate.getNo_5()>0 && turnPlayerUseCard.getFirstNumber()!=5 && turnPlayerUseCard.getSecondNumber()!=5){ %><input type="radio" name="number" value="5"><% } %>
<% if(turnPlayerCardDate.getNo_5()==0 || turnPlayerUseCard.getFirstNumber()==5 || turnPlayerUseCard.getSecondNumber()==5){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
5 ：残り<%= turnPlayerCardDate.getNo_5() %>枚
<br>
<% if(turnPlayerCardDate.getNo_6()>0 && turnPlayerUseCard.getFirstNumber()!=6 && turnPlayerUseCard.getSecondNumber()!=6){ %><input type="radio" name="number" value="6"><% } %>
<% if(turnPlayerCardDate.getNo_6()==0 || turnPlayerUseCard.getFirstNumber()==6 || turnPlayerUseCard.getSecondNumber()==6){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
6 ：残り<%= turnPlayerCardDate.getNo_6() %>枚
<br>
<% if(turnPlayerCardDate.getNo_7()>0 && turnPlayerUseCard.getFirstNumber()!=7 && turnPlayerUseCard.getSecondNumber()!=7){ %><input type="radio" name="number" value="7"><% } %>
<% if(turnPlayerCardDate.getNo_7()==0 || turnPlayerUseCard.getFirstNumber()==7 || turnPlayerUseCard.getSecondNumber()==7){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
7 ：残り<%= turnPlayerCardDate.getNo_7() %>枚
<br>
<% if(turnPlayerCardDate.getNo_8()>0 && turnPlayerUseCard.getFirstNumber()!=8 && turnPlayerUseCard.getSecondNumber()!=8){ %><input type="radio" name="number" value="8"><% } %>
<% if(turnPlayerCardDate.getNo_8()==0 || turnPlayerUseCard.getFirstNumber()==8 || turnPlayerUseCard.getSecondNumber()==8){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
8 ：残り<%= turnPlayerCardDate.getNo_8() %>枚
<br>
<% if(turnPlayerCardDate.getNo_9()>0 && turnPlayerUseCard.getFirstNumber()!=9 && turnPlayerUseCard.getSecondNumber()!=9){ %><input type="radio" name="number" value="9"><% } %>
<% if(turnPlayerCardDate.getNo_9()==0 || turnPlayerUseCard.getFirstNumber()==9 || turnPlayerUseCard.getSecondNumber()==9){ %>&nbsp;&nbsp;&nbsp;&nbsp;<% } %>
9 ：残り<%= turnPlayerCardDate.getNo_9() %>枚
<br>
<input type="hidden" name="settingFlag" value="2">
<input type="submit" value="決定">
</form>
</body>
</html>