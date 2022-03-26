package com.semi.flix.Q_A;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("q_a_Service")
public class Q_A_ServiceImpl implements Q_A_Service {

	@Autowired
	private Q_A_DAO q_a_DAO;

	public void insertQ_A(Q_A_DTO dto) {
		q_a_DAO.insertQ_A(dto);
	}

	@Override
	public void updateQ_A(Q_A_DTO dto) {
		q_a_DAO.updateQ_A(dto);
	}

	@Override
	public void deleteQ_A(Q_A_DTO dto) {
		q_a_DAO.deleteQ_A(dto);
	}

	@Override
	public Q_A_DTO getQ_A(Q_A_DTO dto) {
		return q_a_DAO.getQ_A(dto);
	}

	@Override
	public List<Q_A_DTO> getQ_A_List(Q_A_DTO dto) {

		return q_a_DAO.getQ_A_List(dto);
	}

}
