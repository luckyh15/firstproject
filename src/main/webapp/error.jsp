<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
</body>
</html>
<script>	
	var url = document.location.href;	//도메인 창 url 가져오기
	var arr = url.split("/");			//url을 /로 쪼개기
    var domain = arr[0] + "//" + arr[2];//배열로 url 나누기 [0]http: [1]localhost:8080 [2]"" [3]flixpedia 이런식으로

	console.log(arr[4]=='admin');		//4번배열에 admin인지 확인
	
	if(arr[4]=='admin')					//맞다면 error.jsp 를 갔다가 admin notfound로 바로이동
		window.location.href="${commonURL}/flixpedia/notfound";	//AdminBoardController에 404에러 requestMapping 해놓음.
	else								//아니라면 error.jsp를 갔다가 user 404로 이동
		window.location.href="${commonURL}/flixpedia";			//만들어야함.
</script>
