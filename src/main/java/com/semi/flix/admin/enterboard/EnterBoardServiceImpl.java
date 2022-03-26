package com.semi.flix.admin.enterboard;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("enterboardService")
public class EnterBoardServiceImpl implements EnterBoardService{
	
	//@Autowired
	@Resource(name="enterboardDao")
	EnterBoardDao enterboardDao;
	
	@Override
	public List<EnterBoardDto> getList(EnterBoardDto dto) {
		return enterboardDao.getList(dto);
	}

	@Override
	public void insert(EnterBoardDto dto) {
		enterboardDao.insert(dto);
	}

	@Override
	public EnterBoardDto getView(String board_seq) {

		return enterboardDao.getView(board_seq);
	}

	@Override
	public int getTotal(EnterBoardDto dto) {
		return enterboardDao.getTotal(dto);
	}

	@Override
	public void delete(String board_seq) {
		enterboardDao.delete(board_seq);
		
	}

	@Override
	public void update(EnterBoardDto dto) {
		enterboardDao.update(dto);
		
	}

}
