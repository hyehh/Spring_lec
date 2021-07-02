<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 조건 리스트</title>
</head>
<body>
	 <h3>MyBatis 주소록 조건 검색</h3>
	 
	 <br>
	 <br>
 
 	<form action="listQuery" method="post">
 		검색 선택 : 
 		<select name="query">
 			<option value="ADDRESS">주소</option>
 			<option value="RELATION">관계</option> 			
 		</select> &nbsp;&nbsp;&nbsp;
 		<input type="text" name="content" size="30">
 		<input type="submit" value="검색">
 	</form>
 
 	<br>
 	<br>
 
 	<table border="1">
 	
 		<tr>
 			<th>번호</th>
  			<th>이름</th>
  			<th>내용</th>
  			<th>주소</th>
  			<th>전자우편</th>
  			<th>관계</th>
 		</tr>
 		
 		<c:set var="cnt" value="0" />
 		
 		<c:forEach items="${list }" var="dto">
 		
 		<tr>
 			<td><a href="view?seqno=${dto.seqno }">${dto.seqno }</a></td>
 			<td>${dto.name }</td>
 			<td>${dto.telno }</td>
 			<td>${dto.address }</td>
 			<td>${dto.email }</td>
 			<td>${dto.relation }</td> 			
 		</tr>
 		<c:set var="cnt" value="${cnt=cnt+1 }" />
 		</c:forEach>
 		
 	</table>
 		
 		<br>
 		<br>
 		<p>검색 결과는 <b>${cnt }</b>명 입니다.</p>
 		
 		<p><a href="write">주소록 등록</a></p>
 		
</body>
</html>