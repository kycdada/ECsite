<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">

</style>
</head>
<body>

<div id="main">
	<div id="top">
		<h1>UserList</h1>
	</div>
	<div id="content" class="item">
		<s:if test="deleteUserCount>0">
			<s:property value="deleteUserCount"/>件削除しました。
		</s:if>
		<s:if test="updateFlg>0">
			<s:property value="updateFlg"/>項目修正しました。
		</s:if>
		<s:if test="updateFlg==0">
			修正できませんでした。
		</s:if>
		<table>
				<tr>
				<s:if test="#session.UDF.equals(true) || #session.subMasterFlg.equals(false)">
					<th>□</th>
				</s:if>
					<th>Id</th>
					<th>LoginId</th>
					<th>LoginPassword</th>
					<th>UserName</th>
					<th>Insert_Date</th>
					<th>Update_date</th>
				</tr>

			<s:iterator value="#session.userList" status="rs">

				<tr>
					<s:if test="#session.UDF.equals(true) || #session.subMasterFlg.equals(false)">
					<td><s:checkbox value="false" fieldValue="%{#rs.index}" name="deleteUserList" form="del" theme="simple"/></td>
					</s:if>

					<td><s:property value="id"/></td>
					<td><s:property value="loginId"/></td>
					<td><s:property value="loginPassword"/></td>
					<td><s:property value="userName"/></td>
					<td><s:property value="insertDate"/></td>
					<td><s:property value="updateDate"/></td>

					<s:if test="#session.UEF.equals(true) || #session.subMasterFlg.equals(false)">
					<td><input type="button" value="編集" onclick="location.href='<s:url action="UserCompilationAction"><s:param name="id" value="%{id}"/></s:url>'"/></td>
					</s:if>
				</tr>

			</s:iterator>
			</table>
			<s:if test="#session.UDF.equals(true) || #session.subMasterFlg.equals(false)">
			<s:form action="UserEditAction" id="del">
			<s:submit value="選択中のユーザーを削除"/>
			</s:form>
			</s:if>

			<s:if test="#session.UCF.equals(true) || #session.subMasterFlg.equals(false)">
			<input type="button" value="新規ユーザー作成" onclick="location.href='<s:url action="UserCreateAction"><s:param name="masterFlg"  value="1"></s:param></s:url>'">
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