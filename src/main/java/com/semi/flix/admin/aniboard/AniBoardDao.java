package com.semi.flix.admin.aniboard;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface AniBoardDao {
	List<AniBoardDto> getList(AniBoardDto dto);
	int getTotal(AniBoardDto dto);
	void insert(AniBoardDto dto);
	AniBoardDto getView(String board_seq);
	void delete(String board_seq);
	void update(AniBoardDto dto);
}
