package com.semi.flix.admin.user;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface UserDao {
	boolean isDuplicate(UserDto dto);
	List<UserDto> getList(UserDto dto);
	int getTotal(UserDto dto);
	void insert(UserDto dto);
	UserDto getView(String user_seq);
	void delete(String user_seq);
	void update(UserDto dto);
	int Mail_find(UserDto dto);
}
