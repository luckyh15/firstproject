package com.semi.flix.comment;

import java.util.List;

public interface CommentDao {
	List<CommentDto> commentList(CommentDto dto);
	void commentinsert(CommentDto dto);
	int commentTotal(CommentDto dto);
	void comment_delete(CommentDto dto);
	
}
