package com.semi.flix.drama;

import java.util.List;

public interface DramaDao {
	List<DramaDto> getList(DramaDto dto);
	int getTotal(DramaDto dto);
	DramaDto getView(DramaDto dto);
	List<DramaDto> getRank(DramaDto dto);
	
}
