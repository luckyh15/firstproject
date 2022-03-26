package com.semi.flix.enter;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("enterDao")
public class EnterDaoImpl implements EnterDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<EnterDto> getList(EnterDto dto) {
		return sm.selectList("Entertain_getList", dto);
	}

	@Override
	public int getTotal(EnterDto dto) {
		return sm.selectOne("Entertain_getTotal",dto);
	}

	@Override
	public EnterDto getView(EnterDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Entertain_getView",dto);
	}
	@Override
	public List<EnterDto> getRank(EnterDto dto) {
		return sm.selectList("Entertain_getRank",dto);
	}

}
