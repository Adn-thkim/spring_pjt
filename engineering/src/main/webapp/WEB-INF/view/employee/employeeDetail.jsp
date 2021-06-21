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

나의 정보 <br />

직원번호 : ${dto.empNo }<br />
아이디 : ${dto.empId }<br />
이름 : ${dto.empName }<br />
부서명 : ${dto.empDeptNumber}<br />
이메일 : ${dto.empEmail }<br />
연락처 : ${dto.empPhoneNumber }<br />
급여 : ${dto.salary}<br />
입사일 : <fmt:formatDate value="${dto.hireDate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/><br />

<a href="empUpdate">수정</a>

</body>
</html>