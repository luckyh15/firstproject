package com.semi.flix.Visit;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("visitDao")
public class VisitDaoImpl implements VisitDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(VisitDto dto) {
		sm.insert("Visit_insert",dto);
		
	}

	@Override
	public int getTotal(VisitDto dto) {
		return sm.selectOne("Visit_getTotal", dto);
	}

	@Override
	public void update(VisitDto dto) {
		sm.update("Visit_update", dto);
	}

	@Override
	public List<VisitDto> getMonth() {
		return sm.selectList("Visit_month");
	}
	



}
