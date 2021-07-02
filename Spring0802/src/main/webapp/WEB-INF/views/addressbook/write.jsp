<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 등록</title>
</head>
<body>
	 <h3>MyBatis 주소록 등록</h3>
	 
	 <br>
	 <br>
 
 	<form action="writeAdd" method="post">
 	
 	<table border="1">
 	
 		<tr>
 			<td>이름</td>
 			<td><input type="text" name="name"></td>
 		</tr>
 	
 	 	<tr>
 			<td>내용</td>
 			<td><input type="text" name="telno"></td>
 		</tr>

 	 	<tr>
 			<td>주소</td>
 			<td><input type="text" name="address"></td>
 		</tr>
 		
 	 	<tr>
 			<td>전자우편</td>
 			<td><input type="text" name="email"></td>
 		</tr> 		
 		
 		<tr>
 			<td>관계</td>
 			<td><input type="text" name="relation"></td>
 		</tr>
 		 		
 		<tr>
 			<td colspan="2"><input type="submit" value="등록"></td>
 		</tr>
 		
 	</table>
 	
 	</form>
 	
</body>
</html>