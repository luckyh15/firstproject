package com.semi.flix.admin.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("adminmemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	
	@Resource(name="adminmemberDao")
	AdminMemberDao adminmemberDao;

	@Override
	public boolean isDuplicate(AdminMemberDto dto) {
		return adminmemberDao.isDuplicate(dto);
	}

	@Override
	public void insert(AdminMemberDto dto) {
		adminmemberDao.insert(dto);
	}

	@Override
	public AdminMemberDto getInfo(AdminMemberDto dto) {
		return adminmemberDao.getInfo(dto);
	}

	@Override
	public AdminMemberDto findId(AdminMemberDto dto) {
		return adminmemberDao.findId(dto);
	}

	@Override
	public AdminMemberDto findPassword(AdminMemberDto dto) {
		return adminmemberDao.findPassword(dto);
	}

	@Override
	public void update(AdminMemberDto dto) {
		adminmemberDao.update(dto);
	}
	@Override
	public int cnt(AdminMemberDto dto) {
		return adminmemberDao.cnt(dto);
	}
	@Override
	public int user(AdminMemberDto dto) {
		return adminmemberDao.user(dto);
	}
	@Override
	public AdminMemberDto category(AdminMemberDto dto) {
		return adminmemberDao.category(dto);
	}
}
