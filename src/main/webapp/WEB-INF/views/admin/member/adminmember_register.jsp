<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.flix.admin.member.*" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>회원가입</title>

    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin-2.css" rel="stylesheet">
    <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
	<style>
		.bg-admin-image {
			  background-position: center;
			  background-size: cover;
			  background-image: url(<%=request.getContextPath()%>/resources/admin/img/admin.png);
		}
		.form-group-append {
		  display: flex;
		}
	</style>
</head>

<body class="bg-gradient-primary">
<%@include file="../include/adminnav.jsp" %>
<%
AdminMemberDto dto = (AdminMemberDto)request.getAttribute("adminmemberDto");
%>
<form class="user" name="myform" id="myform" enctype="multipart/form-data">
<input type="hidden" name="id" id="id" value="<%=dto.getId() %>"/>
    <div class="container"  style="margin-top:70px">

	<!-- Outer Row -->
	<div class="row justify-content-center">

	<div class="col-xl-10 col-lg-12 col-md-9">
	
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row" style="align-items: center !important;">
                    <div class="col-lg-6 d-none d-lg-block bg-admin-image" style="width:500px; height:500px;"></div>    
                    <div class="col-lg-6">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4"><strong>회원가입</strong></h1>
                            </div>
                            <% if(dto.getUserid().equals("")) {%>
                                <div class="form-group">
                                    	<input type="hidden" name="idcheck" id="idcheck" value="N"/>
                                        <div style="overflow:hidden;">
                                        <input style="width:65% !important; float:left;" type="text" 
                                        class="form-control form-control-user" name="userid" id="userid"
                                            placeholder="id">
                                        <div style="float:right;" class="form-group-append">
   											<button class="btn btn-success" type="button" id="btnDuplicate"
   											style=" width:100px; height: 50px;">중복체크</button>  
     									</div>
     									</div>
                                        <p style="font-size: 11px">아이디는 영문 대소문자와 숫자 4~12자리로 입력하세요</p>
                                </div>
                            <%} else {%>
                            	<div class="form-group">
                                    	<input type="hidden" name="idcheck" id="idcheck" value="N"/>
                                        <input type="text" class="form-control form-control-user" name="userid" id="userid"
                                            placeholder="Name" value="<%=dto.getUserid()%>" readonly>
                                        <div class="form-group-append">
      										<button class="btn btn-success" type="button" id="btnDuplicate"></button>  
     									</div>
                                </div>
                             <%} %>
                             
                                <div class="form-group main i">
                                    <input type="password" class="form-control form-control-user" name="password" id="password" 
                                        placeholder="password" value="<%=dto.getPassword()%>">
                                        <i class="fa fa-eye fa-lg"></i>
                                    <p style="font-size: 11px">비밀번호는 영문 대소문자와 숫자 4~12자리로 입력하세요</p>
                                </div>
                                <div class="form-group main i">
                                    <input type="password" class="form-control form-control-user" name="pwd_ck" id="pwd_ck" 
                                        placeholder="password check" value="<%=dto.getPassword()%>">
                                        <i class="fa fa-eye fa-lg"></i>
                                </div>
                                <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                            name="username" id="username" placeholder="이름" value="<%=dto.getUsername()%>">
                                 </div>
                                 <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                            name="nickname" id="nickname" placeholder="닉네임" value="<%=dto.getNickname()%>">
                                 </div>
                                 <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                            name="email" id="email" placeholder="email" value="<%=dto.getEmail()%>">
                                 </div>
                                 <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                            name="phone" id="phone" placeholder="전화번호" value="<%=dto.getPhone()%>">
                                 </div>
                                 <div class="form-group">
                                 <div style="overflow:hidden;">
                                        <input style="width:65% !important; float:left;" 
                                        	type="text" class="form-control form-control-user" readonly="readonly"
                                            name="zipcode" id="zipcode" placeholder="우편번호" value="<%=dto.getZipcode()%>">
                                        <button class="btn btn-success" type="button" onClick="goPopup();" value="팝업_domainChk"
                                        		style="float:right; width:100px; height: 50px;">
                                        		주소 검색
                                        </button>
                                 </div>
										<p style="font-size: 11px">주소는 검색을 이용해주세요</p>
                                 </div>
                                 <div class="form-group">
                                        <input type="text" class="form-control form-control-user" readonly="readonly"
                                            name="address1" id="address1" placeholder="도로주소" value="<%=dto.getAddress1()%>">
                                 </div>
                                 <div class="input-group mb-3">
                                        <input type="text" class="form-control form-control-user" readonly="readonly"
                                            name="address2" id="address2" placeholder="상세주소" value="<%=dto.getAddress2()%>">
                                 </div>
                                 <div class="mt-1 text-center" id="result">
	                                <a style="cursor:pointer; width:100% !important" onclick="goWrite()" class="btn btn-primary btn-user btn-block">
	                                    등록
	                                </a>
	                                <a class="small" onclick="goCancel()">취소</a>
	                                </div>
	                                <a style="cursor:pointer; width:100% !important" 
	                                href="index.html" class="btn btn-google btn-user btn-block">
	                                    <i class="fab fa-google fa-fw"></i> Register with Google
	                                </a>
	                                <a style="cursor:pointer; width:100% !important" 
	                                href="index.html" class="btn btn-facebook btn-user btn-block">
	                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
	                                </a>
	                            	<hr>   
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

