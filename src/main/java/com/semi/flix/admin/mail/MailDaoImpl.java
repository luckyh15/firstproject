package com.semi.flix.admin.mail;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mailDao")  //없으면 안된다. 스프링이 이걸 보고 객체를 만들어서 관리하기 때문에 꼭 써줘야한다.
public class MailDaoImpl implements MailDao{

	@Autowired
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기를 할거다

	@Override
	public List<MailDto> getList(MailDto dto) {
		
		//dto Board.xml파일에 parameterType에 전달된다.
		return sm.selectList("Mail_getList", dto);
	}

	@Override
	public void insert(MailDto dto) {
		sm.insert("Mail_insert", dto);
	}

	@Override
	public MailDto getView(String seq) {
		return sm.selectOne("Mail_getView", seq);
	}

	@Override
	public int getTotal(MailDto dto) {
		return sm.selectOne("Mail_getTotal", dto);
	}

}
