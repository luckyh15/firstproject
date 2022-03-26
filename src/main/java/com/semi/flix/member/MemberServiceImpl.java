package com.semi.flix.member;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	MemberDao memberDao;

	

	@Override
	public void insert(MemberDto dto) {
		memberDao.insert(dto);
	}
	@Override
	public boolean isDuplicate(MemberDto dto) {
		
		return memberDao.isDuplicate(dto);
	}
	
	@Override
	public MemberDto getInfo(MemberDto dto) {
		// TODO Auto-generated method stub
		return memberDao.getInfo(dto);
	}
	@Override
	public MemberDto findPassword(MemberDto dto) {
		// TODO Auto-generated method stub
		return memberDao.findPassword(dto);
	}
	@Override
	public MemberDto findId(MemberDto dto) {
		
		return memberDao.findId(dto);
	}
	@Override
	public void update(MemberDto dto) {
		memberDao.update(dto);
		
	}

	
	
		
}



