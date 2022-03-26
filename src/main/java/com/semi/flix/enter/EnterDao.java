package com.semi.flix.enter;

import java.util.List;


public interface EnterDao {

	List<EnterDto> getList(EnterDto dto); 
	int getTotal(EnterDto dto);
	EnterDto getView(EnterDto dto);
	List<EnterDto> getRank(EnterDto dto);
}
