<%@page import="com.semi.flix.common.StringUtil"%>
<%@page import="com.semi.flix.member.MemberDto"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
request.setAttribute("commonURL", request.getContextPath());

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<%@include file="../include/css.jsp" %>
	<title>FlixPedia – Online Movies, TV Shows & Cinema HTML Template</title>
</head>
<body class="body">
<%@include file="../include/header.jsp" %>
 <div class="sign section--bg" data-bg="${commonURL }/resources/img/section/section.jpg" style="margin-top : 70px;">
 	<div class="container">
 		<div class="col-12">
 			<div class="sign__content">
 			
				<form name="form" id="form" method="post" class="sign__form" enctype="multipart/form-data">
					<a href="index.html" class="sign__logo">
					
					
					<img src="${commonURL}/resources/img/logoimg.png" alt=""></a>
					

					<div style="width: 130px;height: 130px; border-radius: 50%; overflow: hidden; margin-bottom: 50px; "	>
					<img class="thumb" src="../upload/basic.jpg" 
					style="width: 130px; height: 130px; object-fit: cover; " />
					</div>
					<input type="hidden" id="user_images" name="user_images" value="">
					<div class="filebox">
						<input class="sign__input" id="upload-name" value="" placeholder="프로필사진"><br>
                        <label for="upload" style="width:100px; height: 30px; margin:2px;" 
                         >사진 찾기</label> 
   						<input type="file"  id="upload" name="upload"
   							accept="image/jpeg, image/jpg, image/png" multiple>
					</div>
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="이름" id="name" name="name" >
					</div>
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="아이디" id="user_id" name="user_id">
					</div>
					<div class="card__description">
						<p style="font-size: 11px">아이디는 영문 대소문자와 숫자 4~12자리로 입력하세요</p>
					</div><br>
					<button class="sign__btn" type="button" id="btnDuplicate" 
					style="width:100px; height: 30px; margin:2px;">중복체크</button>
					<input type="hidden" id="id_check" name="id_check" value="N"/>
					<br>
					<div class="sign__group">
						<input type="password" class="sign__input" placeholder="비밀번호" id="password" name="password">
					</div>
					<div class="sign__group">
						<input type="password" class="sign__input" placeholder="비밀번호 확인" id="pwd_ck" name="pwd_ck">
					</div>

					<div class="card__description">
						<p style="font-size: 11px">비밀번호는 영문 대소문자와 숫자 4~12자리로 입력하세요</p>
					</div><br>

					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="별명" id="nick_name" name="nick_name">
					</div>
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="Email" id="email" name="email">
					</div>
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="전화번호" id="phone" name="phone">
					</div>
					<button type="button" class="sign__btn" 
							onClick="goPopup();" value="팝업_domainChk"
							style="width:100px; height: 30px; margin:2px;">주소 검색</button>
							<div class="card__description">
								<p style="font-size: 11px">주소는 검색을 이용해주세요</p>
							</div>
							<br>
			
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="우편번호" id="zipcode" name="zipcode" readonly="readonly">
					</div>
					
					<div class="sign__group">

						<input type="text" class="sign__input" placeholder="주소" id="address1" name="address1" readonly="readonly">
					</div>
					
					<div class="sign__group">
						<input type="text" class="sign__input" placeholder="상세주소" id="address2" name="address2" readonly="readonly">
					</div>
					<button type="button" class="sign__btn" onclick="goWrite()">등록</button>
					
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/footer.jsp" %>

