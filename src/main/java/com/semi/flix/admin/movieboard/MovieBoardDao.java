package com.semi.flix.admin.movieboard;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface MovieBoardDao {
	List<MovieBoardDto> getList(MovieBoardDto dto);
	int getTotal(MovieBoardDto dto);
	void insert(MovieBoardDto dto);
	MovieBoardDto getView(String board_seq);
	void delete(String board_seq);
	void update(MovieBoardDto dto);
}
