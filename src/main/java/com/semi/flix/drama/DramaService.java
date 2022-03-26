package com.semi.flix.drama;

import java.util.List;

import com.semi.flix.comment.CommentDto;

public interface DramaService {
	List<DramaDto> getList(DramaDto dto);
	int getTotal(DramaDto dto);
	DramaDto getView(DramaDto dto);
	List<DramaDto> getRank(DramaDto dto);
	
	//�뙎湲�
	List<CommentDto> commentList(CommentDto dto);
	void commentinsert(CommentDto dto);
	int commentTotal(CommentDto dto);
	
}
