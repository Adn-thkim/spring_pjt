<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제페이지<br /><br />
<form action="doPayment" method="post">
<input type="hidden" name="purchNo" value="${purchNo}" />
<input type="hidden" name="payPrice" value="${payPrice}" />
<table>
	<tr><td>구매번호</td><td align="right">${purchNo}</td></tr>
	<tr><td>결제금액</td><td align="right"><fmt:formatNumber value="${payPrice}" pattern="#,###,###,###"/>원</td></tr>
	<tr><td>결제방법</td><td align="right">카드</td></tr>
	<tr><td>카드/계좌번호</td>
		<td><input type="text" name="payAccNum" /></td></tr>
	<tr><td>카드사/은행명</td>
		<td><input type="text" name="payCardBank" /></td></tr>
	<tr><th colspan="2"><input type="submit" value="결제" /></th></tr>
</table>
</form>
</body>
</html>