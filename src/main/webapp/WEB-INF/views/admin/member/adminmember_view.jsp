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

    <title>FLIXMEDIA-회원정보</title>

    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
	
</head>

<body id="page-top">
	<%@include file="../include/adminnav.jsp" %>
	<%
    AdminMemberDto dto = (AdminMemberDto)request.getAttribute("adminmemberDto");
                dto = (dto == null) ? new AdminMemberDto() : dto;
    %>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a onclick="goMain()" class="sidebar-brand d-flex align-items-center justify-content-center" >
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3"><strong>FLIXPEDIA-admin</strong></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" onclick="goMain()">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>메인화면</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                관리 메뉴
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>게시판</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">게시판 관리:</h6>
                        <a class="collapse-item" href="${commonURL}/admin/board/writemain">게시글 업로드</a>
                        <a class="collapse-item" href="${commonURL}/admin/board/listmain">게시글 수정/삭제</a>
                        <a class="collapse-item" href="${commonURL}/admin/review/list">평점 관리</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>회원</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">회원 관리:</h6>
                        <a class="collapse-item" href="${commonURL}/admin/user/list">회원정보관리</a>
                        <a class="collapse-item" href="${commonURL}/admin/q_a/list">고객센터</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                기타
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>기타기능</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">기타 기능 관리:</h6>
                        <a class="collapse-item" href="${commonURL}/admin/list">광고메일전송</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" style="width:150px; height:auto; "src="<%=request.getContextPath()%>/resources/admin/img/logo.png" alt="...">
                <p class="text-center mb-2"><strong>FLIXPEDIA</strong> 메인페이지로 이동하여 자세한 사항을 확인하세요</p>
                <a class="btn btn-success btn-sm" href="${commonURL}/">도메인이동</a>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form name="myform2" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2" name="keyword2" id="keyword2" value="<%=keyword2 %>"
                                onkeydown="naventerkey();">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button" onclick="goMainSearch()">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small" id="username"><%=username%></span>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="${commonURL}/admin/adminmember/myinfo">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    내 정보
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="${commonURL}/member/logout" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

				<!-- Begin Page Content -->
				<form id="myform" name="myform" enctype="multipart/form-data">
				<input type="hidden" name="id" id="id" value="<%=dto.getId() %>"/>
				
					<div class="container rounded bg-white mt-5 mb-5">
					    <div class="row" style="justify-content:center;">
					        <div class="col-md-7">
					            <div class="p-3 py-5">
					                <div class="d-flex justify-content-between align-items-center mb-3">
					                    
					                </div>
					           	<div class="row" style="align-items: center !important;">    
			                        <div class="p-5">
			                            <div class="text-center">
			                                <h1 class="h4 text-gray-900 mb-4"><strong>회원정보</strong></h1>
			                            </div>
			                            <% if(dto.getUserid().equals("")) {%>
			                                <div class="form-group">
			                                    	<input type="hidden" name="idcheck" id="idcheck" value="N"/>
			                                        <div style="overflow:hidden;">
			                                        <input style="width:65% !important; float:left;" type="text" 
			                                        class="form-control form-control-user" name="userid" id="userid"
			                                            placeholder="user id" value="<%=dto.getUserid()%>">
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
			                                        placeholder="user id" value="<%=dto.getUserid()%>" readonly>
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
				                                <button class="btn btn-primary profile-button" type="button" onclick="goWrite()">등록</button>
							                    <button class="btn btn-primary profile-button" type="button" onclick="goCancel()">취소</button>
			                                </div>
		                                </div>
	                        	</div>
					            </div>
					        </div>
					    </div>
					</div>
				</form>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Made By HJ &copy; FLIXPEDIA 2022</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">로그아웃 하시겠습니까?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>

                    <a class="btn btn-primary" href="${commonURL}/admin/adminmember/logout">로그아웃</a>

                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/resources/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="<%=request.getContextPath()%>/resources/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=request.getContextPath()%>/resources/admin/js/demo/chart-area-demo.js"></script>
    <script src="<%=request.getContextPath()%>/resources/admin/js/demo/chart-pie-demo.js"></script>

</body>

</html>
<script>
function goPopup()
{
	var pop = window.open("juso","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}
//주소 api
function jusoCallBack(address1,address2,zipcode)
{
		document.myform.address1.value = address1;
		document.myform.address2.value = address2;
		document.myform.zipcode.value = zipcode;
}
//아이디 중보체크
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
			if(data.result == "true")	//중복
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
		alert("닉네임을 입력하세요");
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
		msg="회원가입 되었습니다.";
	}
	else
	{
		url="${commonURL}/admin/adminmember/update",
		msg="수정 되었습니다.";
	}

	$.ajax({
		url:url,
		data:queryString,
		type:"POST",
	})
	.done( (result)=>{
		console.log( result );
		alert(msg);
		location.href="${commonURL}/admin/adminhome";
	})
	.fail( (error)=>{
		console.log(error);
	})
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
	
	function goCancel()
	{
		location.href="${commonURL}/admin/adminhome";
	}
</script>