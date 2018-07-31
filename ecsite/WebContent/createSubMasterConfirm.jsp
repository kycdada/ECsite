<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CreateSubConfirm</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/submas.css">
</head>
<body>

	<div id="main">
		<div id="top">
			<h1>CreateSubConfirm</h1>
		</div>
		<div id="content" class="item confirm">
			<div><span>HostMasterId:</span><s:property value="#session.newSubDTO.hostMasterId"/></div>
			<div><span>LoginPassword:</span><s:property value="#session.newSubDTO.loginPassword"/></div>
			<s:if test="session.newSubDTO.userCreate==true">
			<div><span>UserCreate権限:</span><s:property value="#session.newSubDTO.userCreate"/></div>
			</s:if>
			<s:if test="session.newSubDTO.userEdit==true">
			<div><span>UserEdit権限:</span><s:property value="#session.newSubDTO.userEdit"/></div>
			</s:if>
			<s:if test="session.newSubDTO.userDelete==true">
			<div><span>UserDelete権限:</span><s:property value="#session.newSubDTO.userDelete"/></div>
			</s:if>
			<s:if test="session.newSubDTO.itemCreate==true">
			<div><span>ItemCreate権限:</span><s:property value="#session.newSubDTO.itemCreate"/></div>
			</s:if>
			<s:if test="session.newSubDTO.itemEdit==true">
			<div><span>itemEdit権限:</span><s:property value="#session.newSubDTO.itemEdit"/></div>
			</s:if>
			<s:if test="session.newSubDTO.itemDelete==true">
			<div><span>itemDelete権限:</span><s:property value="#session.newSubDTO.itemDelete"/></div>
			</s:if>
			<s:form action="CreateSubMasterCompleteAction">
			<s:token/>
			<input type="submit"  value="決定"/>'">
			<input type="button"  value="戻る" onclick="location.href='<s:url action="SubMasterAction"/>'">
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