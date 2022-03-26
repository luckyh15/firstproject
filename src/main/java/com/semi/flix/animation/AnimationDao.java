package com.semi.flix.animation;

import java.util.List;

public interface AnimationDao {
	List<AnimationDto> getList(AnimationDto dto);
	int getTotal(AnimationDto dto);
	AnimationDto getView(AnimationDto dto);
	List<AnimationDto> getRank(AnimationDto dto);
}
