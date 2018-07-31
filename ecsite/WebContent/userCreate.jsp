<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/script">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<title>UserCreate画面</title>

<link rel="stylesheet" type="text/css" href="css/basis.css">
</head>
<body>
	<header>
		<s:include value="header.jsp"></s:include>
	</header>
	<div id="main">
		<div id="top">
			<h1>UserCreate</h1>
		</div>
		<div id="content" class="item">
		<div>
			<s:if test="errorMassage !=''">
				<s:property value="errorMassage" escape="false"/>
			</s:if>

			<table>
				<s:form action="UserCreateConfirmAction" id="userCreate">
				<s:if test="hasActionErrors()">
					<p>このページで起きたエラー</p>
				<s:actionerror/>
				</s:if>
				<div id="messages"></div>
					<tr>
						<td><label>ログインID:</label></td>
						<td><input type="text" name="loginUserId" value="<s:property value="%{loginUserId}"/>"></td>
					</tr>
					<tr>
						<td><label>ログインPASS:</label></td>
						<td><input type="text" name="loginPassword" value="<s:property value="%{loginPassword}"/>"></td>
					</tr>
					<tr>
						<td><label>ユーザー名:</label></td>
						<td><input type="text" name="userName" value="<s:property value="%{userName}"/>"></td>
					</tr>
					<s:submit value="登録"></s:submit>
				</s:form>
			</table>
		</div>

		<div>
		<span>Homeに戻る場合は</span>
		<a href="<s:url action="GoHomeAction"/>">こちら</a>
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
	<script src="JQuery/basis.js"></script>
</body>
</html>