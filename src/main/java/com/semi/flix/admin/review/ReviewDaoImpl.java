package com.semi.flix.admin.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reviewDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<ReviewDto> getList(ReviewDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("Review_getList", dto);
	}

	@Override
	public void insert(ReviewDto dto) {
		sm.insert("Review_insert", dto);
	}

	@Override
	public ReviewDto getView(String seq) {
		return sm.selectOne("Review_getView", seq);
	}

	@Override
	public int getTotal(ReviewDto dto) {
		return sm.selectOne("Review_getTotal", dto);
	}

	@Override
	public void delete(String seq) {
		sm.delete("Review_delete", seq);
	}

	@Override
	public void update(ReviewDto dto) {
		sm.update("Review_update", dto);
	}



}
