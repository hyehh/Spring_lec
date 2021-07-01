<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Line 게시판</title>
</head>
<body>
	
	<table border="1">
	
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>삭제</th>			
		</tr>
	
		<c:forEach items="${list }" var="dto">
	
		<tr>
			<td>${dto.bId }</td>
			<td>${dto.bName }</td>
			<td>${dto.bTitle }</td>
			<td>${dto.bDate }</td>
			<td><a href="delete?bId=${dto.bId }">X</a></td>			
		</tr>
		
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="write">글 작성</a></td>
		</tr>
			
	</table>
	
</body>
</html>