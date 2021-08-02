<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
리뷰 수정 페이지<br />
<form action="goodsReviewUpdateOk" method="post" name="frm">
<input type="hidden" value="${dto.prodNo}" name="prodNo" />
<table>
	<tr><td>구매번호</td>
		<td><input type="text" name="purchNo" value="${dto.purchNo}" readonly="readonly" /></td></tr>
	<tr><td>상품명</td>
		<td>${prodName}</td></tr>
	<tr><td>내용</td>
		<td><textarea rows="5" cols="50" name="reviewContent">${dto.reviewContent}</textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="수정" />
						<input type="button" value="취소" onclick="javascript:history.back();" /></td></tr>
</table>
</form>
</body>
</html>