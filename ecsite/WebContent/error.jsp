<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;URL='GoHomeAction'"/>
<title>error</title>
</head>

<body>
<div id="main">
<div id="content" class="item">
<h1>エラーが発生しました。</h1>
３秒後にホーム画面に戻ります。
移動しない場合は<a href="<s:url action="GoHomeAction"/>">こちら</a>
</div>
</div>
</body>
</html>