<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.semi.flix.Q_A.*" %>
<%@page import="com.semi.flix.common.*" %>
<%@page import="com.semi.flix.admin.adminQ_A.*" %>
<%@page import="com.semi.flix.admin.admincomment.*" %>
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
	<%
		String key = StringUtil.nullToValue(request.getParameter("key"), "1");
		String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
		String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	%>
    
<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg" style="margin-top: 100px;">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
						<!-- authorization form -->
						<form class="sign__form" action="updateQ_A.do" method="post" name="myform" style="width: 100%;">
						<input name="q_a_seq" type="hidden" value="${ q_a.q_a_seq }" />
						
							<a href="${commonURL}/" class="sign__logo">
								<img src="${commonURL}/resources/img/logoimg.png" alt="">
							</a>

							<div class="price">
								<div class="price__item price__item--first"><h2>Q&A상세보기</h2> <span></span></div>
									<br>
									<div class="price__item"><span>제목</span>
									<input class="sign__qna__write "  name="q_a_title" type="text" value="${ q_a.q_a_title }" />
									</div>
									<br>
									<div class="price__item"><span>내용</span>
									<textarea class="sign__qna__write"  name="q_a_contents" style=" height: auto; padding: 10px 17px; height: 500px;">${ q_a.q_a_contents }</textarea>
									</div>
									<br>
									
									<div class="price__item"><span>작성일</span>
									<input class="sign__qna__write"  name="q_a_wdate" type="text" value="${ q_a.q_a_wdate }" readonly="readonly"/>
									</div>
									<br>
									<div class="price__item"><span>작성자</span>
									<input class="sign__qna__write" readonly="readonly"  name="user_id" type="text" value="${ q_a.user_id }" />
									</div>
									
							</div>
							
							

							
							<br>
							
							<div>
							
							<% 
	
							Q_A_DTO dto = (Q_A_DTO)request.getAttribute("q_a");
							if(userid.equals(dto.getUser_id())){%>
							
							<button class="sign__btn" type="button" id="btnDuplicate" onclick="goModify()"
								style="width:100px; height: 30px; margin:2px; display: inline-block; ">글 수정</button>
							<button class="sign__btn" type="button" 
							style="width:100px; height: 30px; margin:2px;  display: inline-block; "  onclick="location.href='deleteQ_A.do?q_a_seq=${ q_a.q_a_seq }'">글 삭제</button>
							
							<%} %> 
							
							<button class="sign__btn" type="button" 
							style="width:100px; height: 30px; margin:2px; display: inline-block;"  onclick="location.href='getQ_A_List.do'">글 목록</button>
							</div>
						<br>
						<br>
						
						<div class="price">
								<div class="price__item price__item--first"><h2>답변</h2> <span></span></div>
									
									<% 
									List<AdminCommentDto> list = (List)request.getAttribute("q_aList");
									for(AdminCommentDto dto2 : list){
									%>
									<br>
									<div class="price__item"><span>내용</span>
									<textarea class="sign__qna__write"   readonly="readonly" style=" height: auto; padding: 10px 17px; height: 150px;"><%=dto2.getContent()%></textarea>
									</div>
									<br>
									
									<div class="price__item"><span>작성일</span>
									<input class="sign__qna__write" type="text" readonly="readonly" value="<%=dto2.getWdate()%>"/>
									</div>
									<br>
									<%}%>
									
									
							</div>
						
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
function goModify(){
   document.myform.submit();
   alert("수정완료")
}
</script>


