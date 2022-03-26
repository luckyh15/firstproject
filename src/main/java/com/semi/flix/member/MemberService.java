package com.semi.flix.member;

public interface MemberService {
	
	void insert(MemberDto dto);
	boolean isDuplicate(MemberDto dto);
	MemberDto getInfo(MemberDto dto);
	MemberDto findPassword(MemberDto dto);
	MemberDto findId(MemberDto dto);
	void update(MemberDto dto);
	
	
	
}
