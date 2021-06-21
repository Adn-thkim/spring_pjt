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
			return document.frm.submit();
		}else{
			return false;
		}
	}
</script>

</head>
<body>

<form action="empDeleteOk" method="post" name="frm" onsubmit="return delOk(); ">
	비밀번호 : <input type="password" name="empPw" /><br/>
	<input type="submit" value="회원탈퇴" />
	<input type="button" value="뒤로가기" onclick="javascript:history.back();" />
</form>

</body>
</html>