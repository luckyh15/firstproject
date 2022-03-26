package com.semi.flix.admin.toonboard;

import java.util.List;

public interface ToonBoardService {
	List<ToonBoardDto> getList(ToonBoardDto dto);
	void insert(ToonBoardDto dto);
	ToonBoardDto getView(String board_seq);
	int getTotal(ToonBoardDto dto);
	void delete(String board_seq);
	void update(ToonBoardDto dto);
}
