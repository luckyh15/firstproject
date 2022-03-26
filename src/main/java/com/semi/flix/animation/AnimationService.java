package com.semi.flix.animation;

import java.util.List;

import com.semi.flix.comment.CommentDto;

public interface AnimationService {
	List<AnimationDto> getList(AnimationDto dto);
	int getTotal(AnimationDto dto);
	AnimationDto getView(AnimationDto dto);
	List<AnimationDto> getRank(AnimationDto dto);
	
	//�뙎湲�
	List<CommentDto> commentList(CommentDto dto);
	void commentinsert(CommentDto dto);
	int commentTotal(CommentDto dto);
	void comment_delete(CommentDto dto);
}
