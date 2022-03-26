<%@ page language="java" pageEncoding="utf-8"%>
 <%
request.setAttribute("commonURL", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
	<%@include file="../include/css.jsp" %>
	<title>FlixPedia – Online Movies, TV Shows & Cinema HTML Template</title>

</head>
<body class="body">
<%@include file="../include/header.jsp" %>
	<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
						<!-- authorization form -->
						<form class="sign__form" name="form">
							<a href="${commonURL}/" class="sign__logo">
								<img src="${commonURL}/resources/img/logoimg.png" alt="">
							</a>

							<div class="sign__group">
								<input type="text" class="sign__input"  placeholder="아이디" name="user_id" id="user_id">
							</div>

							<div class="sign__group">
								<input type="password" class="sign__input" placeholder="비밀번호" name="password" id="password">
							</div>

							<div class="sign__group sign__group--checkbox">
								<input id="remember" name="remember" type="checkbox" checked="checked">
								<label for="remember">아이디저장</label>
							</div>
							
							<button class="sign__btn" type="button" onclick="goWrite()">로그인</button>

							<span class="sign__text">계정이 없으신가요? <a href="${commonURL}/member/signup">회원가입</a></span>

							<span class="sign__text"><a href="${commonURL}/member/findid">아이디 찾기</a></span>
							<span class="sign__text"><a href="${commonURL}/member/findpassword">비밀번호 찾기</a></span>
						</form>
						<!-- end authorization form -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../include/footer.jsp" %>
</body>

</html>

<script>
function goWrite()
{
   //var frmData = new FormData(document.form);
   //console.log( frmData );
    var queryString = $("form[name=form]").serialize();  
   $.ajax({
	   url:"${commonURL}/member/login_proc",
	      data:queryString,
	      type:"POST",
	      data:queryString
   })
   .done( (result)=>{
      	if(result.flag=="1")
		{
      		alert("로그온 성공");
      		location.href="${commonURL}/";
		}
      	else if(result.flag=="2")
      	{
      		alert("아이디를 찾을 수 없습니다.");
      	}
      	else  //패스워드 실패시 3을 보낸다  
      	{
      		alert("패스워드가 일치하지 않습니다.");	
      	}
   })
   .fail( (error)=>{
      console.log(error);
   })
}

</script>