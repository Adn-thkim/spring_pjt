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

<p>
회원상세정보 페이지입니다.
</p>

아이디 : ${dto.membId }<br />
이름 : ${dto.membName }<br />
우편번호 : ${dto.postNumber }<br />
주소 : ${dto.membAddr } ${dto.detailAddr }<br />
이메일 : ${dto.membEmail }<br />
이메일 수신여부 : ${dto.membConfirm }<br />
연락처 : ${dto.membPhoneNumber }<br />
생년월일 : <fmt:formatDate value="${dto.membBirth }" type="date" pattern="yyyy-MM-dd"/><br />
성별 : ${dto.membGender }<br />
등록일 : <fmt:formatDate value="${dto.membEnterDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/><br />

<a href="memModify?membId=${dto.membId }">수정</a>

</body>
</html>