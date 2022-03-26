package com.semi.flix.webtoon;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("webtoonDao")
public class WebtoonDaoImpl implements WebtoonDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<WebtoonDto> getList(WebtoonDto dto) {
		return sm.selectList("Webtoon_getList", dto);
	}

	@Override
	public int getTotal(WebtoonDto dto) {
		return sm.selectOne("Webtoon_getTotal",dto);
	}

	@Override
	public WebtoonDto getView(WebtoonDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Webtoon_getView",dto);
	}
	
	@Override
	public List<WebtoonDto> getRank(WebtoonDto dto) {
		return sm.selectList("Webtoon_getRank", dto);
	}


	

}
