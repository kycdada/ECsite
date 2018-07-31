<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userCompilationConfirm</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">
	#flex{
		display:flex;
		justify-content:space-between;
		align-items: center;
		font-size:20px;
	}
	h2{
		transform:rotate(-90deg);
		font-size:100px;
	}
	#leftContent{
		text-align:center;
	}
	#rightContent{
		text-align:center;
	}

</style>
</head>
<body>
	<div id="main">
		<div id="top">
			<h1>UserCompilationConfirm</h1>
		</div>
		<div id="content" class="item">
		<div id="flex">
			<div id="leftContent">
			<div><span>ID：</span><s:property value="#session.user.id"/></div>
			<div><span>ログインID:</span><s:property value="#session.user.loginId"/></div>
			<div><span>パスワード:</span><s:property value="#session.user.loginPassword"/></div>
			<div><span>ユーザーネーム:</span><s:property value="#session.user.userName"/></div>
			</div>
			<div id="middle">
			<h2>↓</h2>
			</div>
			<div id="rightContent">
				<div><span>ID：</span><s:property value="#session.user.id"/></div>
				<div><span>ログインID:</span><s:property value="#session.newUser.loginId"/></div>
				<div><span>パスワード:</span><s:property value="#session.newUser.loginPassword"/></div>
				<div><span>ユーザーネーム:</span><s:property value="#session.newUser.userName"/></div>
			</div>
		</div>
			<div id="">
				<input type="button" value="OK" onclick="location.href='<s:url action="UserCompilationCompleteAction"/>'">
				<input type="button" value="戻る" onclick="location.href='<s:url action="UserCompilationAction"><s:param name="id" value="%{#session.user.id}"/></s:url>'">
			</div>

		</div>
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