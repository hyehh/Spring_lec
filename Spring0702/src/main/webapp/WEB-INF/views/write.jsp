<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>

	<form action="writeAdd" method="post">
	
	<table border="1">
	
		<tr>
			<td>이름</td>
			<td><input type="text" name="bName" size="20"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" size="50"></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="작성"></td>
		</tr>
	
	</table>
	
	</form>
	
</body>
</html>