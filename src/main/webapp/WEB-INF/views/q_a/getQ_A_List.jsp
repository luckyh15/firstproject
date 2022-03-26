<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.semi.flix.Q_A.*" %>
<%@page import="com.semi.flix.common.*" %>
<%@page import="com.semi.flix.admin.adminQ_A.*" %>
<%@page import="com.semi.flix.admin.admincomment.*" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	
	<%@include file="../include/css.jsp" %>
	<title>FlixPedia – Online Movies, TV Shows & Cinema HTML Template</title>

</head>
<body class="body">
	<%
		String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
		String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	%>
	
	<%@include file="../include/header.jsp" %>

	<section class="home">
		<!-- 카졸 백그라운드 이미지 home bg -->
		
		<!-- 카졸 백그라운드 이미지 끝end home bg -->

		<!-- 카졸 내용-->
		
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="home__title"><b>Q&A</b></h1>
					
				</div>
			</div>
		</div>
		<br>
		<br>		
		<!--========================================================= accordion ============================================================-->
		<div class="container">
		<div class="row">
		<div class="col-12">
		<div class="sign__form">
		
				
					<div class="qa2_accordion" id="qa2_accordion" >
						<div class="qa2_accordion__card">
							<div class="qa2_card-header" id="headingOne">
								</div>
							
							<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="qa2_card-body">
									<table class="qa2_accordion__list">
										<thead>
											<tr>
												<th>글번호</th>
												<th>제목</th>
												<th>등록일</th>
												<th>아이디</th>
											</tr>
										</thead>
			
										<tbody>
											<c:forEach items="${q_a_List}" var="q_a">
												<tr>
													<td>${ q_a.q_a_seq }</td>
												<c:choose>
													<c:when test="${q_a.user_id eq sessionScope.userid}">
														
														<td align="left"><a	href="getQ_A.do?q_a_seq=${ q_a.q_a_seq }">
														 ${ q_a.q_a_title }</a></td>
														 
													<td>${q_a.user_id  }</td>
													</c:when>
													<c:otherwise>
													<td align="left">
													비밀글</td>
													</c:otherwise>
												</c:choose>
										
												
												
													
												<td><fmt:formatDate value="${ q_a.q_a_wdate }" pattern="yyyy-MM-dd" /></td>
													<td>${q_a.user_id  }</td>
											
												</tr>
											</c:forEach>
										</tbody>
									</table>
									
								</div>
							</div>
						</div>
					
					</div>
				
							
		</div>
		</div>
		</div>
									<div class="card__description">
						
									<button class="sign__btn" type="button" id="qnaWrite" 
										style="width:100px; height: 30px; margin:2px; float: right;">글쓰기</button>
									
									</div>
		</div>
		<!--========================================================= end accordion ==============================================================-->
	</section>
	<!-- ********************************************************카졸 끝 end home ***************************************************-->


	

	

 <%@include file="../include/footer.jsp" %>

	
</body>

</html>
<script>
$(document).on('click', '#qnaWrite', function(e){

    e.preventDefault();
    var url = "${commonURL}/go_insertQ_A.do";

    location.href = url;
    console.log(url);
 });
</script>