<script language="javascript">
function goPopup()
{
	var pop = window.open("juso","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}
function jusoCallBack(address1,address2,zipcode)
{
		document.myform.address1.value = address1;
		document.myform.address2.value = address2;
		document.myform.zipcode.value = zipcode;
}

$(()=>{
	$("#btnDuplicate").click(()=>{
		$.ajax({
			url:"${commonURL}/admin/adminmember/isDuplicate",	//요청 url정보
			data:{userid:$("#userid").val()},	//서버로 전달할 데이터 정보 : JSON형태
			dataType:"json",	//결과를 json으로 받겠다. 이렇게 안하면 결과값이 text로 온다.
			type:"POST"
		})
		.done((data)=>{
			//데이터가 정상적으로 수신되면 done이라는 메서드가 호출되면서 매개변수는 전달받은 값
			//값은 dataType 속성을 안주면 text로 온다.
			console.log(data.result);
			if(data.result == "")
			{
				alert("id를 입력하세요")
			}
			else if(data.result == "true")	//중복
			{
				alert("이미 사용중인 아이디 입니다.")
			}
			else
			{
				alert("사용 가능합니다.")
				$("#idcheck").val("Y");
				$("#userid").prop("readonly", true);	//수정못하게 막는 기능
			}
		})
		.fail((error)=>{
			//통신에러, 오류에 대한 것
			console.log(error)
		})
	})
})
function goWrite()
{
	var queryString = $("form[name=myform]").serialize();
	console.log( queryString );
	var userid='<%=dto.getUserid()%>';
	var frm = document.myform;
	if( frm.username.value.trim()==""){
		alert("이름을 입력하세요");
		frm.username.focus();
		return false;
	};
	
	 if( frm.userid.value.trim()==""){
   		alert("아이디를 입력하세요");
   		frm.userid.focus();
   		return false;
   		} 
	if( frm.password.value.trim()=="")
	{
		alert("비밀번호를 입력하세요");
		frm.password.focus();
		return false;
	}
	 var password1RegExp = /^[a-zA-z0-9]{4,12}$/; //비밀번호 유효성 검사
     if (!password1RegExp.test(frm.password.value.trim())) {
         alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
         form.password.value = "";
         form.password.focus();
         return false;
     }
	if( frm.password.value.trim()!=frm.pwd_ck.value.trim())
	{
		alert("비밀번호가 다릅니다");
		frm.pwd_ck.focus();
		return false;
	};
	if( frm.nickname.value.trim()=="")
	{
		alert("별명을 입력하세요");
		frm.nickname.focus();
		return false;
	};
	if( frm.email.value.trim()=="")
	{
		alert("이메일을 입력하세요");
		frm.email.focus();
		return false;
	};
	if( frm.phone.value.trim()=="")
	{
		alert("전화번호를 입력하세요");
		frm.phone.focus();
		return false;
	};
	if( frm.zipcode.value.trim()=="")
	{
		alert("우편번호를 입력하세요");
		frm.zipcode.focus();
		return false;
	};
	if( frm.address1.value.trim()=="")
	{
		alert("도로명 주소를 입력하세요");
		frm.address1.focus();
		return false;
	};
	if( frm.address2.value.trim()=="")
	{
		alert("상세 주소를 입력하세요");
		frm.address2.focus();
		return false;
	};
	
	if(userid=='')
	{
		url="${commonURL}/admin/adminmember/insert",
		msg="회원가입이 되었습니다.";
	}
	else
	{
		url="${commonURL}/admin/adminmember/update",
		msg="회원 정보가 수정되었습니다."
	}
		
	$.ajax({
		url:url,
		data:queryString,
		type:"POST",
	})
	.done( (result)=>{
		console.log( result );
		alert(msg);
		location.href="${commonURL}/admin/adminindex";	//시작화면으로 이동하기
	})
	.fail( (error)=>{
		console.log(error);
	})
}

function goModify()
{
	var frm = document.form;
	frm.action="/board/modify_save";
	frm.submit();
}

function goCancel()
{	
	history.back();
}

//패스워드 숨기기 보이기 기능구현
$(document).ready(function(){
    $('.main i').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa fa-eye-slash fa-lg")
            .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa fa-eye fa-lg")
            .prev('input').attr('type','password');
        }
    });
});

</script>