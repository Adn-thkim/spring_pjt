<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function prodChk(){
		var chk = document.getElementsByName("prodCk");
		var hddchk = document.getElementsByName("cartPrice");
		var cnt = 0;
		var totalPrice = 0;
		for(var i = 0; i < chk.length ; i++){
			if(chk[i].checked == true){
				cnt++;
				totalPrice += Number(hddchk[i].value);
			}
		}
		document.getElementById("prodCnt").innerHTML= cnt ;
		document.getElementById("totalPrice").innerHTML = totalPrice;
	} 
	function checkQty(cartQty,prodNo,prodPrice){
		if(cartQty > 1){
			location.href="goodsCartQtyDown?prodNo="+prodNo+"&prodPrice="+prodPrice;
		}else{
			alert("최소구매 수량은 1입니다.");
		}
	}
</script>

</head>
<body>

<form action="prodBuy" method="get" >
<table width = "800" border="1">
	<c:set var="total" value="0"/>
    <tr><td>이미지</td><td>상품명</td><td>수량</td><td>단가</td><td>적용금액</td></tr>
<c:forEach items="${list}" var="productCartDTO" >
	<tr><td>
			<input type="checkbox" value="${productCartDTO.cartDTO.prodNo }" 
				name="prodCk"  onchange ="prodChk();" checked />
			<input type="hidden" value="${productCartDTO.cartDTO.cartPrice }" 
				name="cartPrice" />
			<img src="../product/upload/${productCartDTO.productDTO.prodImage.split(',')[0] }" />
		</td>
		<td>${productCartDTO.productDTO.prodName }</td>
		<td align ="center">
			<a href="javascript:checkQty('${productCartDTO.cartDTO.cartQty}',
										'${productCartDTO.cartDTO.prodNo}',
										'${productCartDTO.productDTO.prodPrice}');">-</a>&nbsp;&nbsp;&nbsp;${productCartDTO.cartDTO.cartQty }&nbsp;&nbsp;&nbsp;<a href="cartAdd?prodNo=${productCartDTO.cartDTO.prodNo }&cartQty=1&prodPrice=${productCartDTO.productDTO.prodPrice }&catNum=0">+</a></td>
		<td><fmt:formatNumber value="${productCartDTO.productDTO.prodPrice}" pattern="#,###,###,###"/>원</td>
		<td><fmt:formatNumber value="${productCartDTO.cartDTO.cartPrice}" pattern="#,###,###,###"/>원</td>
	</tr>
	<c:set var="total" value="${total + productCartDTO.cartDTO.cartPrice }"/>
</c:forEach>
	<tr><td colspan="5" align = "right">
			상품수 : <span id="prodCnt">${list.size() }</span><br />
			전체 금액 : <span id="totalPrice"><fmt:formatNumber value="${total}" pattern="#,###,###,###"/>원</span><br />
		</td></tr>
	<tr><td colspan="5" align = "center">
			<input type="submit" value="구매하기"	/>
		</td></tr>
</table>
</form>

</body>
</html>