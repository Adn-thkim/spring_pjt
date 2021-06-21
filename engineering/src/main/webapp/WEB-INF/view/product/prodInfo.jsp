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
	function cartAdd(prodNo, prodPrice, catNum){
		if(${authInfo == null}){
			alert("로그인이 필요한 서비스입니다.");
			location.href="../main";
			return false;
		}else{
			var qty = document.getElementById("qty").value;
			location.href="cartAdd?prodNo="+prodNo
								+"&cartQty="+qty
								+"&prodPrice="+prodPrice
								+"&catNum="+catNum;
		}
	}
</script>

</head>
<body>

제품상세페이지<br/>
<table align="right" width="800">
	<tr><td rowspan="4">
			<img width="300" src="../product/upload/${dto.prodImage.split(',')[0]}" />
		</td>
		<td>${dto.prodName}</td></tr>
	<tr><td align="right">
		<fmt:formatNumber value="${dto.prodPrice}" pattern="#,###,###,###"/>원
		</td>
	</tr>
	<tr><td>
			수량 : <input type="number" min="0" value="1" id="qty"/>
		</td></tr>
	<tr><td>
			<input type="button" value="장바구니" onclick="javascript:cartAdd('${dto.prodNo}','${dto.prodPrice}','${dto.catNum}')"/>
			<input type="button" value="바로 구매" onclick="javascript:"/>
		</td></tr>
	<tr><td colspan="2">
			제품 상세 설명 : <br/>
			${dto.prodInfo}
			<c:forTokens items="${dto.prodImage}" delims="," var="image">
				<img width="800" src="../product/upload/${image}" /><br />
			</c:forTokens>
		</td></tr>
</table>

</body>
</html>