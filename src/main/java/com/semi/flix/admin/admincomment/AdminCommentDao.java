package com.semi.flix.admin.admincomment;

import java.util.List;

//클래스와의 결합력을 약화시키기 위해서 나중에 바꿔치기 쉽게 하려고
public interface AdminCommentDao {
	List<AdminCommentDto> getList(AdminCommentDto dto);
	void insert(AdminCommentDto dto);
	AdminCommentDto comment_getView(AdminCommentDto dto);
	void comment_delete(AdminCommentDto dto);
}
