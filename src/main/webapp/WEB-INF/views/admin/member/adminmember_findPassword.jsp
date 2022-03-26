<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>비밀번호 찾기</title>

    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
	<style>
		.bg-admin-image {
			  background-position: center;
			  background-size: cover;
			  background-image: url(<%=request.getContextPath()%>/resources/admin/img/admin.png);
		}
	</style>
</head>

<body class="bg-gradient-primary">
<%@include file="../include/adminnav.jsp" %>
<form class="user" name="myform" id="myform">
	<input type="hidden" name="idcheck" id="idcheck" value="N"/>
    <div class="container" style="margin-top:70px">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-admin-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4"><strong>패스워드 찾기</strong></h1>
                                    </div>
                                    	<div class="form-group">
		                                    <input type="text" class="form-control form-control-user" name="userid" id="userid"
		                                        placeholder="id" onkeyup="enterkey();">
		                                </div>
                                    	<div class="form-group">
		                                    <input type="text" class="form-control form-control-user" name="username" id="username"
		                                        placeholder="Name" onkeyup="enterkey();">
		                                </div>
		                                <div class="form-group">
		                                    <input type="email" class="form-control form-control-user" name="email" id="email"
		                                        placeholder="Email Address" onkeyup="enterkey();">
		                                </div>
		                               	<div class="input-group mb-3">
		    								<input type="text" class="form-control form-control-user" name="phone" id="phone" 
		    									placeholder="phone number" onkeyup="enterkey();">
		  								</div>
		  								<div class="mt-1 text-center" id="result">
                                        <a onclick="goFindPassword()" class="btn btn-primary btn-user btn-block">
                                            패스워드 찾기
                                        </a>
                                        </div>
                                        <div class="mt-1 text-center" id="result">
                                        <a class="small" style="float:left; margin-top:4px;"onclick="goRegister()">회원가입</a>
                                        <a class="small" style="float:right; margin-top:4px;"onclick="goCancel()">취소</a>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
    </form>

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/resources/admin/js/sb-admin-2.min.js"></script>

</body>

</html>

<script>
function enterkey(){
	if(window.event.keyCode == 13)
	{
		goFindPassword();
	}
}
function goFindPassword()
{
	var queryString = $("form[name=myform]").serialize();
    console.log( queryString );
      
   $.ajax({
      url:"${commonURL}/admin/adminmember/findPassword_proc",
      data:queryString,
      type:"POST",
      dataType:"json"
   })
   .done( (result)=>{
      if(result.result=="fail")
      {
    	  alert("해당하는 패스워드를 찾을 수 없습니다.");
      }
      else	//패스워드 실ㅍ시 3을 보낸다.
      {
    	  $("#result").html("패스워드는 <strong>" + result.result + "</strong> 입니다.")
      }
      
   })
   .fail( (error)=>{
      console.log(error);
   })
}
function goRegister()
{
	location.href="${commonURL}/admin/adminmember/join";
}
function goCancel()
{
	location.href="${commonURL}/admin/adminindex";
}

</script>