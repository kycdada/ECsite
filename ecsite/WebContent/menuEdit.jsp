<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menuEdit</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">
	#thumbnail{
		width:200px;
		height:150px;
	}
</style>
</head>
<body>
	<div id="main">
		<div id="top">
			<h1>menuEdit</h1>
		</div>
		<div id="content" class="item">
			<s:form action="EditCompleteAction" enctype="multipart/form-data" method="post">
			<div><span>商品名：</span><input type="text" name="itemName" value=<s:property value="dto.itemName"/>></div>
			<div><span>ふりがな：</span><input type="text" name="itemHira" value=<s:property value="dto.itemHira"/>></div>
			<div><span>フリガナ：</span><input type="text" name="itemKata" value=<s:property value="dto.itemKata"/>></div>
			<div><span>カテゴリ：</span><input type="text" name="itemCategory" value=<s:property value="dto.itemCategory"/>></div>
			<div><span>価格：</span><input type="text" name="itemPrice" value=<s:property value="dto.itemPrice"/>><span>(円)</span></div>
			<div><span>商品説明：</span><textarea name="itemExplain"><s:property value="dto.itemExplain"/></textarea></div>
			<div><input type="file" name="img" accept="image/*" id="upfile"><img id="thumbnail" src="<s:property value='dto.itemImgPath'/>"></div>
			<s:submit value="決定"/>
			</s:form>
		</div>
	</div>
	<script src="./JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
	<script src="JQuery/createMenu.js"></script>
	<footer>
	</footer>
	<script src="./JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>