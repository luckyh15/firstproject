package com.semi.flix.admin.movieboard;

import java.util.List;

public interface MovieBoardService {
	List<MovieBoardDto> getList(MovieBoardDto dto);
	void insert(MovieBoardDto dto);
	MovieBoardDto getView(String board_seq);
	int getTotal(MovieBoardDto dto);
	void delete(String board_seq);
	void update(MovieBoardDto dto);
}
