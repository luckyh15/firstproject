package com.semi.flix.webtoon;

import java.util.List;

import com.semi.flix.comment.CommentDto;

public interface WebtoonService {
	List<WebtoonDto> getList(WebtoonDto dto);
	int getTotal(WebtoonDto dto);
	WebtoonDto getView(WebtoonDto dto);
	List<WebtoonDto> getRank(WebtoonDto dto);
	
	
	//�뙎湲�
	List<CommentDto> commentList(CommentDto dto);
	void commentinsert(CommentDto dto);
	int commentTotal(CommentDto dto);
	
}
