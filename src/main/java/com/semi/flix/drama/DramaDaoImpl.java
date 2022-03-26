package com.semi.flix.drama;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dramaDao")
public class DramaDaoImpl implements DramaDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<DramaDto> getList(DramaDto dto) {
		return sm.selectList("Drama_getList", dto);
	}

	@Override
	public int getTotal(DramaDto dto) {
		return sm.selectOne("Drama_getTotal",dto);
	}

	@Override
	public DramaDto getView(DramaDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Drama_getView",dto);
	}

	@Override
	public List<DramaDto> getRank(DramaDto dto) {
		return sm.selectList("Drama_getRank", dto);
	}
}
