package com.semi.flix.Q_A;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Q_A_DAO {
	
	@Autowired
	private SqlSessionTemplate sm;

	public void insertQ_A(Q_A_DTO dto) {
		System.out.println("===> Mybatis로 insertNotice() 기능 처리");
		sm.insert("Q_A_DAO.insertQ_A", dto);
	}

	public void updateQ_A(Q_A_DTO dto) {
		System.out.println("===> Mybatis로 updateNotice() 기능 처리");
		sm.update("Q_A_DAO.updateQ_A", dto);
	}

	public void deleteQ_A(Q_A_DTO  dto) {
		System.out.println("===> Mybatis로 deleteNotice() 기능 처리");
	sm.delete("Q_A_DAO.deleteQ_A", dto);
	}

	public Q_A_DTO getQ_A(Q_A_DTO dto) {
		System.out.println("===> Mybatis로 getNotice() 기능 처리");
		return (Q_A_DTO) sm.selectOne("Q_A_DAO.getQ_A", dto);
	}

	public List<Q_A_DTO> getQ_A_List(Q_A_DTO  dto)  {
		System.out.println("===> Mybatis로 getNoticeList() 기능 처리");
		return sm.selectList("Q_A_DAO.getQ_A_List", dto);
		
	}
}
	
	


