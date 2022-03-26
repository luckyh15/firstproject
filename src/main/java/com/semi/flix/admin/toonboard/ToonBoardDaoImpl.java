package com.semi.flix.admin.toonboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("toonboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class ToonBoardDaoImpl implements ToonBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<ToonBoardDto> getList(ToonBoardDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("ToonBoard_getList", dto);
	}

	@Override
	public void insert(ToonBoardDto dto) {
		sm.insert("ToonBoard_insert", dto);
	}

	@Override
	public ToonBoardDto getView(String board_seq) {
		return sm.selectOne("ToonBoard_getView", board_seq);
	}

	@Override
	public int getTotal(ToonBoardDto dto) {
		return sm.selectOne("ToonBoard_getTotal", dto);
	}

	@Override
	public void delete(String board_seq) {
		sm.delete("ToonBoard_delete", board_seq);
	}

	@Override
	public void update(ToonBoardDto dto) {
		sm.update("ToonBoard_update", dto);
	}

}
