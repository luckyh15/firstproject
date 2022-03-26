package com.semi.flix.admin.aniboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("aniboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class AniBoardDaoImpl implements AniBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<AniBoardDto> getList(AniBoardDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("AniBoard_getList", dto);
	}

	@Override
	public void insert(AniBoardDto dto) {
		sm.insert("AniBoard_insert", dto);
	}

	@Override
	public AniBoardDto getView(String board_seq) {
		return sm.selectOne("AniBoard_getView", board_seq);
	}

	@Override
	public int getTotal(AniBoardDto dto) {
		return sm.selectOne("AniBoard_getTotal", dto);
	}

	@Override
	public void delete(String board_seq) {
		sm.delete("AniBoard_delete", board_seq);
	}

	@Override
	public void update(AniBoardDto dto) {
		sm.update("AniBoard_update", dto);
	}



}
