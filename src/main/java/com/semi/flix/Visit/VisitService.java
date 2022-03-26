package com.semi.flix.Visit;

import java.util.List;

public interface VisitService {
	
	void insert(VisitDto dto);
	int getTotal(VisitDto dto);
	void update (VisitDto dto);
	List<VisitDto> getMonth();  
}
