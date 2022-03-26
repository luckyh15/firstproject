package com.semi.flix.admin.review;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface ReviewDao {
	List<ReviewDto> getList(ReviewDto dto);
	int getTotal(ReviewDto dto);
	void insert(ReviewDto dto);
	ReviewDto getView(String seq);
	void delete(String seq);
	void update(ReviewDto dto);
}
