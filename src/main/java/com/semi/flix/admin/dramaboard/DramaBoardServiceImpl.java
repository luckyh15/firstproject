package com.semi.flix.admin.dramaboard;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("dramaboardService")
public class DramaBoardServiceImpl implements DramaBoardService{
	
	//@Autowired
	@Resource(name="dramaboardDao")
	DramaBoardDao dramaboardDao;
	
	@Override
	public List<DramaBoardDto> getList(DramaBoardDto dto) {
		return dramaboardDao.getList(dto);
	}

	@Override
	public void insert(DramaBoardDto dto) {
		dramaboardDao.insert(dto);
	}

	@Override
	public DramaBoardDto getView(String board_seq) {

		return dramaboardDao.getView(board_seq);
	}

	@Override
	public int getTotal(DramaBoardDto dto) {
		return dramaboardDao.getTotal(dto);
	}

	@Override
	public void delete(String board_seq) {
		dramaboardDao.delete(board_seq);
		
	}

	@Override
	public void update(DramaBoardDto dto) {
		dramaboardDao.update(dto);
		
	}

}
