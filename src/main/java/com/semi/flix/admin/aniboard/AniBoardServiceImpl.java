package com.semi.flix.admin.aniboard;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("aniboardService")
public class AniBoardServiceImpl implements AniBoardService{
	
	//@Autowired
	@Resource(name="aniboardDao")
	AniBoardDao aniboardDao;
	
	@Override
	public List<AniBoardDto> getList(AniBoardDto dto) {
		return aniboardDao.getList(dto);
	}

	@Override
	public void insert(AniBoardDto dto) {
		aniboardDao.insert(dto);
	}

	@Override
	public AniBoardDto getView(String board_seq) {

		return aniboardDao.getView(board_seq);
	}

	@Override
	public int getTotal(AniBoardDto dto) {
		return aniboardDao.getTotal(dto);
	}

	@Override
	public void delete(String board_seq) {
		aniboardDao.delete(board_seq);
		
	}

	@Override
	public void update(AniBoardDto dto) {
		aniboardDao.update(dto);
		
	}

}
