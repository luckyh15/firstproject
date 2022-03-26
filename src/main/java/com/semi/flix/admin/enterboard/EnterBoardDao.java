package com.semi.flix.admin.enterboard;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface EnterBoardDao {
	List<EnterBoardDto> getList(EnterBoardDto dto);
	int getTotal(EnterBoardDto dto);
	void insert(EnterBoardDto dto);
	EnterBoardDto getView(String board_seq);
	void delete(String board_seq);
	void update(EnterBoardDto dto);
}
