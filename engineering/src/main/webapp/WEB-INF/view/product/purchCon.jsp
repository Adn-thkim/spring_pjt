<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="1">
	<tr><th>주문일 / 결제번호</th><th colspan="2">상품명 / 주문번호</th><th>주문상태</th></tr>
<c:forEach items="${list}" var="dto">
	<tr><td><fmt:formatDate value="${dto.purchDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/> / ${dto.payNo}</td>
		<td rowspan="2"><img width="100" src="../product/upload/${dto.prodImage.split(',')[0]}" /></td>
		<td rowspan="2" align="center">${dto.prodName} / ${dto.purchNo}</td>
		<td rowspan="2" align="center">
			<c:if test="${dto.payNo == null}">
				<a href="paymentOk?purchNo=${dto.purchNo}&payPrice=${dto.purchTotal}">주문하기</a></c:if>
			<c:if test="${dto.payNo != null}">결제완료<br />
				<c:if test="${dto.reviewContent == null}">
					<a href="goodsReview?purchNo=${dto.purchNo}&prodNo=${dto.prodNo}&prodName=${dto.prodName}">리뷰작성</a></c:if>
				<c:if test="${dto.reviewContent != null}"><a href="goodsReviewUpdate?purchNo=${dto.purchNo}&prodNo=${dto.prodNo}&prodName=${dto.prodName}">리뷰수정</a><br /></c:if>
			</c:if>
		</td></tr>
	<tr><td align="right">결제 금액 : <fmt:formatNumber value="${dto.purchTotal}" pattern="#,###,###,###"/>원</td></tr>
</c:forEach>
</table>
</body>
</html>