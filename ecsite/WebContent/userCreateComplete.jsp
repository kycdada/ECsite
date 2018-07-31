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
<title>UserCreateComplete画面</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">

</head>
<body>
	<header>
		<s:include value="header.jsp"/>
	</header>
	<div id="main">
		<div id="top">
			<h1>UserCreateComplete</h1>
		</div>
		<div id="content" class="item">
			<h3>ユーザーの登録が完了しました。</h3>
			<div>
				<a href="<s:url action="GoHomeAction"/>">ホームへ</a>
		<s:if test='session.masterFlg.toString().equals("1")'>
			<span>ユーザー管理画面は</span>
			<a href="<s:url action="UserEditAction"/>">こちら</a>
		</s:if>
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
	<script src="JQuery/basis.js"></script>>
</body>
</html>