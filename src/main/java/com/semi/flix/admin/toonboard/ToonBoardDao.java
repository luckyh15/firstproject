package com.semi.flix.admin.toonboard;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface ToonBoardDao {
	List<ToonBoardDto> getList(ToonBoardDto dto);
	int getTotal(ToonBoardDto dto);
	void insert(ToonBoardDto dto);
	ToonBoardDto getView(String board_seq);
	void delete(String board_seq);
	void update(ToonBoardDto dto);
}
