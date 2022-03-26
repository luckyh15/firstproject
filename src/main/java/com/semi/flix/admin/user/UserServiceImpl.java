package com.semi.flix.admin.user;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	//@Autowired
	@Resource(name="userDao")
	UserDao userDao;
	
	@Override
	public boolean isDuplicate(UserDto dto) {
		return userDao.isDuplicate(dto);
	}
	
	@Override
	public List<UserDto> getList(UserDto dto) {
		return userDao.getList(dto);
	}

	@Override
	public void insert(UserDto dto) {
		userDao.insert(dto);
	}

	@Override
	public UserDto getView(String user_seq) {

		return userDao.getView(user_seq);
	}

	@Override
	public int getTotal(UserDto dto) {
		return userDao.getTotal(dto);
	}

	@Override
	public void delete(String user_seq) {
		userDao.delete(user_seq);
		
	}

	@Override
	public void update(UserDto dto) {
		userDao.update(dto);
		
	}

	@Override
	public int Mail_find(UserDto dto) {
		return userDao.Mail_find(dto);
	}

}
