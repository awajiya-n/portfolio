<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Answer , model.RiddleLogic" %> 
<%
Answer answer = (Answer) session.getAttribute("answer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/css/nazotoki.css" %>
</style>
<title>問2</title>
</head>
<body>
     <div class="question2">
       <h3>第2問</h3>
       <form action="/nazotoki/RiddleServlet" method="post">
       <h2><p class="mondaibun">地球上から見て一番大きく見える星は？</p></h2>
       <label><input type="radio" name="q2" value="sui">水星</label><br>
       <label><input type="radio" name="q2" value="kin">金星</label><br>
       <label><input type="radio" name="q2" value=3>地球</label><br>
       <label><input type="radio" name="q2" value="tuki">月</label><br>
       <label><input type="radio" name="q2" value="ka">火星</label><br>
       <label><input type="radio" name="q2" value="moku">木星</label><br>
       <label><input type="radio" name="q2" value="do">土星</label><br>
       <label><input type="radio" name="q2" value="ten">天王星</label><br>
       <label><input type="radio" name="q2" value="kai">海王星</label><br>
       <label><input type="radio" name="q2"value="" checked="checked" style="display:none;" /></label>
       <br><input class="button" type="submit" onsubmit="<% answer.setNext(3); session.setAttribute("answer",answer); %>" value="解答">
       </form>
     </div>
</body>
</html>