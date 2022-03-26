package com.semi.flix.admin.aniboard;

import java.util.List;

public interface AniBoardService {
	List<AniBoardDto> getList(AniBoardDto dto);
	void insert(AniBoardDto dto);
	AniBoardDto getView(String board_seq);
	int getTotal(AniBoardDto dto);
	void delete(String board_seq);
	void update(AniBoardDto dto);
}
