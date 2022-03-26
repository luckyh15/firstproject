package com.semi.flix.Visit;

import java.util.List;

public interface VisitDao {
	void insert(VisitDto dto);
	int getTotal(VisitDto dto);
	void update (VisitDto dto);
	List<VisitDto> getMonth();  
}
