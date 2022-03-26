<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.semi.flix.drama.*" %>
<%@page import="com.semi.flix.webtoon.*" %>
<%@page import="com.semi.flix.animation.*" %>
<%@page import="com.semi.flix.enter.*" %>
<%@page import="com.semi.flix.movie.*" %>
<%@page import="java.util.*"%>

<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file="include/css.jsp" %> 
</head>
<body class="body">
	<!-- header -->
	<%@include file="include/header.jsp" %>

	
	<%
		List<DramaDto> dramaList =(List<DramaDto>)request.getAttribute("dramaList"); 
			dramaList = dramaList==null ? new ArrayList<DramaDto>() : dramaList;
			
			List<MovieDto> movieList =(List<MovieDto>)request.getAttribute("movieList");
			movieList = movieList==null ? new ArrayList<MovieDto>() : movieList;
			
			List<WebtoonDto> webtoonList =(List<WebtoonDto>)request.getAttribute("webtoonList");
			webtoonList = webtoonList==null ? new ArrayList<WebtoonDto>() : webtoonList;
			
			List<AnimationDto> aniList =(List<AnimationDto>)request.getAttribute("aniList");
			aniList = aniList==null ? new ArrayList<AnimationDto>() : aniList;
			
			List<EnterDto> enterList =(List<EnterDto>)request.getAttribute("enterList");
			enterList = enterList==null ? new ArrayList<EnterDto>() : enterList;
		%>

<!-- **************************************************영화 카졸********************************************************** -->
<form id="movieForm" name="movieForm" >
	<input type="hidden" name="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<section class="movie" style="margin-top:0px; padding-top: 50px;">
		<!-- 카졸 백그라운드 이미지 movie bg -->
		<div class="owl-carousel movie__bg">
			<div class="item movie__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg.jpg"></div>
			<div class="item movie__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg2.jpg"></div>
			<div class="item movie__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg3.jpg"></div>
			<div class="item movie__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg4.jpg"></div>
		</div>
		<!-- 카졸 백그라운드 이미지 끝end drama bg -->

		<!-- movie carousel move-->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="movie__title" style="margin-top:70px"><a href="${commonURL}/movie/list" style="color:white;"><b> 영화 </b>TOP10</a></h1>
					<button class="movie__nav movie__nav--prev" style="margin-top:20px" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="movie__nav movie__nav--next" style="margin-top:20px" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>
				<div class="col-12">
					<div class="owl-carousel movie__carousel">
				<!-- movie 카졸 move end-->
							
				<%
											for(MovieDto tempDto: movieList){
											%>
						<div class="item" style="width: 255px; margin-right: 80px;">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover" onclick="goMovieView('<%=tempDto.getBoard_seq()%>')">
									<img src="upload/<%=tempDto.getMovie_images()%>" alt="" style="height: 320px;object-fit: cover;">
									<a href="#" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title" onclick="goMovieView('<%=tempDto.getBoard_seq()%>')"><a href="#"><%=tempDto.getMovie_title()%></a></h3>
									<span class="card__category">
										<%
								if(tempDto.getGenre_code().equals("00")){ %>
									<a href="#">Action</a>
									<%}else if(tempDto.getGenre_code().equals("01")){ %>
									<a href="#">Romantic</a>
									<%}else if(tempDto.getGenre_code().equals("02")){ %>
									<a href="#">Comedy</a>
									<%}else if(tempDto.getGenre_code().equals("03")){ %>
									<a href="#">Thliler/Criminal</a>
									<%}else if(tempDto.getGenre_code().equals("04")){ %>
									<a href="#">Horror</a>
									<%}else if(tempDto.getGenre_code().equals("05")){ %>
									<a href="#">SF/Fantasy</a>
									<%}else if(tempDto.getGenre_code().equals("06")){ %>
									<a href="#">Drama</a>
									<%}else if(tempDto.getGenre_code().equals("07")){ %>
									<a href="#">Animation</a>
									<%}else if(tempDto.getGenre_code().equals("08")){ %>
									<a href="#">Action/Adventure</a>
									<%}else if(tempDto.getGenre_code().equals("09")){ %>
									<a href="#">Mystery</a>
									<%}%>
										
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"></i><%=tempDto.getStar_avg()%></span>
								</div>
							</div>
						</div>
						<!-- end card -->
				<%
				}
				%>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>

<!-- **************************************************영화 카졸 끝********************************************************** -->

