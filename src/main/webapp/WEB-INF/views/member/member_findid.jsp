<%@ page language="java"  pageEncoding="utf-8"%>
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
</head>
<body class="body">

<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
<form class="sign__form"  name="myform" id="myform">
	<a href="index.html" class="sign__logo">
		<img src="${commonURL}/resources/img/logoimg.png" alt="">
	</a>
   <input type="hidden" name="idcheck" id="idcheck" value="N"/>
   
	
	
	  <div class="sign__group">
	    <input type="text" class="sign__input"  placeholder="이름" name="name" id="name">
	  </div>
	
	  <div class="sign__group">
	    <input type="text" class="sign__input"  name="phone" id="phone" placeholder="전화번호">
	  </div>
	
	  
	     <div class="container" style="text-align:right">
	    
	     <div class="btn-group">
	       
	       <button class="sign__btn" type="button" onclick="goFindId()">아이디찾기</button>&nbsp;&nbsp;
	       <button class="sign__btn" type="button" onclick="goCancel()">취소</button>&nbsp;&nbsp;
	     </div>
	     
	   </div>
	    
	   <div class="sign__group">
		     	<div style="color: gray" id="result"> </div>
		    </div>

</form>   
</div>
</div>
</div>
</div>
</div>

<%@include file="../include/footer.jsp" %>
</body>
</html>

<script>

function goFindId()
{
   //var frmData = new FormData(document.myform);
   //console.log( frmData );
     var queryString = $("form[name=myform]").serialize();   
   $.ajax({
	   url:"${commonURL}/member/findid_proc",
	      data:queryString,
	      type:"POST",
	      data:queryString
   })
   .done( (result)=>{
      	if(result.result=="fail")
		{
      		alert("해당하는 아이디를 찾을 수 없습니다.");
		}
       	else  //패스워드 실패시 3을 보낸다  
      	{
      		$("#result").html("아이디는 <strong>" + result.result + "</strong> 입니다");	
      	}
   })
   .fail( (error)=>{
      console.log(error);
   })
}



function goCancel()
{
  var frm = document.myform;
   frm.action="${commonURL}/member/signin";
   frm.submit();
}
</script>