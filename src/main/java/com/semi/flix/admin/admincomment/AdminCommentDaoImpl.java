package com.semi.flix.admin.admincomment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("admincommentDao")
public class AdminCommentDaoImpl implements AdminCommentDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<AdminCommentDto> getList(AdminCommentDto dto) {
		return sm.selectList("AdminComment.Comment_getList", dto);
	}

	@Override
	public void insert(AdminCommentDto dto) {
		sm.insert("AdminComment.Comment_insert", dto);
	}

	@Override
	public AdminCommentDto comment_getView(AdminCommentDto dto) {
		return sm.selectOne("AdminComment.Comment_getView", dto);
	}

	@Override
	public void comment_delete(AdminCommentDto dto) {
		sm.delete("AdminComment.Comment_delete", dto);
	}

}
