package com.semi.flix.admin.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public boolean isDuplicate(UserDto dto) {
		int cnt = sm.selectOne("User_isDuplicate", dto);
		if(cnt==0)
			return false;	//중복이 아니기때문에 사용 가능하다는뜻 , 사용가능아이디
		else
			return true;	//이미 사용중
	}

	@Override
	public List<UserDto> getList(UserDto dto) {
		return sm.selectList("User_getList", dto);
	}

	@Override
	public void insert(UserDto dto) {
		sm.insert("User_insert", dto);
	}

	@Override
	public UserDto getView(String user_seq) {
		return sm.selectOne("User_getView", user_seq);
	}

	@Override
	public int getTotal(UserDto dto) {
		return sm.selectOne("User_getTotal", dto);
	}

	@Override
	public void delete(String user_seq) {
		sm.delete("User_delete", user_seq);
	}

	@Override
	public void update(UserDto dto) {
		sm.update("User_update", dto);
	}

	@Override
	public int Mail_find(UserDto dto) {
		return sm.selectOne("Mail_find", dto);
	}



}
