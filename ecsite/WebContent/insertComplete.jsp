<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/basis.css">
<title>Cart Insert</title>
</head>
<body>
	<header>
		<s:include value="header.jsp"/>
	</header>
	<div id="main">
		<div id="top">
			<h1>Insert Complete</h1>
		</div>
		<div class="item" id="content">
			<p>カートに入れました。</p>
			<div>
				<a href="<s:url action="CartDisplayAction"/>">カート</a><span>から中身の確認が可能です。</span>
				<p>商品ページに戻る場合は<a href ="<s:url action="HomeAction"/>">こちら</a></p>

				<p>Homeに戻る場合は<a href="<s:url action="GoHomeAction"/>">こちら</a></p>
			</div>
		</div>
		<s:push value="#{'page':'insertCart'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>
	<script src="JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>