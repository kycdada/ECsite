<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<title>Home画面</title>
	<script src="./JQuery/jquery-3.3.1.js"></script>

	<link rel="stylesheet" type="text/css" href="css/basis.css">
	<link rel="stylesheet" type="text/css" href="css/pagination.css">

</head>
<body>
	<header>
		<s:include value="header.jsp"/>
	</header>
	<div id="main">
		<div id="top">
			<h1>北海道物産</h1>
		</div>
		<s:push value="#{'page':'home'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>


	<footer>
	</footer>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>