package com.semi.flix.animation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.flix.comment.CommentDao;
import com.semi.flix.comment.CommentDto;

@Service("animationService")
public class AnimationServiceImpl implements AnimationService {
	
	@Resource(name="animationDao")
	AnimationDao animationDao;
	@Resource(name="commentDao")
	CommentDao commentDao;
	
	@Override
	public List<AnimationDto> getList(AnimationDto dto) {
		// TODO Auto-generated method stub
		return animationDao.getList(dto);
	}

	@Override
	public int getTotal(AnimationDto dto) {
		// TODO Auto-generated method stub
		return animationDao.getTotal(dto);
	}

	@Override
	public AnimationDto getView(AnimationDto dto) {
		// TODO Auto-generated method stub
		return animationDao.getView(dto);
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
	public void comment_delete(CommentDto dto) {
		commentDao.comment_delete(dto);
		
	}
	@Override
	public List<AnimationDto> getRank(AnimationDto dto) {
		return animationDao.getRank(dto);
	}

	

	

}
