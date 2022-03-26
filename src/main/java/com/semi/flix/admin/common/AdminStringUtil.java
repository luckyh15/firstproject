package com.semi.flix.admin.common;

//객체를 안만들고 쓰는 클래스 - 여기저기서 다목적으로 사용하는 클래스는 이렇게 설계한다.
public class AdminStringUtil {
	public static String nullToValue(Object ob, String value) {
		if(ob==null)
			return value;
		else
			return ob.toString();
		
		//어떤 값들이 null 값이 들어오면 이걸 두번째 파라미터로 전달된 값을 주기 위한 함수이다.
		
		//String pg = requst.getParameter("pg"); 이게 pg가 아니라 null일 수 있다.
		//if(pg==null) pg="";
		
		//위에꺼를 좀 더 편하게 쓰면 아래같이 나온다.
		//String pg = StringUtil.nullToValue(requst.getParameter("pg"), "0");
	}
}
