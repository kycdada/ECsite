<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserCompilation</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">
	#flex{
		display:flex;
		justify-content: center;
	}
	.btn{
		margin-top:10px;
	}
</style>
</head>
<body>

	<div id="main">
		<div id="top">
			<h1>UserCompilation</h1>
		</div>
		<div id="content" class="item">
		<s:if test="hasActionErrors()">
				<p>このページで起きたエラー</p>
			<s:actionerror/>
		</s:if>
		<div id="messages"></div>
		<s:form action="UserCompilationConfirmAction" id="userCompilation">
		<div><span>ID：</span><s:property value="#session.user.id"/></div>
		<div><span>ログインID：　　</span><input type="text" name="loginId" value="<s:property value="#session.user.loginId"/>" ></div>
		<div><span>パスワード：　　</span><input type="text" name="loginPassword" value="<s:property value="#session.user.loginPassword"/>"></div>
		<div><span>ユーザーネーム：</span><input type="text" name="userName" value="<s:property value="#session.user.userName"/>"></div>
		<s:submit value="確定"/>
		</s:form>
		<input type="button"  class="btn" value="戻る" onclick="location.href='<s:url action="UserEditAction"/>'">
		</div>
	</div>
	<script src="./JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
	<footer>
	</footer>
</body>
</html>