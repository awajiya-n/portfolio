<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.entity.Account"%>
<%
//セッションスコープから入力情報を取得
Account ac =(Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<%
%>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@ include file="/css/Style.css" %>
#button{

}
</style>
<title>管理者登録確認画面</title>
</head>
<body>
<h2>アプリの管理者情報</h2>
<%if(ac != null) {%>
	<p>以下の内容でよろしければ　OK　を押してください</p>
	<p>あなたの家族名やグループ名:<%= ac.getGroupName() %></p>
	<p>あなたのお名前:<%= ac.getUserName() %></p>
	<p>あなたのパスワード:<%= ac.getUserPass() %></p>
<a class="button" href="/MinnadeOsoziChan/SignUpRegistServlet">OK</a>
<a class="button" href="/MinnadeOsoziChan/SignUpServlet">キャンセル</a>
<%}else{%>
	<p>記入内容を正しく読み取れませんでした。</p>
	<p>注意項目にご留意のうえ、もう一度入力をお願いします</p>
	<a class="button" href="/MinnadeOsoziChan/SignUpServlet">入力をやり直す</a>
<%}%>
</body>
</html>