package com.semi.flix.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert",dto);
		
	}
	
	@Override
	public boolean isDuplicate(MemberDto dto) {
		
		int cnt = sm.selectOne("Member_isduplicate", dto);
		if(cnt==0)
			return false; //�ߺ��ƴ�, ��밡���� ���̵���  
		else
			return true; //�̹� ������� 
	}
	
	@Override
	public MemberDto getInfo(MemberDto dto) {		
		return sm.selectOne("Member_getInfo", dto);
	}

	@Override
	public MemberDto findPassword(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_findpassword",dto);
	}
	
	@Override
	public MemberDto findId(MemberDto dto) {
		
	    return sm.selectOne("Member_findid", dto);
	}

	@Override
	public void update(MemberDto dto) {
		sm.update("Member_update",dto);
		
	}


}
