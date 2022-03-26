package com.semi.flix.admin.adminQ_A;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.flix.admin.admincomment.AdminCommentDao;
import com.semi.flix.admin.admincomment.AdminCommentDto;

@Service("adminQ_AService")
public class AdminQ_AServiceImpl implements AdminQ_AService{
	
	//@Autowired
	@Resource(name="adminQ_ADao")
	AdminQ_ADao adminQ_ADao;
	
	@Override
	public List<AdminQ_ADto> getList(AdminQ_ADto dto) {
		return adminQ_ADao.getList(dto);
	}
	@Override
	public AdminQ_ADto getView(String seq) {

		return adminQ_ADao.getView(seq);
	}

	@Override
	public int getTotal(AdminQ_ADto dto) {
		return adminQ_ADao.getTotal(dto);
	}

	@Override
	public void delete(String seq) {
		adminQ_ADao.delete(seq);
		
	}

	@Resource(name="admincommentDao")
	AdminCommentDao admincommentDao;
	
	@Override
	public AdminCommentDto getCommentView(AdminCommentDto dto) {
		return admincommentDao.comment_getView(dto);
	}
	
	@Override
	public void comment_delete(AdminCommentDto dto) {
		admincommentDao.comment_delete(dto);
		
	}
	@Override
	public void comment_insert(AdminCommentDto dto) {
		admincommentDao.insert(dto);
		
	}
	@Override
	public List<AdminCommentDto> getCommentList(AdminCommentDto dto) {
		return admincommentDao.getList(dto);
	}

}
