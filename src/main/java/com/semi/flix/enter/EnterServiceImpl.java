package com.semi.flix.enter;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.flix.comment.CommentDao;
import com.semi.flix.comment.CommentDto;

@Service("enterService")
public class EnterServiceImpl implements EnterService {
	
	@Resource(name="enterDao")
	EnterDao enterDao;
	
	@Resource(name="commentDao")
	CommentDao commentDao;

	@Override
	public List<EnterDto> getList(EnterDto dto) {
		// TODO Auto-generated method stub
		return enterDao.getList(dto);
	}

	@Override
	public int getTotal(EnterDto dto) {
		// TODO Auto-generated method stub
		return enterDao.getTotal(dto);
	}

	@Override
	public EnterDto getView(EnterDto dto) {
		// TODO Auto-generated method stub
		return enterDao.getView(dto);
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
	
	@Override
	public List<EnterDto> getRank(EnterDto dto) {
		return enterDao.getRank(dto);
	}
	
	
	
}
