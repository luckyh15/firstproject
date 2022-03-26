package com.semi.flix.admin.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("adminboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class AdminBoardDaoImpl implements AdminBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public AdminBoardDto search(AdminBoardDto dto) {
		return sm.selectOne("nav_search", dto);
	}
	

}
