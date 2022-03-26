package com.semi.flix.admin.review;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	
	//@Autowired
	@Resource(name="reviewDao")
	ReviewDao reviewDao;
	
	@Override
	public List<ReviewDto> getList(ReviewDto dto) {
		return reviewDao.getList(dto);
	}

	@Override
	public void insert(ReviewDto dto) {
		reviewDao.insert(dto);
	}

	@Override
	public ReviewDto getView(String seq) {

		return reviewDao.getView(seq);
	}

	@Override
	public int getTotal(ReviewDto dto) {
		return reviewDao.getTotal(dto);
	}

	@Override
	public void delete(String seq) {
		reviewDao.delete(seq);
		
	}

	@Override
	public void update(ReviewDto dto) {
		reviewDao.update(dto);
		
	}

}
