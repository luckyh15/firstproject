package com.semi.flix.admin.movieboard;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("movieboardService")
public class MovieBoardServiceImpl implements MovieBoardService{
	
	//@Autowired
	@Resource(name="movieboardDao")
	MovieBoardDao movieboardDao;
	
	@Override
	public List<MovieBoardDto> getList(MovieBoardDto dto) {
		return movieboardDao.getList(dto);
	}

	@Override
	public void insert(MovieBoardDto dto) {
		movieboardDao.insert(dto);
	}

	@Override
	public MovieBoardDto getView(String board_seq) {

		return movieboardDao.getView(board_seq);
	}

	@Override
	public int getTotal(MovieBoardDto dto) {
		return movieboardDao.getTotal(dto);
	}

	@Override
	public void delete(String board_seq) {
		movieboardDao.delete(board_seq);
		
	}

	@Override
	public void update(MovieBoardDto dto) {
		movieboardDao.update(dto);
		
	}

}
