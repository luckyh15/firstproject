package com.semi.flix.admin.board;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminboardService")
public class AdminBoardServiceImpl implements AdminBoardService{
	
	//@Autowired
	@Resource(name="adminboardDao")
	AdminBoardDao adminboardDao;
	@Override
	public AdminBoardDto search(AdminBoardDto dto) {
		return adminboardDao.search(dto);
	}

}
