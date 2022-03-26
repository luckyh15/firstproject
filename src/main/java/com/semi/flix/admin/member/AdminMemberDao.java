package com.semi.flix.admin.member;

public interface AdminMemberDao {
	boolean isDuplicate(AdminMemberDto dto);
	void insert(AdminMemberDto dto);
	AdminMemberDto getInfo(AdminMemberDto dto);
	AdminMemberDto findId(AdminMemberDto dto);
	AdminMemberDto findPassword(AdminMemberDto dto);
	void update(AdminMemberDto dto);
	int cnt(AdminMemberDto dto);
	int user(AdminMemberDto dto);
	AdminMemberDto category(AdminMemberDto dto);
}
