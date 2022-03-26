package com.semi.flix.admin.dramaboard;

import java.util.List;

public interface DramaBoardService {
	List<DramaBoardDto> getList(DramaBoardDto dto);
	void insert(DramaBoardDto dto);
	DramaBoardDto getView(String board_seq);
	int getTotal(DramaBoardDto dto);
	void delete(String board_seq);
	void update(DramaBoardDto dto);
}
