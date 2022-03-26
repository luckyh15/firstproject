package com.semi.flix.admin.toonboard;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("toonboardService")
public class ToonBoardServiceImpl implements ToonBoardService{
	
	//@Autowired
	@Resource(name="toonboardDao")
	ToonBoardDao toonboardDao;
	
	@Override
	public List<ToonBoardDto> getList(ToonBoardDto dto) {
		return toonboardDao.getList(dto);
	}

	@Override
	public void insert(ToonBoardDto dto) {
		toonboardDao.insert(dto);
	}

	@Override
	public ToonBoardDto getView(String board_seq) {

		return toonboardDao.getView(board_seq);
	}

	@Override
	public int getTotal(ToonBoardDto dto) {
		return toonboardDao.getTotal(dto);
	}

	@Override
	public void delete(String board_seq) {
		toonboardDao.delete(board_seq);
		
	}

	@Override
	public void update(ToonBoardDto dto) {
		toonboardDao.update(dto);
		
	}

}
