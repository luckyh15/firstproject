package com.semi.flix.admin.dramaboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dramaboardDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class DramaBoardDaoImpl implements DramaBoardDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<DramaBoardDto> getList(DramaBoardDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("DramaBoard_getList", dto);
	}

	@Override
	public void insert(DramaBoardDto dto) {
		sm.insert("DramaBoard_insert", dto);
	}

	@Override
	public DramaBoardDto getView(String board_seq) {
		return sm.selectOne("DramaBoard_getView", board_seq);
	}

	@Override
	public int getTotal(DramaBoardDto dto) {
		return sm.selectOne("DramaBoard_getTotal", dto);
	}

	@Override
	public void delete(String board_seq) {
		sm.delete("DramaBoard_delete", board_seq);
	}

	@Override
	public void update(DramaBoardDto dto) {
		sm.update("DramaBoard_update", dto);
	}



}
