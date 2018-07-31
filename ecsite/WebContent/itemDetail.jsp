<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>itemDetail</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">

<style type="text/css">
	#img{
		height:150px;
		weight:200px;
	}
	table{
		table-layout:fixed;
		width:100%;
	}
</style>
</head>
<body>
	<header>
	<s:include value="header.jsp"/>

	</header>
	<div id="main">
		<div id="top">
			<h1>itemDetail</h1>
		</div>
		<div class="item" id="content">
		<s:form action="BuyItemAction">
			<img src="<s:property value="#session.itemImgPath"/>" alt="画像なし" id="img">
			<table>
				<tr>

					<td><label>商品名：　</label><s:property value="#session.itemName"/></td>
				</tr>
				<tr>

					<td><label>値段：　</label><s:property value="#session.itemPrice"/></td>
				</tr>
 				<tr>

					<td><label>個数：　</label><s:select list="#{1:1,2:2,3:3,4:4,5:5 }" name="count" theme="simple"/></td>
				</tr>
				<tr>

					<td><label>商品説明：　</label><s:property value="session.itemExplain"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="購入"/></td>
				</tr>
			</table>
		</s:form>
		</div>
		<s:push value="#{'page':'itemDetail'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>
	<script src="JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>