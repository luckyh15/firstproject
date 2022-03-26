package com.semi.flix.common;


import javax.servlet.http.HttpServletRequest;

//  <%=Pager.makeTag(request, 10, 32)%>


public class Pager {
		
	
	//<a href= .....
	public static String makeTag(HttpServletRequest request , int pageSize , int total) {
		
		//request 객체가 있어야 pg, key, keyword 등의 정보를 가져올 수 있다 
		//pageSize -  한 페이지당 출력할 데이터 개수 
		//total -  전체데이개수 
		//페이지숫자 - total/pageSize    12/10 -> 강제올림함수 ceil함수(1.2 -> 2
		
		String Tag = "" ; 
		String contextPath = request.getContextPath();
		
		// << < 1 2 3 4 5 6 7 8 9 10 > >> 
		
		int cpage; //현재페이지 정보 - board/list?pg=1  pg 값을   cpage로 처리한다
		// 12/10 -> ceiling(1.2) -> 2   
		int pageTotal; //전체 페이지 개수 
		int pageGroupSize = 5; //그룹의 개수 - 한 화면에 나타낼 페이지 최대 개수
		
		//1 ~ 5
		//6 ~ 10
		//11 ~ 15
		int pageGroupStart; //1,6,11,16,... 그룹의 시작값 
		int pageGroupEnd;   //5,10,15,....  그룹의 종료값

		String path="";
		//System.out.println(path);
		String beginLabel 	= "<<";//image  태그
		String prevLabel 	= "previous"; 
		String nextLabel 	= "next";
		String endLabel 	= ">>";	

		
		try {

			StringBuffer sb = new StringBuffer();
			
			//http://localhost:9000/myhome/freeboard.do?pg=1
			
			String page = request.getParameter("pg"); // /board/list?pg=1
			page = ( page == null ) ? "0" : page;  //null揶쏉옙 筌ｌ꼶�봺  
			

			cpage = Integer.parseInt(page) ; 

			pageTotal = (int)Math.ceil((total - 1) / pageSize);
			//페지지 개수 : 전체 데이터 개수 123개 
			//한 페이지당 10개씩 : pageSize=10
			// 123/10 -> 12.3 =>  올림 => 13
            
			// 17 /5 - 3 *5  15    20 
			pageGroupStart = (int) (cpage / pageGroupSize) * pageGroupSize;
			pageGroupEnd = pageGroupStart + pageGroupSize;
			
		
			if (pageGroupEnd > pageTotal) {
				pageGroupEnd = pageTotal + 1;
			}
            //0~4, 5~9, 10~14, 15~19
				 
			boolean hasPreviousPage = cpage - pageGroupSize >= 0;
			//이전페이지로 갈게 있는가 여부  << < 1 2 3 4 5 > >>
			boolean hasNextPage = pageGroupStart + pageGroupSize < pageTotal;
			//다음페이지로 갈 수 있는가 여부 
			
			sb.append("<ul class='paginator'>\r\n") ;  
			
			//  <<  < 
			//처음으로
			 sb.append((cpage > 0) ? makeLink(0, beginLabel) :
			  "<li class='paginator__item paginator__item--prev'><a href=\"javascript:alert('"+"첫번째 페이지 입니다"+"')\">"+beginLabel+"</a></li>\r\n"
			 );
			 //뒤로가기 화살표
			sb.append(hasPreviousPage ? makeLink(pageGroupStart - 1, prevLabel) :
				(cpage==0 ? 
				 "<li class='paginator__item paginator__item--prev'><a href=\"javascript:alert('"+"첫번째페이지 입니다"+"')\"><i class='icon ion-ios-arrow-back'></i></a></li>\r\n"
			
						:
				 "<li class='paginator__item paginator__item--prev'><a href=\"javascript:goPage('"+(cpage-1)+"')\"><i class='icon ion-ios-arrow-back'></i></a></li>\r\n"));
				
			
			for (int i = pageGroupStart; i < pageGroupEnd; i++) {
				if (i == cpage) {//현재페이지
					sb.append(makeActiveLink(i, (i + 1) + "") 
						
							);
				} else {
					sb.append(makeLink(i, (i + 1) + ""));
				}
			}
			
			
			//앞으로가기 화살표
			sb.append(hasNextPage ? makeLink(pageGroupEnd, nextLabel) :
				
				(cpage==pageTotal ?
						"<li class=\"paginator__item paginator__item--next\">\r\n"
						+ "			<a href=\"javascript:alert('"+"마지막페이지입니다"+"')\"><i class=\"icon ion-ios-arrow-forward\"></i></a>\r\n"
						+ "						</li>\r\n" 
						:
						"<li class=\"paginator__item paginator__item--next\">\r\n"
						+ "							<a href=\"javascript:goPage('"+(cpage+1)+"')\"><i class=\"icon ion-ios-arrow-forward\"></i></a>\r\n"
						+ "						</li>\r\n"));
			//마지막으로
			 sb.append((cpage < pageTotal) ? makeLink(pageTotal, endLabel) :
				 
				 "<li class=\"paginator__item\"><a href=\"javascript:alert('"+"마지막 페이지입니다"+"')\">"+endLabel+"</a></li>\r\n");
			 
		
			sb.append("</ul>\r\n") ;  		
			Tag = sb.toString() ; 	
		} catch ( Exception e ) {
			e.printStackTrace() ; 
		}
			
		return Tag ; 
	}

	public static String makeLink(int page, String label) 
	{
		StringBuffer tmp = new StringBuffer();
		tmp.append("<li class=\"paginator__item\"><a href=\"javascript:goPage('" + page + "')\">").append(label).append("</a></li>\r\n");
		return tmp.toString();
	}
	
	
	public static String makeActiveLink(int page, String label) 
	{
		StringBuffer tmp = new StringBuffer();
		tmp.append("<li class=\"paginator__item paginator__item--active\"><a href=\"javascript:goPage('" + page + "')\">").append(label).append("</a></li>\r\n");
		return tmp.toString();
	}

	
}
