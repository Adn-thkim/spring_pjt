<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

나의 정보 <br />

아이디 : ${dto.membId }<br />
이름 : ${dto.membName }<br />
우편번호 : ${dto.postNumber }<br />
주소 : ${dto.membAddr } ${dto.detailAddr }<br />
이메일 : ${dto.membEmail }<br />
이메일 수신여부 : <c:if test="${dto.membConfirm.trim() == 'Y'}">수신</c:if>
			 <c:if test="${dto.membConfirm.trim() == 'N'}">수신 안함</c:if><br />
연락처 : ${dto.membPhoneNumber }<br />
생년월일 : <fmt:formatDate value="${dto.membBirth }" type="date" pattern="yyyy-MM-dd"/><br />
성별 : <c:if test="${dto.membGender.trim() == 'M'}">남자</c:if>
	 <c:if test="${dto.membGender.trim() == 'F'}">여자</c:if><br />
등록일 : <fmt:formatDate value="${dto.membEnterDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/><br />

<a href="memUpdate">수정</a>
</body>
</html>