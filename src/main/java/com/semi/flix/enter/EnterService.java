package com.semi.flix.enter;

import java.util.List;

import com.semi.flix.comment.CommentDto;

public interface EnterService {

	List<EnterDto> getList(EnterDto dto);
	int getTotal(EnterDto dto);
	EnterDto getView(EnterDto dto);
	List<EnterDto> getRank(EnterDto dto);
	
	
	//�뙎湲�
	List<CommentDto> commentList(CommentDto dto);
	void commentinsert(CommentDto dto);
	int commentTotal(CommentDto dto);
}
