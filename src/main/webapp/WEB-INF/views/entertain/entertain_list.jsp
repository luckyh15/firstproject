<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.semi.flix.enter.EnterDto"%>
<%@page import="com.semi.flix.common.Pager"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.flix.common.StringUtil"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<%@include file="../include/css.jsp" %>
	<title>FlixPedia – Online Movies, TV Shows & Cinema HTML Template</title>
</head>
<body class="body">
	<%
	String keyword = StringUtil.nullToValue(request.getParameter("keyword"), "");
	String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	int totalCnt = (Integer)request.getAttribute("totalCnt");
		
	List<EnterDto> list =(List<EnterDto>)request.getAttribute("enterList");
	%>
	<%@include file="../include/header.jsp" %>

		
	

	<!-- page title -->
	<section class="section section--first section--bg" data-bg="<%=request.getContextPath()%>/resources/img/section/section.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section__wrap">
						<!-- section title -->
						<h2 class="section__title">예능(${totalCnt}건)</h2>
						<!-- end section title -->

						<!-- breadcrumb -->
						
						<!-- end breadcrumb -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end page title -->
<form name="myform" method="get">
	<input type="hidden" name="pg"  id="pg" value="<%=pg%>"/>
	<input type="hidden" name="key" id="key" value="<%=key%>"/>
	<input type="hidden" name="board_seq"  id="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<input type="hidden" name="user_seq"  id="user_seq" value="<%=userseq%>"/>
		<!-- filter -->
		<div class="filter">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="filter__content">
							<div class="filter__items">
								<!-- filter item -->
								<div class="filter__item" id="filter__genre">
									<span class="filter__item-label">GENRE:</span>
	
									<div class="filter__item-btn dropdown-toggle" role="navigation" id="filter-genre" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<input type="button" value="" id="searchItem">
										
									</div>
	
									<ul class="filter__item-menu dropdown-menu scrollbar-dropdown" aria-labelledby="filter-genre">
										
										<li><a onclick="changeSearch('12')">전체</a></li>
											<li><a onclick="changeSearch('0')">Action</a></li>
											<li><a onclick="changeSearch('1')">Romance</a></li>
											<li><a onclick="changeSearch('2')">Comedy</a></li>
											<li><a onclick="changeSearch('3')">Thriller/Crime</a></li>
											<li><a onclick="changeSearch('4')">Horror</a></li>
											<li><a onclick="changeSearch('5')">Fantasy</a></li>
											<li><a onclick="changeSearch('6')">Drama</a></li>
											<li><a onclick="changeSearch('7')">Animation</a></li>
											<li><a onclick="changeSearch('8')">Action/Adventure</a></li>
											<li><a onclick="changeSearch('9')">Mystery</a></li>
											<li><a onclick="changeSearch('10')">History</a></li>
											<li><a onclick="changeSearch('11')">Sports</a></li>
														
									</ul>
									<!-- <button class="sign__btn" type="button" onclick="goSearch()" 
											style="width:100px; height: 30px; margin:2px;">검색</button> -->
								</div>
								<!-- end filter item -->
	
								<!-- filter item -->
								
							</div>
							
							<!-- filter btn -->
							<button class="filter__btn" type="button" onclick="goSearch()">apply filter</button>
							<!-- end filter btn -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end filter -->
	
		<!-- catalog -->
		<div class="catalog">
			<div class="container">
				<div class="row">
					<!-- card -->
					
					
					<%
						for(EnterDto dto : list){
					%>
					<div class="col-6 col-sm-4 col-lg-3 col-xl-2">
						<div class="card">
							<div class="card__cover">
							
								<img src="../upload/<%=dto.getEnter_images() %>" style="height: 230px;object-fit: cover;">
								<a href="#" class="card__play" onclick="goView('<%=dto.getBoard_seq()%>')"></a>
							
								
							</div>
							<div class="card__content">
							
								<h3 class="card__title"><a href="#" onclick="goView('<%=dto.getBoard_seq()%>')"><%=dto.getEnter_title() %></a></h3>
								<span class="card__category">

								<%
								if(dto.getGenre_code().equals("00")){ %>
								<a href="#">Action</a>
								<%}else if(dto.getGenre_code().equals("01")){ %>
								<a href="#">Romantic</a>
								<%}else if(dto.getGenre_code().equals("02")){ %>
								<a href="#">Comedy</a>
								<%}else if(dto.getGenre_code().equals("03")){ %>
								<a href="#">Thliler/Criminal</a>
								<%}else if(dto.getGenre_code().equals("04")){ %>
								<a href="#">Horror</a>
								<%}else if(dto.getGenre_code().equals("05")){ %>
								<a href="#">SF/Fantasy</a>
								<%}else if(dto.getGenre_code().equals("06")){ %>
								<a href="#">Drama</a>
								<%}else if(dto.getGenre_code().equals("07")){ %>
								<a href="#">Animation</a>
								<%}else if(dto.getGenre_code().equals("08")){ %>
								<a href="#">Action/Adventure</a>
								<%}else if(dto.getGenre_code().equals("09")){ %>
								<a href="#">Mystery</a>
								<%}else if(dto.getGenre_code().equals("10")){ %>
								<a href="#">History</a>
								<%}else if(dto.getGenre_code().equals("11")){ %>
								<a href="#">Sports</a>
								<%}%>
									
								</span>
								<span class="card__rate" id="star_point"><i class="icon ion-ios-star"><%=dto.getStar_avg() %></i></span>
							</div>
						</div>
					</div>
					<%} %>
					<!-- end card -->
	
				
	
					<!-- paginator -->
					
					<div class="col-12">
						<%=Pager.makeTag(request, 12, totalCnt) %>
					</div>
					<!-- end paginator -->
				</div>
			</div>
		</div>
		<!-- end catalog -->
</form>
	

	
	 <%@include file="../include/footer.jsp" %>
		<!-- JS -->

</body>
</html>
<script>
window.onload=function(){
	let key = '<%=key%>';
	var texts=["Action", "Romance", "Comedy", "Thriller/Crime", "Horror","Fantasy","Drama","animation","Action/Adventure",
		"Mystery","History","Sports","전체"];
	
	document.getElementById("searchItem").value=texts[key];
}


function changeSearch(id)
{
	var texts=["Action", "Romance", "Comedy", "Thriller/Crime", "Horror","Fantasy","Drama","animation","Action/Adventure",
		"Mystery","History","Sports","전체"];
	document.getElementById("searchItem").value=texts[id]; //화면에 보이기 위해서 
	document.getElementById("key").value=id;//컨트롤러로 넘기기 위해서
	
}

function goSearch(){
	let frm = document.myform;
	frm.pg.value=0;
	frm.action = "<%=request.getContextPath()%>/enter/list";
	frm.method="get";
	frm.submit();
}

function goView(id)
{
	frm = document.myform;
	frm.board_seq.value=id;///////////
	frm.category_code.value="02";///////////
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/enter/view";
	frm.submit();
}

function goPage(pg)
{
	frm = document.myform;
	frm.pg.value=pg;///////////
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/enter/list";
	frm.submit();
}




</script>