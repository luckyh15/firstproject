<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateQ_A.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
	    <tr>
	        <td width="70">제목</td><td align="left">
	        <input type="text" name="q_a_title"/></td>
	    </tr>
	    <tr>
	        <td>내용</td><td align="left">
	        <textarea name="q_a_contents" cols="70" rows="23"></textarea></td>
	       
	    </tr>
	    
	    <tr>
	        <td colspan="2" align="center">
	        <input type="submit" value=" 수정 "/></td>
	    </tr>
	</table>
	</form>
	<hr>
		<!-- <a href="getQ_A_List.do">글 목록 가기</a> -->
</body>
</html>