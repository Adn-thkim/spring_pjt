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

<form action="empUpdateOk" method="post" name="frm">
<input type="hidden" name="empId" value="${dto.empId}"/>
<table border= "1" width="350" align="center">
	<tr><td width="130">직원번호</td>
		<td width="220">
			${dto.empNo}
		</td></tr>
	<tr><td>아이디</td>
		<td>
			${dto.empId}
		</td></tr>
	<tr><td>비밀번호</td>
		<td>
			<input type="password" name="empPw" /><span>${pwFail2}</span>
		</td></tr>
	<tr><td>이름</td>
		<td>
			${dto.empName}
		</td></tr>
	<tr><td>부서명</td>
		<td>
			<input type="text" name="empDeptNumber" value="${dto.empDeptNumber}">
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="empEmail" value="${dto.empEmail}">
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="empPhoneNumber" 
				placeholder="010-1234-1234" value="${dto.empPhoneNumber }">
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<input type="text" name="hireDate" placeholder="2000-01-01"
			value="<fmt:formatDate value='${dto.hireDate }' type='date' pattern='yyyy-MM-dd' />">
		</td></tr>
	<tr><td>급여</td>
		<td>
			<input type="number" min="0" step="100" name="salary" value="${dto.salary }">
		</td></tr>
	<tr><td colspan=2 align="center">
			<input type="submit" value="수정완료">
			<input type="reset" value="초기화">
			<input type="button" value="뒤로가기" onclick="javascript:history.back();"/>
		</td></tr>
</table>
</form>

</body>
</html>