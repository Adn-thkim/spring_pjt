<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="pwChangeOk" method="post">
	현재 비밀번호 : <input type="password" name="empPw" /><br/>
	변경 비밀번호 : <input type="password" name="newPw" /><br/>
	비밀번호 확인 : <input type="password" name="newPwCon" /><br/>
	<input type="submit" value="비밀번호 변경"/>
	<input type="reset" value="초기화"/>
	<input type="button" value="뒤로가기" onclick="javascript:history.back();" />
</form>

</body>
</html>