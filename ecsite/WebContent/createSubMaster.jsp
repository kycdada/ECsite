<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/submas.css">
<title>CreateSub</title>
</head>
<body>
	<div id="main">
		<div id="top">
			<h1>CreateSubMaster</h1>
		</div>
	<div id="content" class="item">
	<s:if test="hasActionErrors()">
		<p>このページで起きたエラー</p>
			<s:actionerror/>
		</s:if>
		<s:form action="CreateSubMasterConfirmAction">
		<div><label>　HostMasterId:</label><input type="text" name="hostMasterId" /></div>
		<div><label>LoginPassword:</label><input type="text" name="loginPassword"/></div>
		<div><s:checkboxlist list='#{1:"UserCreate権限",2:"UserEdit権限",3:"UserDelete権限"}' name="userFlg" label="User権限"/></div>
		<div><s:checkboxlist list="#{1:'itemCreate権限',2:'itemEdit権限',3:'itemDelete権限'}" name="itemFlg" label="item権限"/></div>
		<div id="Cbtn"><s:submit value="確認"/></div>
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