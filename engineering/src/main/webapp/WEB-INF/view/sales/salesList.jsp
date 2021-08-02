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

<table>
	<tr><td>상품번호</td><td>상품명</td><td>단가</td><td>판매수량</td><td>총금액</td></tr>
<c:forEach items="${list}" var="dto">
	<tr><td>${dto.prodNo}</td><td>${dto.prodName}</td><td><fmt:formatNumber value="${dto.prodPrice}" pattern="#,###,###,###"/>원</td><td>${dto.sumPurchQty}</td><td><fmt:formatNumber value="${dto.sumPurchPrice}" pattern="#,###,###,###"/>원</td></tr>
</c:forEach>
</table>
</body>

</html>