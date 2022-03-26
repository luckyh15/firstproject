package com.semi.flix.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentDao")
public class CommentDaoImpl implements CommentDao{

	@Autowired 
	SqlSessionTemplate sm;
	
	

	@Override
	public void commentinsert(CommentDto dto) {
		sm.insert("Comment.commentinsert",dto);
		
	}



	





	@Override
	public List<CommentDto> commentList(CommentDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Comment.Comment_getList",dto);
	}




	
	
	@Override
	public int commentTotal(CommentDto dto) {
		return sm.selectOne("Comment.Comment_count",dto);
	}









	@Override
	public void comment_delete(CommentDto dto) {
		sm.delete("Comment.Comment_delete",dto);
	}
		

	

}




