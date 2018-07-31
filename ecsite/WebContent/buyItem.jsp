<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">

<title>BuyItem画面</title>

<link rel="stylesheet" type="text/css" href="css/basis.css">
<link rel="stylesheet" type="text/css" href="css/pagination.css">

</head>
<body>
	<header>
	<s:include value="header.jsp"/>


	</header>
	<div id="main">
		<div id="top">
			<h1>BuyItem</h1>
		</div>
		<div id="content">
		<div class="itemList">
		<s:iterator value="#session.currentItemInfoPage">
		<div class="item">
				<div><img src="<s:property value="itemImgPath"/>" alt="画像なし" class="img"></div>
					<div><span>商品名：</span><s:property  value="itemName"/></div>

					<div><span>値段：</span><s:property  value="itemPrice"/><span>円</span></div>
					<div><span>商品説明：</span><s:property value="itemExplain"/></div>
					<a href="<s:url action="ItemDetailAction"><s:param name="id" value="%{id}"/><s:param name="itemName" value="%{itemName}"/><s:param name="itemPrice" value="%{itemPrice}"/><s:param name="itemExplain" value="%{itemExplain}"/><s:param name="itemImgPath" value="itemImgPath"/></s:url>"></a>
		</div>


			</s:iterator>
		</div>


		<div id="page">
		<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
			<s:if test="#session.currentPageNo == #pageNo.count">
				<s:property value="%{#pageNo.count}"/>
			</s:if>
			<s:else>
				<a href="<s:url action='ItemListAction'><s:param name='pageNo' value='%{#pageNo.count}'/><s:param name="serch" value="%{serch}"/></s:url> "><s:property value="%{#pageNo.count}"/></a>
			</s:else>
		</s:iterator>
		</div>

			<div id="link">
				<p>カートは<a href="<s:url action="CartDisplayAction"/>">こちら</a></p>
				<p>ホームに戻る場合は<a href="<s:url action="GoHomeAction"/>">こちら</a></p>
			</div>
		</div>
		<s:push value="#{'page':'buyItem'}">
			<s:include value="modal.jsp"/>
		</s:push>
	</div>
	<footer>
	</footer>

	<script src="JQuery/jquery-3.3.1.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>