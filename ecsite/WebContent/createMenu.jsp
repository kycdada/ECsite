<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>createMenu</title>
<link rel="stylesheet" type="text/css" href="css/basis.css">
<style type="text/css">
	div{
		display:block;
	}
	#overlay{
		display:none;
		z-index:1;
		height:120%;
		width:100%;
		position:fixed;
		top:0;
		left:0;
		background:rgba(0,0,0,0.75);
	}
	#modal{
	display:none;
	z-index:2;
	position:fixed;
	background:white;
	padding:20px;
	text-align:center;
	}

	#smallThumbnail{
		height:100px;
		width:150px;
	}
	#modalBTN{
		padding:20px
	}
	#close{
		float:left;
	}
	#decision{
		float:right;
	}
	.img{
		height:150px;
		width:200px;
	}


</style>
</head>
<body>

<div id="main">
	<div id="top">
		<h1>createMenu</h1>
	</div>
	<div id="content" class="item">
	<s:if test="hasActionErrors()">
		<p>このページで起きたエラー</p>
			<s:actionerror/>
		</s:if>

	<table>

			<tr><td>商品名：</td><td><input type="text" name="itemName" form="menu" id="name" /></td></tr>
			<tr><td>ふりがな：</td><td><input type="text" name=itemHira form="menu" id="hira"></td></tr>
			<tr><td>フリガナ：</td><td><input type="text" name=itemKata form="menu" id="kata"></td></tr>
			<tr><td>カテゴリ：</td><td><input type="text" name="itemCategory" form="menu" id="cate"></td></tr>
			<tr><td>価格(円):</td><td><input type="text" name="itemPrice" form="menu" id="price"/></td></tr>
			<s:textarea name="itemExplain" label="商品説明" form="menu" id="explain"/>
			<tr><td>画像</td><td><input type="file" name="img" accept="image/*" id="upfile" form="menu"/></td></tr>
			<tr><td></td><td><img id="thumbnail" class="img"></td></tr>
			<tr><td></td><td><input type="button" id="btn" value="確認"></td>
	</table>


	</div>
	<div id="overlay">
	</div>
	<div id="modal">
	<div id="messages"></div>
		<p>以下の内容で登録します</p>
		<div id="nameModal"></div>
		<div id="hiraModal"></div>
		<div id="kataModal"></div>
		<div id="cateModal"></div>
		<div id="priceModal"></div>
		<div id="explainModal"></div>
		<img id="smallThumbnail">
		<s:form action="CreateMenuCompleteAction" enctype="multipart/form-data" method="post" id="menu">
			<s:token/>
			<div id="modalBTN">
				<input type="button" id="close" value="閉じる"/>
				<s:submit value="確定" theme="simple" id="decision"/>
			</div>
		</s:form>
	</div>
</div>
<footer>
</footer>
<script src="./JQuery/jquery-3.3.1.js"></script>
<script src="JQuery/snowfall.jquery.min.js"></script>
<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
<script type="text/javascript" src="JQuery/loginModal.js"></script>
<script src="JQuery/basis.js"></script>
<script src="JQuery/createMenu.js"></script>
</body>
</html>