<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="modal-login">
		<s:if test="hasActionErrors()">
		<p>このページで起きたエラー</p>
			<s:actionerror/>
		</s:if>
			<s:if test="errorMessage!=null">
			<s:property value="errorMessage"/>
			<s:hidden name="errorMessage" id="mes"/>
			</s:if>
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<s:form id="login">
			<div id="messages"></div>
				<s:textfield name="loginUserId" label="id"/>
				<s:password name="loginPassword" label="password"/>
				<input type="hidden" name="mesFlg" id="flg">
				<s:hidden  name="page" value="%{page}"/>
				<s:submit value="ログイン"/>
				</s:form>
				<p>新規ユーザー登録は<a href="<s:url action="UserCreateAction"/>">こちら</a></p>
				<p><a id="modal-close" class="modal-link">閉じる</a></p>

		</div>
		<div id="modal-overlay"></div>
</body>
</html>