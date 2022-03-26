<%@page import="com.semi.flix.notice.NoticeDTO"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="com.semi.flix.Q_A.*" %>
<%@page import="com.semi.flix.common.*" %>
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
HttpSession session1 = request.getSession();
String id = (String) session1.getAttribute("id");
%>
	<%-- <%
		String key = StringUtil.nullToValue(request.getParameter("key"), "1");
		String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
		String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	%> --%>
	
	
	<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg" style="margin-top: 100px;">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
<form class="sign__form" action="updateNotice.do" method="post" name="myform" style="width: 100%;">
					
			<input name="notice_seq" type="hidden" value="${ notice.notice_seq }" />
	<a href="${commonURL}/" class="sign__logo">
	<img src="${commonURL}/resources/img/logoimg.png" alt="">
							</a>
							
			<div class="price">
			<div class="price__item price__item--first"><h2>공지 사항 상세보기</h2> <span></span></div>
									<br>
									<div class="price__item"><span>제목</span>
									<input class="sign__qna__write "  name="notice_title" type="text" value="${ notice.notice_title }" />
									</div>
									<br>
									<div class="price__item"><span>내용</span>
									<textarea class="sign__qna__write"  name="notice_content" style=" height: auto; padding: 10px 17px; height: 500px;">${ notice.notice_content }</textarea>
									</div>
									<br>
									
									<div class="price__item"><span>작성일</span>
									<input class="sign__qna__write"  name="wdate" type="text" value="${ notice.wdate }" readonly="readonly"/>
									</div>
									<br>
									<div class="price__item"><span>작성자</span>
									<input class="sign__qna__write" readonly="readonly"  name="user_id" type="text" value="${ notice.user_id }" />
									</div>
									
			
			
			

				
				
				
				
		
				
				

				<%-- <input name="member_id" type="hidden" value="${ Member_ID }" /> --%>


				
			
	</div>
		
		<div>
		<button class="sign__btn" type="button" 
							style="width:100px; height: 30px; margin:2px; display: inline-block;"  onclick="location.href='getQ_A_List.do'">글 목록</button>
							</div>
		
		<% 
	
		NoticeDTO dto = (NoticeDTO)request.getAttribute("notice");
		System.out.print("----------------2--------------");
		//System.out.println(dto.getUser_id());
		if(userid.equals(dto.getUser_id())){%>
		
		<a href="deleteNotice.do?notice_seq=${ notice.notice_seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getNotice_List.do">글 목록</a>
		<a href="#" onclick="javascript:document.myform.submit();">글 수정</a>
		
		<%} %>
		
    </form>
	</div>
				</div>
			</div>
		</div>
	</div>
</body>
	<%@include file="../include/footer.jsp" %>
</html>

<script>
function goModify(){
	document.myform.submit();
}
</script>





