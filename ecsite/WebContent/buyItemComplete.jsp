<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<title>BuyItemComplete画面</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">

</style>
</head>
<body>
	<header>
	<s:include value="header.jsp"/>

	</header>
	<div id="main">
		<div id="top">
			<h1>BuyItemComplete</h1>
		</div>
		<div id="content" class="item">
			<p>購入が完了致しました。</p>
			<diV>
				<a  href="<s:url action="MyPageAction"/>">
				マイページ</a>から<span>購入履歴の確認が可能です。</span>
				<p>Homeに戻る場合は<a href="<s:url action="GoHomeAction"/>">こちら</a></p>
		</div>
		</div>

		<s:push value="#{'page':'home'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>

	<footer>
	</footer>
	<script src="./JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>