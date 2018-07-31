<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content=text/javascript>
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<title>UserCreateCofirm画面</title>

<link rel="stylesheet" type="text/css" href="css/basis.css">
</head>
<body>
	<header>
		<s:include value="header.jsp"/>
	</header>
	<div id="main">
		<div id="top">
			<h1>UserCreateConfirm</h1>
		</div>
		<div id="content" class="item">
		<h3>登録する内容は以下でよろしいですか。</h3>
		<s:actionerror/>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr class="box">
						<td><label>ログインID：</label>
					</td>
					<td>
						<s:property value="session.loginUserId" escape="false"/>
					</td>
					<tr class="box">
						<td><label>ログインPASS：</label></td>
						<td><s:property value="session.loginPassword" escape="false"/>
						</td>
					</tr>
					<tr class="box">
						<td><label>ユーザー名：</label></td>
						<td><s:property value="session.userName" escape="false"/>
						</td>
					</tr>
					<s:token></s:token>
					<s:submit value="完了"/>
				</s:form>
			</table>
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