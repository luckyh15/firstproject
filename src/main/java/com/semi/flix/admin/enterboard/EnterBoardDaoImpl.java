package com.semi.flix.admin.enterboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("enterboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class EnterBoardDaoImpl implements EnterBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<EnterBoardDto> getList(EnterBoardDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("EnterBoard_getList", dto);
	}

	@Override
	public void insert(EnterBoardDto dto) {
		sm.insert("EnterBoard_insert", dto);
	}

	@Override
	public EnterBoardDto getView(String board_seq) {
		return sm.selectOne("EnterBoard_getView", board_seq);
	}

	@Override
	public int getTotal(EnterBoardDto dto) {
		return sm.selectOne("EnterBoard_getTotal", dto);
	}

	@Override
	public void delete(String board_seq) {
		sm.delete("EnterBoard_delete", board_seq);
	}

	@Override
	public void update(EnterBoardDto dto) {
		sm.update("EnterBoard_update", dto);
	}



}