</body>
</html>
<script language="javascript">
//파일 추가 하면 파일명 보여쥬기
$("#upload").on('change',function(){
  var fileName = $("#upload").val();
  $("#upload-name").val(fileName);
  $("#user_images").val(fileName);

});	
	 
	 document.addEventListener('DOMContentLoaded', function(){
		    //이미지 객체 타입으로 이미지 확장자 밸리데이션
		    var validateType = function(img){
		        return (['image/jpeg','image/jpg','image/png'].indexOf(img.type) > -1);
		    }

		    var validateName = function(fname){
		        let extensions = ['jpeg','jpg','png'];
		        let fparts = fname.split('.');
		        let fext = '';
		    
		        if(fparts.length > 1){
		            fext = fparts[fparts.length-1];
		        }
		    
		        let validated = false;
		        
		        if(fext != ''){
		            extensions.forEach(function(ext){
		                if(ext == fext){
		                    validated = true;
		                }
		            });
		        }
		    
		        return validated;
		    }

		    // 파일 선택 필드에 이벤트 리스너 등록
		    document.getElementById('upload').addEventListener('change', function(e){
		        let elem = e.target;
		        if(validateType(elem.files[0])){
		            let preview = document.querySelector('.thumb');
		            preview.src = URL.createObjectURL(elem.files[0]); //파일 객체에서 이미지 데이터 가져옴.
		            
		            //document.querySelector('.dellink').style.display = 'block'; // 이미지 삭제 링크 표시
		            preview.onload = function() {
		                URL.revokeObjectURL(preview.src); //URL 객체 해제
		            }
		        }else{
		        console.log('이미지 파일이 아닙니다.');
		        }
		    });

		   
		});
function goPopup()
{
	var pop = window.open("jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	}


function jusoCallBack(address1,address2, zipcode)
{
		document.form.address1.value = address1;
		document.form.address2.value = address2;
		document.form.zipcode.value = zipcode;
	}

	
function goWrite() 
{
	var id_check =document.form.id_check.value;
	var frm = document.form;
	if( frm.name.value.trim()==""){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	};
	
	
	 if( frm.user_id.value.trim()==""){
   		alert("아이디를 입력하세요");
   		frm.user_id.focus();
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
	if( frm.nick_name.value.trim()=="")
	{
		alert("별명을 입력하세요");
		frm.nick_name.focus();
		return false;
	};
	if( frm.nick_name.value.trim().length>4)
	{
		alert("별명은 4글자 이내로 입력하세요");
		frm.nick_name.focus();
		return false;
	};
	if( frm.email.value.trim()=="")
	{
		alert("이메일을 입력하세요");
		frm.email.focus();
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

	
	
	if(id_check=="N"){
		alert("아이디 중복체크를 하세요")
		frm.user_id.focus();
	}else{
   var frmData = new FormData(document.form);
  // console.log( frmData );
  // var queryString = $("form[name=form]").serialize(); 
	$.ajax({
      url:"${commonURL}/member/insert",
      processData : false,
      contentType : false,
      data : frmData,
      type:"POST"
   })
   .done( (result)=>{
      console.log(result);
      alert("회원가입이 되었습니다.");
      location.href="${commonURL}/"; //시작화면으로 이동하기
   })
   .fail( (error)=>{
      console.log(error);
   })
  
	//서버로 전송하기 
	}
}

$(()=>{
    $("#btnDuplicate").click(()=>{
       $.ajax({
          url:"${commonURL}/member/isDuplicate", //요청 url정보
          data:{user_id:$("#user_id").val()},   //서버로 전달할 데이터정보: JSON형태
          dataType:"json",  //결과를 jSON으로 받겠다. 결과가 text로 온다
          type:"POST"
       })
       .done((data)=>{
          //데이터가 정상적으로 수신되면 done메서드 호출되면서 매개변수는 전달받은 값
          //값은 dataType 속성을 안주면 text로 온다.
          console.log(data.result);
         var frm = document.form;
         
         if( frm.user_id.value.trim()==""){
      		alert("아이디를 입력하세요");
      		frm.user_id.focus();
      		return false;
      		} 
         
      	 var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
       	 if (!idRegExp.test(frm.user_id.value.trim())) {
              alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
              form.user_id.value = "";
              form.user_id.focus();
              return false;
          }
         if(data.result == "true") //중복
         {
            alert("이미 사용중인 아이디입니다.");
         }
         else
         {
            alert("사용가능합니다.")
            $("#id_check").val("Y");
            $("#user_id").prop("readonly", true);   //수정못하게 막는 기능
            
         }
       })
       .fail((error)=>{
          //통신에러, 오류에 관한 것
             console.log(error)
       })
    })
 })

 


</script>