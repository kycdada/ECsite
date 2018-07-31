<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/pagination.css">
</head>
<style type="text/css">
	table{
		table-layout:fixed;
		width:100%;
	}
</style>
<body>
	<div id="main">
		<div id="top">
			<h1>Menu</h1>
		</div>
		<div id=content class="item">


			<s:if test="updateFlg>0">
				<s:property value="updateFlg"/>項目編集しました。
			</s:if>
			<s:if test="updateFlg==0">
			編集できませんでした。
			</s:if>
			<s:if test="createFlg==1">
				商品を追加しました。
			</s:if>
			<s:if test="deleteCount>0">
				<s:property value="deleteCount"/><label>件削除しました。</label>
			</s:if>
			<table class=".item">
			<tr>
					<s:if test="#session.IDF.equals(true) || #session.subMasterFlg.equals(false)">
						<th>□</th>
					</s:if>
						<th>画像</th>
						<th>商品名</th>
						<th>ふりがな</th>
						<th>フリガナ</th>
						<th>カテゴリ</th>
						<th>商品単価</th>
						<th>商品説明</th>
					</tr>
				<s:iterator value="#session.itemMenuList">



					<tr>
						<s:if test="#session.IDF.equals(true) || #session.subMasterFlg.equals(false)">
							<td><s:checkbox value="false" fieldValue="%{id}" name="deleteIdList" theme="simple" form="delete"/></td>
						</s:if>
						<td><img src="<s:property value="itemImgPath"/>" alt="画像なし" class="img"></td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemHira"/></td>
						<td><s:property value="itemKata"/></td>
						<td><s:property value="itemCategory"/></td>
						<td><s:property value="itemPrice"/></td>
						<td class="explain"><s:property value="itemExplain"/></td>



					<s:if test="#session.IEF.equals(true) || #session.subMasterFlg.equals(false)">
					<td><input type="button"  value="編集" onclick="location.href='<s:url action="MenuEditAction"><s:param name="id" value="%{id}"/></s:url>'"></td>
					</s:if>
				</s:iterator>
				</table>
				<s:if test="#session.IDF.equals(true) || #session.subMasterFlg.equals(false)">
				<s:form action="MenuAction" id="delete" >
					<s:submit value="選択中の商品を削除" theme="simple"/>
				</s:form>
				</s:if>

					<s:if test="#session.ICF.equals(true) || #session.subMasterFlg.equals(false)">
					<td>
						<input type="button" value="商品追加" onclick="location.href='<s:url action="CreateMenuAction"/>'">
					</s:if>
							<input type="button" value="HOME" onclick="location.href='<s:url action="GoHomeAction"/>'">
							<input type="button" value="adminMenu" onclick="location.href='<s:url action="GoHostAction"/>'">
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