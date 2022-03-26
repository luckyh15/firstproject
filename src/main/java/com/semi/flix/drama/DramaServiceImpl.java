package com.semi.flix.drama;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.flix.comment.CommentDao;
import com.semi.flix.comment.CommentDto;

@Service("dramaService")
public class DramaServiceImpl implements DramaService {
	 
	@Resource(name="dramaDao")
	DramaDao dramaDao;
	@Resource(name="commentDao")
	CommentDao commentDao;
	@Override
	public List<DramaDto> getList(DramaDto dto) {
		// TODO Auto-generated method stub
		return dramaDao.getList(dto);
	}

	@Override
	public int getTotal(DramaDto dto) {
		// TODO Auto-generated method stub
		return dramaDao.getTotal(dto);
	}

	@Override
	public DramaDto getView(DramaDto dto) {
		// TODO Auto-generated method stub
		return dramaDao.getView(dto);
	}
	@Override
	public List<DramaDto> getRank(DramaDto dto) {
		
		return dramaDao.getRank(dto);
	}
	
	//----占쎈연疫꿸퀡占쏙옙苑ｏ옙�솊疫뀐옙----
	@Override
	public void commentinsert(CommentDto dto) {
		commentDao.commentinsert(dto);
		
	}

	

	@Override
	public int commentTotal(CommentDto dto) {
		return commentDao.commentTotal(dto);
		
	}

	@Override
	public List<CommentDto> commentList(CommentDto dto) {
		// TODO Auto-generated method stub
		return commentDao.commentList(dto);
	}
	
	
}
