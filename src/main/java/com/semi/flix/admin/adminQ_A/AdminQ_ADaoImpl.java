package com.semi.flix.admin.adminQ_A;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("adminQ_ADao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class AdminQ_ADaoImpl implements AdminQ_ADao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<AdminQ_ADto> getList(AdminQ_ADto dto) {
		
		return sm.selectList("AdminQ_A_getList", dto);
	}

	@Override
	public AdminQ_ADto getView(String seq) {
		return sm.selectOne("AdminQ_A_getView", seq);
	}

	@Override
	public int getTotal(AdminQ_ADto dto) {
		return sm.selectOne("AdminQ_A_getTotal", dto);
	}

	@Override
	public void delete(String seq) {
		sm.delete("AdminQ_A_delete", seq);
	}

}
