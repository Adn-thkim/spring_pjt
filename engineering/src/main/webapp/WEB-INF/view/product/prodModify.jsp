<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품정보 수정페이지입니다.

<form action="prodModifyOk" method="post">
<input type="hidden" name="prodNo" value="${dto.prodNo}" />
<table border="1" align="center">
	<tr><th>상품번호</th>
		<td>
			${dto.prodNo}
		</td></tr>
			
	<tr><th>상품명</th>
		<td>
			<input type="text" name="prodName" value="${dto.prodName}"/>
		</td></tr>
			
	<tr><th>가격</th>
		<td>
			<input type="number" name="prodPrice" value="${dto.prodPrice}" min=0, step="10"/>
		</td></tr>
			
	<tr><th>설명</th>
		<td>
			<textarea rows="6" cols="30" name="prodInfo">${dto.prodInfo}</textarea>
		</td></tr>
			
	<tr><th colspan="2" align="center">
			<input type="submit" value="수정" />
			<input type="button" value="삭제" onclick="javascript:location.href='prodDel?prodNo=${dto.prodNo}'"/>
			<input type="button" value="리스트" onclick="javascript:history.back();" />
		</th></tr>
</table>
</form>
</body>
</html>