<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function delOk(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			document.frm.submit();
		}else{
			return false;
		}
	}
</script>

</head>
<body>

<form action="memDeleteOk" method="POST" name="frm" onsubmit="return delOk();">
	비밀번호 : <input type="password" name="membPw" /><br />
	<input type="submit" value="회원 탈퇴" />
</form>

</body>
</html>