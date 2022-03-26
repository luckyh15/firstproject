package com.semi.flix.admin.dramaboard;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface DramaBoardDao {
	List<DramaBoardDto> getList(DramaBoardDto dto);
	int getTotal(DramaBoardDto dto);
	void insert(DramaBoardDto dto);
	DramaBoardDto getView(String board_seq);
	void delete(String board_seq);
	void update(DramaBoardDto dto);
}
