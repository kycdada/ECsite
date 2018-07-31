<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/basis.css">
<script src="./JQuery/jquery-3.3.1.js"></script>
<title>CartDisplay</title>

</head>
<body>
	<header>
	<s:include value="header.jsp"/>

	</header>
	<div id="main">
		<div id="top">
			<h1>Cart</h1>
		</div>
		<div class="item" id="content">

			<s:if test="message == null && cartList != null && !(cartList.isEmpty())">
				<h3>カート情報は以下になります。</h3>
				<s:form action="CartDisplayAction">
					<table>
					<tr>
						<th><input type="checkbox" class="checkAll" id="delete"/></th>
						<th>画像</th>
						<th>商品名</th>
						<th>商品単価</th>
						<th>購入個数</th>
						<th>金額</th>
					</tr>

						<s:iterator value="cartList">
							<tr>
								<td class="check"><span class="cartCheck"><s:checkbox value="false" name="deleteList" fieldValue="%{itemTransactionId}" class="delete" theme="simple"/></span></td>
								<td><img src="<s:property value="itemImgPath"/>" alt="画像なし" class="img"></td>


								<td><s:property value="itemName"/></td>




								<td><s:property value="itemPrice"/></td>



								<td><s:property value="count"/></td>



								<td><s:property value="totalPrice"/></td>
							</tr>
						</s:iterator>
					</table>
					<input type="submit" value="選択した商品をリストから削除"/>
				</s:form>
				<s:form action="CartDisplayAction">
					<input type="hidden" name="deleteFlg" value="1"/>
					<input type="submit" value="全て削除"/>
				</s:form>
				<s:form action="BuyItemCompleteAction">
					<s:token/>
					合計金額
					<s:property value="session.sumPrice"/>
					<s:radio label="支払い方法" name="pay" list="#{0:'現金払い',1:'クレジットカード'}" value="0"/>
					<s:submit value="精算"/>
				</s:form>
			</s:if>
			<s:elseif test="message == null && #session.tempCartList != null && !(#session.tempCartList.isEmpty())">
				<h3>カート情報は以下になります。</h3>
				<s:form action="CartDisplayAction">
					<table>
						<tr>
							<th><input type="checkbox" id="tempDelete" class="tempCheckAll"/></th>
							<th>画像</th>
							<th>商品名</th>
							<th>商品単価</th>
							<th>購入個数</th>
							<th>金額</th>

						</tr>
						<s:iterator value="#session.tempCartList">

							<tr>
								<td class="tempCheck"><span class="tempCartCheck"><s:checkbox value="false" name="deleteList" fieldValue="%{id}" class="tempDelete" theme="simple"/></span></td>
								<td><img src="<s:property value="itemImgPath"/>" alt="画像なし" class="img"></td>

								<td><s:property value="itemName"/></td>


								<td><s:property value="itemPrice"/></td>



								<td><s:property value="count"/></td>



								<td><s:property value="totalPrice"/></td>
							</tr>

						</s:iterator>
					</table>
					<input type="submit" value="選択した商品をリストから削除"/>
				</s:form>
				<s:form action="CartDisplayAction">
					<input type="hidden" name="deleteFlg" value="1"/>
					<input type="submit" value="全て削除"/>
				</s:form>
					合計金額
					<s:property value="session.sumPrice"/>
					<a id="Cmodal-open"><input type="button" value="精算" ></a>

			</s:elseif>
		<s:elseif test="message != null">
			<h3><s:property value="message"/></h3>
			<p>カートに戻る場合は<a href="<s:url action="CartDisplayAction"/>">こちら</a>
			<p>マイページは<a href="<s:url action="MyPageAction"/>">こちら</a>
		</s:elseif>
			<s:else>
					<h3>カート情報はありません。</h3>
			</s:else>
				<p>Homeへ戻る場合は<a href="<s:url action="GoHomeAction"/>">こちら</a></p>
				<p>ログアウトする場合は<a href="<s:url action="LogoutAction"/>">こちら</a></p>
		</div>
		<s:push value="#{'page':'cart'}">
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