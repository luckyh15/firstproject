package com.semi.flix.animation;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("animationDao")
public class AnimationDaoImpl implements AnimationDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<AnimationDto> getList(AnimationDto dto) {
		return sm.selectList("Animation_getList", dto);
	}

	@Override
	public int getTotal(AnimationDto dto) {
		return sm.selectOne("Animation_getTotal",dto);
	}

	@Override
	public AnimationDto getView(AnimationDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Animation_getView",dto);
	}

	@Override
	public List<AnimationDto> getRank(AnimationDto dto) {
		return sm.selectList("Animation_getRank", dto);
	}


}
