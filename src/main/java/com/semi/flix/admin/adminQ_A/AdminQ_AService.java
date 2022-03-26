package com.semi.flix.admin.adminQ_A;

import java.util.List;

import com.semi.flix.admin.admincomment.AdminCommentDto;

public interface AdminQ_AService {
	List<AdminQ_ADto> getList(AdminQ_ADto dto);
	AdminQ_ADto getView(String seq);
	int getTotal(AdminQ_ADto dto);
	void delete(String seq);
	
	void comment_insert(AdminCommentDto dto);
	List<AdminCommentDto> getCommentList(AdminCommentDto dto);
	AdminCommentDto getCommentView(AdminCommentDto dto);
	void comment_delete(AdminCommentDto dto);
}