<!-- *************************************************드라마 카졸 시작********************************************************** -->
	<form id="dramaForm" name="dramaForm" >
	<input type="hidden" name="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<section class="drama" style="margin-top:0px; padding-top: 50px;">
		<!-- 카졸 백그라운드 이미지 drama bg -->
		<div class="owl-carousel drama__bg">
			<div class="item drama__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg.jpg"></div>
			<div class="item drama__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg2.jpg"></div>
			<div class="item drama__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg3.jpg"></div>
			<div class="item drama__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg4.jpg"></div>
		</div>
		<!-- 카졸 백그라운드 이미지 끝end drama bg -->


		<!-- drama 카졸 move-->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="drama__title"><a href="${commonURL}/drama/list" style="color:white;"><b>드라마</b> TOP10</a></h1>
					<button class="drama__nav drama__nav--prev" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="drama__nav drama__nav--next" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>
				<div class="col-12">
					<div class="owl-carousel drama__carousel">
				<!-- drama 카졸 move end-->
							
				<%
					for(DramaDto tempDto: dramaList){
										%>
						<div class="item" style="width: 255px; margin-right: 80px;">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover" onclick="goDramaView('<%=tempDto.getBoard_seq()%>')">
									<img src="upload/<%=tempDto.getDrama_images()%>" alt="" style="height: 320px;object-fit: cover;">
									<a href="#" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title" onclick="goDramaView('<%=tempDto.getBoard_seq()%>')"><a href="#"><%=tempDto.getDrama_title()%></a></h3>
									<span class="card__category">
										<%
								if(tempDto.getGenre_code().equals("00")){ %>
									<a href="#">Action</a>
									<%}else if(tempDto.getGenre_code().equals("01")){ %>
									<a href="#">Romantic</a>
									<%}else if(tempDto.getGenre_code().equals("02")){ %>
									<a href="#">Comedy</a>
									<%}else if(tempDto.getGenre_code().equals("03")){ %>
									<a href="#">Thliler/Criminal</a>
									<%}else if(tempDto.getGenre_code().equals("04")){ %>
									<a href="#">Horror</a>
									<%}else if(tempDto.getGenre_code().equals("05")){ %>
									<a href="#">SF/Fantasy</a>
									<%}else if(tempDto.getGenre_code().equals("06")){ %>
									<a href="#">Drama</a>
									<%}else if(tempDto.getGenre_code().equals("07")){ %>
									<a href="#">Animation</a>
									<%}else if(tempDto.getGenre_code().equals("08")){ %>
									<a href="#">Action/Adventure</a>
									<%}else if(tempDto.getGenre_code().equals("09")){ %>
									<a href="#">Mystery</a>
									<%}%>
										
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"></i><%=tempDto.getStar_avg()%></span>
								</div>
							</div>
						</div>
						<!-- end card -->
				<%
				}
				%>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>
	<!-- drama 카졸 끝 end  -->
<!-- ************************************************드라마 카졸 끝************************************************************ -->


<!-- ************************************************enter 카졸************************************************************ -->
	<form id="enterForm" name="enterForm" >
	<input type="hidden" name="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<section class="enter" style="margin-top:0px; padding-top: 50px;">
		<!-- 카졸 백그라운드 이미지 enter bg -->
		<div class="owl-carousel enter__bg">
			<div class="item enter__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg.jpg"></div>
			<div class="item enter__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg2.jpg"></div>
			<div class="item enter__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg3.jpg"></div>
			<div class="item enter__cover" data-bg="<%=request.getContextPath()%>/resources/img/home/home__bg4.jpg"></div>
		</div>
		<!-- 카졸 백그라운드 이미지 끝end enter bg -->


		<!-- enter 카졸 move-->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="enter__title"><a href="${commonURL}/enter/list" style="color:white;"><b>예능</b> Top10</a></h1>
					<button class="enter__nav enter__nav--prev" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="enter__nav enter__nav--next" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>
				<div class="col-12">
					<div class="owl-carousel enter__carousel">
				<!-- enter 카졸 move end-->
							
				<%
					for(EnterDto tempDto: enterList){
						
										%>
						<div class="item" style="width: 255px; margin-right: 80px;">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover" onclick="goEnterView('<%=tempDto.getBoard_seq()%>')">
									<img src="upload/<%=tempDto.getEnter_images()%>" alt="" style="height: 320px;object-fit: cover;">
									<a href="#" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title" onclick="goEnterView('<%=tempDto.getBoard_seq()%>')"><a href="#"><%=tempDto.getEnter_title()%></a></h3>
									<span class="card__category">
										<%
								if(tempDto.getGenre_code().equals("00")){ %>
									<a href="#">Action</a>
									<%}else if(tempDto.getGenre_code().equals("01")){ %>
									<a href="#">Romantic</a>
									<%}else if(tempDto.getGenre_code().equals("02")){ %>
									<a href="#">Comedy</a>
									<%}else if(tempDto.getGenre_code().equals("03")){ %>
									<a href="#">Thliler/Criminal</a>
									<%}else if(tempDto.getGenre_code().equals("04")){ %>
									<a href="#">Horror</a>
									<%}else if(tempDto.getGenre_code().equals("05")){ %>
									<a href="#">SF/Fantasy</a>
									<%}else if(tempDto.getGenre_code().equals("06")){ %>
									<a href="#">Drama</a>
									<%}else if(tempDto.getGenre_code().equals("07")){ %>
									<a href="#">Animation</a>
									<%}else if(tempDto.getGenre_code().equals("08")){ %>
									<a href="#">Action/Adventure</a>
									<%}else if(tempDto.getGenre_code().equals("09")){ %>
									<a href="#">Mystery</a>
									<%}%>
										
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"></i><%=tempDto.getStar_avg()%></span>
								</div>
							</div>
						</div>
						<!-- end card -->
				<%
				}
				%>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>
	<!-- enter 카졸 끝 end  -->
