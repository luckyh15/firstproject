<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.flix.common.*" %>
<%@page import="com.semi.flix.drama.*" %>
<%@page import="com.semi.flix.movie.*" %>
<%@page import="com.semi.flix.search.*" %>
<%@page import="com.semi.flix.webtoon.*" %>
<%@page import="com.semi.flix.animation.*" %>
<%@page import="com.semi.flix.member.*" %>
<%@page import="java.util.List"%>



<%
request.setAttribute("commonURL", request.getContextPath());
String userid= StringUtil.nullToValue(session.getAttribute("userid"), "");
String username= StringUtil.nullToValue(session.getAttribute("username"), "");
String userseq= StringUtil.nullToValue(session.getAttribute("userseq"), "");
String nickname= StringUtil.nullToValue(session.getAttribute("nickname"), "");
String userimage= StringUtil.nullToValue(session.getAttribute("userimage"), "");
String adminid= StringUtil.nullToValue(session.getAttribute("adminuserid"), "");
String key = StringUtil.nullToValue(request.getParameter("key"),"12");

%>

<meta charset="UTF-8"> 


<!-- header -->
	<header class="header">
	<form name="mypageForm" style="text-align: right;">
		<div class="header__wrap">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="header__content">
							<!-- header logo -->
							<a href="${commonURL}/" class="header__logo">
								<img src="${commonURL}/resources/img/logoimg.png" alt=""/>
							</a>
							<!-- end header logo -->

							<!-- header nav -->
							<ul class="header__nav">
							

								<li class="header__nav-item">
									<a href="${commonURL}/movie/list" class="header__nav-link">영화</a>
								</li>
								<li class="header__nav-item">
									<a href="${commonURL}/drama/list" class="header__nav-link">드라마</a>
								</li>
								<li class="header__nav-item">
									<a href="${commonURL}/enter/list"class="header__nav-link">예능</a>
								</li>

								<li class="header__nav-item">
									<a href="${commonURL}/animation/list" class="header__nav-link">애니메이션</a>
								</li>
								<li class="header__nav-item">
									<a href="${commonURL}/webtoon/list" class="header__nav-link">웹툰</a>
								</li>
							

								<!-- dropdown -->
								<li class="dropdown header__nav-item">
									<a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon ion-ios-more"></i></a>

									<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
										<li><a href="${commonURL}/getQ_A_List.do">Q&A</a></li> <!-- list,view작업 안됨 -->
										<li><a href="${commonURL}/getNotice_List.do">공지사항</a></li> <!-- list,view작업 안됨 -->
									
										<li><a href="${commonURL}/admin/adminindex">관리자페이지</a></li>
										
									</ul>
								</li>
								<!-- end dropdown -->
							</ul>
							<!-- end header nav -->
							<%if(userid.equals("")) {%>
							<!-- header auth -->

							<div class="header__auth">
								<button class="header__search-btn" type="button">
									<i class="icon ion-ios-search"></i>
								</button>

								<a class="header__sign-in" href="${commonURL}/member/signin">
									<i class="icon ion-ios-log-in"></i>
									<span>sign in</span>
								</a>
							</div>
							<!-- end header auth -->
							<%}else{%>
								<input type="hidden" id="user_id" name="user_id" value=""> 
								<div class="header__auth">
											<button class="header__search-btn" type="button" >
												<i class="icon ion-ios-search" style="margin-top: 60px;"></i>
											</button>
								
										
										<ul style="text-align:center;">
										<li class="dropdown header__nav-item">
											<a style = "width : auto; height: auto;"class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											<img class="profile" alt="" src="${commonURL}/upload/<%=userimage%>" style="margin-right: 20px; display: inline;"/>
											<strong style="font-size: 17px"><%=nickname %></strong> 님 반갑습니다
											</a>

											<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
												<li><a href="#" onclick="goMypage('<%=userid%>')">마이페이지</a></li>
												<li><a href="${commonURL}/member/logout">로그아웃</a></li>
												
						
											</ul>
										</li>
										</ul>
										</div>
					
							
							
							<% } %>


							<!-- header menu btn -->
							<button class="header__btn" type="button">
								<span></span>
								<span></span>
								<span></span>
							</button>
							<!-- end header menu btn -->
						</div>
					</div>
				</div>
			</div>
		</div>

  </form> 
		<!-- header search -->
      <form action="${commonURL}/search/search_list" class="header__search">
         <div class="container">
            <div class="row">
               <div class="col-12">
                  <div class="header__search-content">
                  
                     <input type="text" placeholder="제목, 감독, 콘텐츠를 검색해보세요." name="keyword" id="keyword" aria-label="Search">
                     <button type="button" name="btnSearch" id="btnSearch">search</button>
                  </div>
               </div>
            </div>	
         </div>
      </form>
      <!-- end header search -->
   </header>
   <!-- end header -->
   
   <script>
   
   $(document).on('click', '#btnSearch', function(e){

      e.preventDefault();
      var url = "${commonURL}/search/search_list";
      url = url + "?keyword=" + $('#keyword').val() + "&headerKey=5";
      location.href = url;
      console.log(url);
   });
   
   


    /*
    $("#keyword").autocomplete({
        source : function(request, response) {
            $.ajax({
                  url : "${commonURL}/search/keyword_list"
                , type : "GET"
                , data : {keyword : $("#keyword").val()} // 검색 키워드
                , success : function(data){ // 성공
                    response(
                        $.map(data, function(item) {
                            return {
                                  label : item.title    //목록에 표시되는 값
                                , value : item.title    //선택 시 input창에 표시되는 값
                            };
                        })
                    );    //response
                }
                ,
                error : function(){ //실패
                    alert("통신에 실패했습니다.");
                }
            });
        }
        , minLength : 1    
        , autoFocus : false    
        , select : function(evt, ui) {
            console.log("전체 data: " + JSON.stringify(ui));
            console.log("db Index : " + ui.item.idx);
            console.log("검색 데이터 : " + ui.item.value);
        }
        , focus : function(evt, ui) {
            return false;
        }
        , close : function(evt) {
        }
    });*/
 
</script>