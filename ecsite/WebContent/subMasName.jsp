<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/submas.css">
<title>SubMasName</title>
</head>
<body>
	<div id="main">
	<div id="top">
		<h1>SubMasNameEdit</h1>
	</div>
		<div id="content" class="item">
		<s:if test="hasActionErrors()">
		<p>このページで起きたエラー</p>
			<s:actionerror/>
		</s:if>
			<s:form action="SubMasNameConfirmAction">
			<div><label>　HostMasterId:</label><input type="text" name="hostMasterId" value='<s:property value="#session.submasList.get(index).hostMasterId"/>'/></div>
			<div><label>LoginPassword:</label><input type="text" name="loginPassword" value="<s:property value='#session.submasList.get(index).loginPassword'/>"/></div>
			<s:hidden name="index"></s:hidden>
			<s:submit value="確認"/>
			</s:form>
			<input type="button"  value="戻る" onclick="location.href='<s:url action="SubMasterAction"/>'">
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