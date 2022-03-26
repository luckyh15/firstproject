package com.semi.flix.webtoon;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.flix.comment.CommentDao;
import com.semi.flix.comment.CommentDto;

@Service("webtoonService")
public class WebtoonServiceImpl implements WebtoonService {
	
	@Resource(name="webtoonDao")
	WebtoonDao webtoonDao;
	
	@Resource(name="commentDao")
	CommentDao commentDao;

	@Override
	public List<WebtoonDto> getList(WebtoonDto dto) {
		// TODO Auto-generated method stub
		return webtoonDao.getList(dto);
	}

	@Override
	public int getTotal(WebtoonDto dto) {
		// TODO Auto-generated method stub
		return webtoonDao.getTotal(dto);
	}

	@Override
	public WebtoonDto getView(WebtoonDto dto) {
		// TODO Auto-generated method stub
		return webtoonDao.getView(dto);
	}
	
	@Override
	public List<WebtoonDto> getRank(WebtoonDto dto) {
		// TODO Auto-generated method stub
		return webtoonDao.getRank(dto);
	}


	@Override
	public void commentinsert(CommentDto dto) {
		commentDao.commentinsert(dto);
		
	}

	@Override
	public List<CommentDto> commentList(CommentDto dto) {
		// TODO Auto-generated method stub
		return commentDao.commentList(dto);
	}

	@Override
	public int commentTotal(CommentDto dto) {
		return commentDao.commentTotal(dto);
		
	}

	
	
	//�뙎湲�
	
	
	
}
