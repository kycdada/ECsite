<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/basis.css">
<title>MyPage画面</title>

<style type="text/css">

	#accordion{
		cursor:pointer;
	}

	#accordion:after{
		content:">";
		display:inline-block;
		-moz-transform: rotate(90deg);
   		-webkit-transform: rotate(90deg);
   		-o-transform: rotate(90deg);
    	-ms-transform: rotate(90deg);
		transform:rotate(90deg);
		font-size:15px;
		cursor:pointer;
	}
	#accordion.active:after{
		content:">";
		display:inline-block;
		-moz-transform: rotate(-90deg);
   		-webkit-transform: rotate(-90deg);
   		-o-transform: rotate(-90deg);
    	-ms-transform: rotate(-90deg);
		transform:rotate(-90deg);
		font-size:15px;
		cursor:pointer;
	}
	#btn{
		margin:10px auto;
		text-align:center;
	}

	.date{
		display:none;
		cursor:pointer;
	}
	.date:after{
		content:">";
		display:inline-block;
		-moz-transform: rotate(90deg);
   		-webkit-transform: rotate(90deg);
   		-o-transform: rotate(90deg);
    	-ms-transform: rotate(90deg);
		transform:rotate(90deg);
		font-size:12px;
		cursor:pointer;
	}

	.date.active:after{
		content:">";
		display:inline-block;
		-moz-transform: rotate(-90deg);
   		-webkit-transform: rotate(-90deg);
   		-o-transform: rotate(-90deg);
    	-ms-transform: rotate(-90deg);
		transform:rotate(-90deg);
		font-size:12px;
		cursor:pointer;
	}

	.loop{
		display:none;
		text-align:center;
	}


</style>
</head>
<body>
	<header>
		<s:include value="header.jsp"/>
	</header>

	<div id="main">
		<div id="top">
			<h1>myPage</h1>
		</div>
		<div class="item" id="content">
		<div>
			<s:if test="myPageList==null || myPageList.isEmpty()">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
			<a>購入履歴</a>
				<h3 id="accordion">ご購入情報は以下になります。</h3>

					<s:iterator value="map">
					<div class="date">
						<label>注文番号:　</label><s:property value="%{value.get(0).orderNumber}"/>
					</div>
					<div class="loop">
					<s:iterator value="value">

							<div><span>商品名: </span><s:property value="itemName"/><span><s:checkbox value="false" fieldValue="%{id}" name="idList" theme="simple" form="del"></s:checkbox></span></div>
							<div><span>値段: </span><s:property value="totalPrice"/><span>円</span></div>
							<div><span>購入個数: </span><s:property value="totalCount"/><span>個</span></div>
							<div><span>支払い情報: </span><s:property value="payment"/></div>

					</s:iterator>
					</div>
					</s:iterator>
					<div id="btn">
					<s:form action="MyPageAction" id="del">
						<s:submit value="選択中の履歴を削除" theme="simple"/>
					</s:form>
					<s:form action="MyPageAction">
					<input type="hidden" name=deleteFlg value="1"/>
					<s:submit value="全て削除" theme="simple"/>
					</s:form>
					</div>
			</s:elseif>
			</div>
			<s:if test="message != null">
			<h3><s:property value="message"/></h3>
			<p>マイページに戻る場合は<a href="<s:url action="MyPageAction"/>">こちら</a>
			</s:if>
			<div id="text-right">
				<p>カートは<a href="<s:url action="CartDisplayAction"/>">こちら</a>
				<p>Homeへ戻る場合は<a href="<s:url action="GoHomeAction"/>">こちら</a></p>
				<p>ログアウトする場合は<a href="<s:url action="LogoutAction"/>">こちら</a></p>
			</div>
			</div>

		<s:push value="#{'page':'home'}">
			<s:include value="modal.jsp"/>
		</s:push>
		</div>




	<footer>
	</footer>

	<script type="text/javascript" src="./JQuery/jquery-3.3.1.js"></script>
	<script src="./JQuery/myPage.js"></script>
	<script src="JQuery/snowfall.jquery.min.js"></script>
	<script type="text/javascript" src="JQuery/jquery.validate.js"></script>
	<script src="JQuery/loginModal.js"></script>
	<script src="JQuery/basis.js"></script>
</body>
</html>