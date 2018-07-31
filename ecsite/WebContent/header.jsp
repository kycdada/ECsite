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
		<div id="headerMenu">
		<div><h2><a href="<s:url action="ItemListAction"/>">商品一覧</a></h2></div>
		<div><h2><a href="<s:url action="CartDisplayAction"/>">カート</a></h2></div>
		<s:if test="(#session.login_user_id)==null">
			<div id="modal-open">
			<h2>ログイン</h2>
			</div>
			<s:if test="#session.masterId == null || #session.masterId.isEmpty()">
			<div id="host-link">
		<h2>管理者</h2>
		</div>
		</s:if>
		<s:else>
			<div><h2><a href="<s:url action="GoHostAction"/>">管理者</a></h2></div>
		</s:else>
		</s:if>
		<s:else>
			<div>
				<h2><a href="<s:url action="LogoutAction"/>">ログアウト</a></h2>
			</div>
			<div>
				<h2><a href="<s:url action="MyPageAction"/>">マイページ</a></h2>
			</div>
		</s:else>
		<div><s:form id="serch" action="ItemListAction"><p>商品検索</p><input type="text" name="serch" class="serch"><s:submit value="検索" theme="simple"/></s:form></div>

	</div>
</body>
</html>