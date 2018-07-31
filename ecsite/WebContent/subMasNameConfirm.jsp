<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SubMasNameConfirm</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/submas.css">
</head>
<body>
	<div id="main">
		<div id="top">
			<h1>SubMasNameConfirm</h1>
		</div>

		<div id="content" class="item confirm">
			<div><label>HostMasterId:</label><s:property value="#session.newSubMasName"/></div>
			<div><label>LoginPassword:</label><s:property value="#session.newSubMasPass"/></div>
			<input type="button" value="確定" onclick="location.href='<s:url action="SubMasterAction"><s:param name="nameEditFlg" value="1"/></s:url>'">
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