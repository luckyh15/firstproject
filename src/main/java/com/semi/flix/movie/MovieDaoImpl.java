package com.semi.flix.movie;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("movieDao")

public class MovieDaoImpl implements MovieDao {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<MovieDto> getList(MovieDto dto) {
		return sm.selectList("Movie_getList", dto);
	}

	@Override
	public int getTotal(MovieDto dto) {
		return sm.selectOne("Movie_getTotal", dto);
	}

	@Override
	public MovieDto getView(MovieDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Movie_getView", dto);
	}


	@Override
	public List<MovieDto> getRank(MovieDto dto) {
		return sm.selectList("Movie_getRank",dto);
	}
}
