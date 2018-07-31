<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MasterMenu</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/submas.css">

<script src="./JQuery/jquery-3.3.1.js"></script>
</head>
<body>
	<div id="main">
		<div id="top">
			<h1>MasterMenu</h1>
		</div>
		<div class="item" id="content">
		<s:if test="deleteFlg>0">
			<p><s:property value="deleteFlg"/>件削除しました。</p>
		</s:if>
		<s:if test="insertFlg>0">
			<p><s:property value="insertFlg"/>件登録しました。</p>
		</s:if>
		<s:if test="nameEditFlg=='1'">
			<p>名前とパスワードを編集しました。</p>
		</s:if>
			<table id="long">
					<tr>
						<th>ID</th>
						<th>HostMasterId</th>
						<th>LoginPassword</th>
						<th>UserCreate権限</th>
						<th>UserEdit権限</th>
						<th>UserDelete権限</th>
						<th>itemCreate権限</th>
						<th>itemEdit権限</th>
						<th>itemDelete権限</th>
						<th>InsertDate</th>
						<th>UpdateDate</th>
					</tr>

			<s:iterator value="#session.submasList" status="rs">
					<tr>

						<td><s:property value="id"/></td>
						<s:hidden name="idList" value="%{id}" form="flg" theme="simple"/>
						<td><s:property value="hostMasterId"/></td>
						<td><s:property value="LoginPassword"/></td>
						<s:if test="userCreate">
							<td class="ON"><p>ON</p>
							<s:hidden name="reUserCreateFlg" value="true" form="flg" theme="simple"/>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reUserCreateFlg" value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<s:if test="userEdit">
							<td class="ON"><P>ON</P>
							<s:hidden name="reUserEditFlg" value="true" form="flg" theme="simple"/>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reUserEditFlg" value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<s:if test="userDelete">
							<td class="ON"><p>ON</p>
							<s:hidden name="reUserDeleteFlg" value="true" form="flg" theme="simple"></s:hidden>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reUserDeleteFlg"  value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<s:if test="itemCreate">
							<td class="ON"><p>ON</p>
							<s:hidden name="reItemCreateFlg" value="true" form="flg" theme="simple"/>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reItemCreateFlg" value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<s:if test="itemEdit">
							<td class="ON"><p>ON</p>
							<s:hidden name="reItemEditFlg" value="true" form="flg" theme="simple"/>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reItemEditFlg" value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<s:if test="itemDelete">
							<td class="ON"><p>ON</p>
							<s:hidden name="reItemDeleteFlg" value="true" form="flg" theme="simple"/>
							</td>
						</s:if>
						<s:else>
							<td class="OFF"><p>OFF</p>
							<s:hidden name="reItemDeleteFlg" value="false" form="flg" theme="simple"/>
							</td>
						</s:else>
						<td><s:property value="insertDate"/></td>
						<td><s:property value="updateDate"/></td>
						<td><s:checkbox value="false" fieldValue="%{id}" name="idList" theme="simple" form="del"/></td>
						<td><input  type="button" value="名前＆パスワード変更" onclick="location.href='<s:url action="SubMasNameAction"><s:param name="id" value="%{id}"/><s:param name="index" value="%{#rs.index}"/></s:url>'"/></td>
					</tr>
			</s:iterator>
			</table>
			<s:form action="SubMasEditAction" id="flg">
			<s:submit value="権限更新"/>
			</s:form>
			<s:form action="SubMasterAction" id="del">
				<s:submit value="選択中のアカウントを削除"/>
			</s:form>
			<input type="button" value="新規サブマスター" onclick="location.href='<s:url action="CreateSubMasterAction"/>'"/>
			<input type="button" value="戻る" onclick="location.href='<s:url action="GoHostAction"/>'"/>

		</div>
	</div>
	<footer>
	</footer>
	<script src="./JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script type="text/javascript" src="./JQuery/flg.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>