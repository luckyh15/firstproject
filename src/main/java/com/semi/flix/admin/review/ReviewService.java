package com.semi.flix.admin.review;

import java.util.List;

public interface ReviewService {
	List<ReviewDto> getList(ReviewDto dto);
	void insert(ReviewDto dto);
	ReviewDto getView(String seq);
	int getTotal(ReviewDto dto);
	void delete(String seq);
	void update(ReviewDto dto);
}
