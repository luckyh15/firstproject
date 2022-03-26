package com.semi.flix.admin.enterboard;

import java.util.List;

public interface EnterBoardService {
	List<EnterBoardDto> getList(EnterBoardDto dto);
	void insert(EnterBoardDto dto);
	EnterBoardDto getView(String board_seq);
	int getTotal(EnterBoardDto dto);
	void delete(String board_seq);
	void update(EnterBoardDto dto);
}