<!-- ************************************************예능 카졸 끝************************************************************ -->

<!-- ************************************************ 애니 카졸 시작 ************************************************************ -->
	<form id="aniForm" name="aniForm" >
	<input type="hidden" name="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<section class="ani" style="margin-top:0px; padding-top: 50px;">
		<!-- 카졸 백그라운드 이미지 ani bg -->
		<div class="owl-carousel ani__bg">
			<div class="item ani__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg.jpg"></div>
			<div class="item ani__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg2.jpg"></div>
			<div class="item ani__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg3.jpg"></div>
			<div class="item ani__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg4.jpg"></div>
		</div>
		<!-- 카졸 백그라운드 이미지 끝end ani bg -->


		<!-- ani 카졸 move-->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="ani__title"><a href="${commonURL}/animation/list" style="color:white;"><b>애니메이션</b> Top10</a></h1>
					<button class="ani__nav ani__nav--prev" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="ani__nav ani__nav--next" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>
				<div class="col-12">
					<div class="owl-carousel ani__carousel">
				<!-- ani 카졸 move end-->
							
				<%						
					for(AnimationDto tempDto: aniList){
				%>
						<div class="item" style="width: 255px; margin-right: 80px;">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover" onclick="goAniView('<%=tempDto.getBoard_seq()%>')">
									<img src="upload/<%=tempDto.getAni_images()%>" alt="" style="height: 320px;object-fit: cover;">
									<a href="#" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title" onclick="goAniView('<%=tempDto.getBoard_seq()%>')"><a href="#"><%=tempDto.getAni_title() %></a></h3>
									<span class="card__category">
										<%
								if(tempDto.getGenre_code().equals("00")){ %>
									<a href="#">Action</a>
									<%}else if(tempDto.getGenre_code().equals("01")){ %>
									<a href="#">Romantic</a>
									<%}else if(tempDto.getGenre_code().equals("02")){ %>
									<a href="#">Comedy</a>
									<%}else if(tempDto.getGenre_code().equals("03")){ %>
									<a href="#">Thliler/Criminal</a>
									<%}else if(tempDto.getGenre_code().equals("04")){ %>
									<a href="#">Horror</a>
									<%}else if(tempDto.getGenre_code().equals("05")){ %>
									<a href="#">SF/Fantasy</a>
									<%}else if(tempDto.getGenre_code().equals("06")){ %>
									<a href="#">Drama</a>
									<%}else if(tempDto.getGenre_code().equals("07")){ %>
									<a href="#">Animation</a>
									<%}else if(tempDto.getGenre_code().equals("08")){ %>
									<a href="#">Action/Adventure</a>
									<%}else if(tempDto.getGenre_code().equals("09")){ %>
									<a href="#">Mystery</a>
									<%}%>
										
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"></i><%=tempDto.getStar_avg() %></span>
								</div>
							</div>
						</div>
						<!-- end card -->
				<%
					}
				%>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>
	<!-- ************************************************ 애니 카졸 끝 ************************************************************ -->
	
	<!-- ************************************************ 웹툰 카졸 ************************************************************ -->
	<form id="webtoonForm" name="webtoonForm" >
	<input type="hidden" name="board_seq" value=""/>
	<input type="hidden" name="category_code"  id="category_code" value=""/>
	<section class="webtoon" style="margin-top:0px; padding-top: 50px;">
		<!-- 카졸 백그라운드 이미지 webtoon bg -->
		<div class="owl-carousel webtoon__bg">
			<div class="item webtoon__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg.jpg"></div>
			<div class="item webtoon__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg2.jpg"></div>
			<div class="item webtoon__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg3.jpg"></div>
			<div class="item webtoon__cover" data-bg="<%=request.getContextPath() %>/resources/img/home/home__bg4.jpg"></div>
		</div>
		<!-- 카졸 백그라운드 이미지 끝end webtoon bg -->


		<!-- webtoon 카졸 move-->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="webtoon__title"><a href="${commonURL}/webtoon/list" style="color:white;"><b>웹툰</b> Top10</a></h1>
					<button class="webtoon__nav webtoon__nav--prev" type="button">
						<i class="icon ion-ios-arrow-round-back"></i>
					</button>
					<button class="webtoon__nav webtoon__nav--next" type="button">
						<i class="icon ion-ios-arrow-round-forward"></i>
					</button>
				</div>
				<div class="col-12">
					<div class="owl-carousel webtoon__carousel">
				<!-- webtoon 카졸 move end-->
							
				<%						
					for(WebtoonDto tempDto: webtoonList){
				%>
						<div class="item" style="width: 255px; margin-right: 80px;">
							<!-- card -->
							<div class="card card--big">
								<div class="card__cover" onclick="goToonView('<%=tempDto.getBoard_seq()%>')">
									<img src="upload/<%=tempDto.getToon_images()%>" alt="" style="height: 320px;object-fit: cover;">
									<a href="#" class="card__play">
										<i class="icon ion-ios-play"></i>
									</a>
								</div>
								<div class="card__content">
									<h3 class="card__title" onclick="goToonView('<%=tempDto.getBoard_seq()%>')"><a href="#"><%=tempDto.getToon_title() %></a></h3>
									<span class="card__category">
										<%
									if(tempDto.getGenre_code().equals("00")){ %>
										<a href="#">Action</a>
										<%}else if(tempDto.getGenre_code().equals("01")){ %>
										<a href="#">Romantic</a>
										<%}else if(tempDto.getGenre_code().equals("02")){ %>
										<a href="#">Comedy</a>
										<%}else if(tempDto.getGenre_code().equals("03")){ %>
										<a href="#">Thliler/Criminal</a>
										<%}else if(tempDto.getGenre_code().equals("04")){ %>
										<a href="#">Horror</a>
										<%}else if(tempDto.getGenre_code().equals("05")){ %>
										<a href="#">SF/Fantasy</a>
										<%}else if(tempDto.getGenre_code().equals("06")){ %>
										<a href="#">Drama</a>
										<%}else if(tempDto.getGenre_code().equals("07")){ %>
										<a href="#">Animation</a>
										<%}else if(tempDto.getGenre_code().equals("08")){ %>
										<a href="#">Action/Adventure</a>
										<%}else if(tempDto.getGenre_code().equals("09")){ %>
										<a href="#">Mystery</a>
										<%}%>
										
									</span>
									<span class="card__rate"><i class="icon ion-ios-star"></i><%=tempDto.getStar_avg() %></span>
								</div>
							</div>
						</div>
						<!-- end card -->
				<%
					}
				%>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>
	<!-- ************************************************ 웹툰 카졸 끝 ************************************************************ -->
		
	
<%@include file="include/footer.jsp" %>
</body>

</html>

<script>

function goMovieView(seq){
	let frm = document.movieForm;
	frm.board_seq.value=seq;///////////
	frm.category_code.value="00";
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/movie/view";
	frm.submit();
}

function goDramaView(seq){
	let frm = document.dramaForm;
	frm.board_seq.value=seq;///////////
	frm.category_code.value="01";
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/drama/view";
	frm.submit();
}

function goEnterView(seq){
	let frm = document.enterForm;
	frm.board_seq.value=seq;///////////
	frm.category_code.value="02";
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/enter/view";
	frm.submit();
}



function goAniView(seq){
	let frm = document.aniform;
	frm.board_seq.value=seq;///////////
	frm.category_code.value="03";
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/animaiton/view";
	frm.submit();
}

function goToonView(seq){
	let frm = document.webtoonForm;
	frm.board_seq.value=seq;///////////
	frm.category_code.value="04";
	frm.method="get";
	frm.action="${pageContext.request.contextPath}/webtoon/view";
	frm.submit();
}


</script>