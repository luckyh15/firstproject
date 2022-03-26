package com.semi.flix.admin.movieboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("movieboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class MovieBoardDaoImpl implements MovieBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<MovieBoardDto> getList(MovieBoardDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("MovieBoard_getList", dto);
	}

	@Override
	public void insert(MovieBoardDto dto) {
		sm.insert("MovieBoard_insert", dto);
	}

	@Override
	public MovieBoardDto getView(String board_seq) {
		return sm.selectOne("MovieBoard_getView", board_seq);
	}

	@Override
	public int getTotal(MovieBoardDto dto) {
		return sm.selectOne("MovieBoard_getTotal", dto);
	}

	@Override
	public void delete(String board_seq) {
		sm.delete("MovieBoard_delete", board_seq);
	}

	@Override
	public void update(MovieBoardDto dto) {
		sm.update("MovieBoard_update", dto);
	}



}
