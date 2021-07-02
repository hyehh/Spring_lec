<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 내용</title>
</head>
<body>
	 <h3>MyBatis 주소록 내용</h3>
	 
	 <br>
	 <br>
 
 	<form action="modify" method="post">
 	
 	<table border="1">
 	
 		<tr>
 		 	<td>번호</td>
 			<td><input type="text" name = "seqno" readonly="readonly" value="${view.seqno }"></td>
 		</tr>
 	
 		<tr>
 			<td>이름</td>
 			<td><input type="text" name="name" value="${view.name }"></td>
 		</tr>
 	
 	 	<tr>
 			<td>내용</td>
 			<td><input type="text" name="telno" value="${view.telno }"></td>
 		</tr>

 	 	<tr>
 			<td>주소</td>
 			<td><input type="text" name="address" value="${view.address }"></td>
 		</tr>
 		
 	 	<tr>
 			<td>전자우편</td>
 			<td><input type="text" name="email" value="${view.email }"></td>
 		</tr> 		
 		
 		<tr>
 			<td>관계</td>
 			<td><input type="text" name="relation" value="${view.relation }"></td>
 		</tr>
 		
 		<tr>
 			<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="list">목록보기</a>&nbsp;&nbsp;&nbsp;<a href="delete?seqno=${view.seqno }">삭제</a></td>
 		</tr>
 		 		
 	</table>
 	
 	</form>
 	
</body>
</html>