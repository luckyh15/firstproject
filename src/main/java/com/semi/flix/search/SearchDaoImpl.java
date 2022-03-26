package com.semi.flix.search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<SearchDto> getList(SearchDto dto) {
		return sm.selectList("listPage",dto);
	}
	
	
	
}
