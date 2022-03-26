package com.semi.flix.admin.user;

import java.util.List;

public interface UserService {
	List<UserDto> getList(UserDto dto);
	void insert(UserDto dto);
	UserDto getView(String user_seq);
	int getTotal(UserDto dto);
	void delete(String user_seq);
	void update(UserDto dto);
	boolean isDuplicate(UserDto dto);
	int Mail_find(UserDto dto);
}
