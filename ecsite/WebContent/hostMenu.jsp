<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hostMenu</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">

	.btn{
		color:gray;
	}
</style>

</head>
<body>

<div id="main">
<div id="top">
	<h1>管理者メニュー</h1>
</div>

<div id="content" class="item">
<s:if test="#session.subMasterFlg.equals(false)">
<s:form action="MenuAction">
<s:submit value="商品追加・編集・削除"/>
</s:form>
<s:form action="UserEditAction">
	<s:submit value="ユーザ管理"/>
</s:form>
<s:form action="SubMasterAction">
<s:submit value="サブマスター管理"/>
</s:form>
</s:if>

<s:else>
<s:if test="#session.ICF.equals(true) || #session.IEF.equals(true) || #session.IDF.equals(true)">
<s:form action="MenuAction">
<s:submit value="商品追加・編集・削除"/>
</s:form>
</s:if>
<s:else>
	<input type="button" class="btn" value="商品追加・編集・削除"/>
</s:else>


<s:if test="#session.UCF.equals(true) || #session.UEF.equals(true) || #session.UDF.equals(true)">
<s:form action="UserEditAction">
	<s:submit value="ユーザ管理"/>
</s:form>
</s:if>
<s:else>
	<input type="button" class="btn" value="ユーザー管理"/>
</s:else>

	<input type="button" class="btn" value="サブマスター管理"/>
</s:else>

<s:form action="LogoutAction">
<s:submit value="ログアウト"/>
</s:form>
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