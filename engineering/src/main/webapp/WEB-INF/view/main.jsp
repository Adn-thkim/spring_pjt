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

<c:if test = "${empty authInfo}">

<!-- 로그인이 안된 상태 -->
<form action="login" method="post">
<table border=1>
	<tr><td colspan="3">Main</td></tr>
	<tr><td>아이디</td>
		<td>
			<input type="text" name="loginId" /><span>${userFail}</span>
		</td><td rowspan="2">
			<input type="image" src=""/>
		 </td></tr>
	<tr><td>비밀번호</td>
		<td>
			<input type="password" name="loginPw" /><span>${pwFail}</span>
		</td></tr>
	<tr><td colspan="3">
			아이디/비밀번호 찾기 | 
			<a href="member/agree">회원가입</a>
			
		</td></tr>
</table>
</form>
</c:if>

<c:if test="${!empty authInfo}">

<c:if test="${authInfo.grade != 1}">
<!-- 관리자로 로그인 -->
	<a href="emp/empList">직원정보 리스트</a><br />
	<a href="member/memList">회원정보 리스트</a><br />
	<a href="emp/empMypage">직원마이페이지</a><br />
	<a href="prod/prodList">상품 정보 리스트</a><br />
	<a href="sales/salesList">판매 현황</a><br />
</c:if>

<c:if test="${authInfo.grade == 1}">
<!-- 회원 로그인 -->
	<a href="member/memMyPage">마이페이지</a><br />
	<a href="prod/cartList">장바구니</a><br />
	<a href="prod/purchCon">주문확인</a><br />
</c:if>
	<a href="logout">로그아웃</a>
</c:if>

<table width="600">
	<tr>
	<c:forEach items="${prodList}" var="dto" varStatus="cnt">
		<td>
		<a href="prod/prodInfo?prodNo=${dto.prodNo}">
		<img width="200" src="product/upload/${dto.prodImage.split(',')[0]}" /><br />
		${dto.prodName}<br /><fmt:formatNumber value="${dto.prodPrice}" pattern="#,###,###,###"/>원
		</a>
		</td>
		<c:if test="${cnt.count % 3 == 0}">
			</tr><tr>
		</c:if>
	</c:forEach>
	</tr>
</table>

</body>
</html>