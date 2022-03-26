<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import = "com.semi.flix.notice.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
   <%@include file="../include/css.jsp" %>
   <title>Insert title here</title>
</head>
<body class="body">
<%@include file="../include/header.jsp" %>
   <%
      String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
      String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
   %>
<%
	HttpSession session1 = request.getSession();

	String id = (String) session1.getAttribute("id");
	String user_id = (String) session1.getAttribute("adminuserid");
	NoticeDTO dto = (NoticeDTO)request.getAttribute("notice");
	dto = dto == null ? new NoticeDTO():dto;

%>
<section class="section section--first section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg">
<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg" style="margin-top: 100px;">
      <div class="container">
         <div class="row">
            <div class="col-12">
               <<h1 class="home__title" style="margin-top: 100px"><b>공지사항 쓰기</b></h1>
             	  <br><br>
					<form class="sign__form" action="insertNotice.do" method="post" name="myform" style="width: 100%;">
					<input type="hidden" name="notice_seq" value = "<%=dto.getNotice_seq()%>"/>
					<input type="hidden" name="id" value = "<%=id%>"/>
					<input type="hidden" name="user_id" value = "<%=user_id%>"/>
	
					 <a href="${commonURL}/" class="sign__logo">
                        <img src="${commonURL}/resources/img/logoimg.png" alt="">
                     </a>
	
					 <div class="sign__group" style="width: 100%">
                        <input class="sign__qna" placeholder="제목을 입력하세요"  name="notice_title" type="text" value="${ notice_title }" />
                     </div>
                     <br>
                     <div class="sign__group" style="width: 100%">
                        <textarea class="sign__qna" placeholder="내용을 입력하세요"  name="notice_content" style="height: 300px; padding: 10px;">${ notice_content }</textarea>
                     </div>
                     <br>
   				     <div>
                     <button class="sign__btn" type="submit" onclick="location.href='go_insertNotice.do'" style="width:100px; height: 30px; margin:2px;  display: inline-block; ">글 등록</button>
                  
                     <button class="sign__btn" type="button" onclick="location.href='getNotice_List.do'" style="width:100px; height: 30px; margin:2px;  display: inline-block; ">글 목록 </button>
   				     </div>
                     
                     </form>
                  <!-- end authorization form -->
               </div>
            </div>
         </div>
      </div>
	<!-- <table border="1" cellpadding="0" cellspacing="0">
	    <tr>
	        <td width="70">제목</td><td align="left">
	        <input type="text" name="notice_title"/></td>
	    </tr>
	    <tr>
	        <td>내용</td><td align="left">
	        <textarea name="notice_content" cols="70" rows="23"></textarea></td>
	       
	    </tr>
	    <!-- <tr>
	        <td>조회수</td><td align="left">
	        <input type="text" name="q_a_hit" size="10"/></td>
	    </tr> 
	    
	    <tr>
	        <td colspan="2" align="center">
	        <input type="submit" value=" 새글 등록 "/></td>
	    </tr>
	</table>
	</form>
	<hr>
	<a href="getNotice_List.do">글 목록 가기</a>  -->
<%@include file="../include/footer.jsp" %>
</section>
</body>
</html>