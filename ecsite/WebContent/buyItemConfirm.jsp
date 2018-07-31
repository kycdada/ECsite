<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content=text/javascript>
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<script src="./JQuery/jquery-3.3.1.js"></script>
<title>buyItemConfirm画面</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">

	#img{
		height:150px;
		weight:200px;
		}
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<header>
	<s:include value="header.jsp"/>
	</header>
	<div id="main">
		<div id="top">
			<h1>BuyItemConfirm</h1>
		</div>
		<div class="item" id="content">
		<img src="<s:property value="session.itemImgPath"/>" alt="画像なし" id="img">
			<table>
				<s:form action="CartInsertAction">

					<tr>
						<td>商品名</td>
						<td><s:property value="session.itemName"/></td>
					</tr>
					<tr>
						<td>単価</td>
						<td><s:property value="session.itemPrice"/></td>
					</tr>
					<tr>
						<td>購入個数</td>
						<td><s:property value="session.count"/><span>個</span></td>
					</tr>
					<tr>
						<td>値段</td>
						<td><s:property value="session.total_price"/>
					</td>

					<tr>
						<td><br></td>
					</tr>
					<tr>
					<s:token/>
						<td><input type="button" value="戻る" onclick='location.href="<s:url action='HomeAction'/>"'></td>
						<td><input type="submit" value="カートに入れる"></td>
					</tr>
				</s:form>
			</table>
		</div>
		<s:push value="#{'page':'buyItemConfirm'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>
	<footer>
	</footer>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script type="text/javascript" src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>