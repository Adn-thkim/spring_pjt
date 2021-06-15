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
직원 상세정보 페이지입니다. <br />

사원번호 :	${emp.empNo } <br />
아이디 : ${emp.empId } <br />
이름 : ${emp.empName } <br />
부서명 : ${emp.empDeptNumber } <br />
이메일 : ${emp.empEmail } <br />
연락처 :	${emp.empPhoneNumber } <br />
입사일 : <fmt:formatDate value="${emp.hireDate}" type="date"
		pattern="yy/MM/dd" /> <br />
급여 : ${emp.salary } <br />
<a href="empModify?empNo=${emp.empNo }">수정</a>
</body>
</html>