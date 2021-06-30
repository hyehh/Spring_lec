<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${select.bName }" size="20"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${select.bTitle }" size="50"></td>
			</tr>			
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="bContent">${select.bContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="delete?bId=${content_view.bId }">삭제</a></td>
			</tr>
	</table>
</body>
</html>