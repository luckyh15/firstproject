package com.semi.flix.Q_A;

import java.util.List;



public interface Q_A_Service {
	// CRUD ����� �޼ҵ�
		// �� ���
		void insertQ_A(Q_A_DTO dto);

		// �� ����
		void updateQ_A(Q_A_DTO dto);

		// �� ����
		void deleteQ_A(Q_A_DTO dto);

		// �� �� ��ȸ
		Q_A_DTO getQ_A(Q_A_DTO dto);

		// �� ��� ��ȸ
		List<Q_A_DTO> getQ_A_List(Q_A_DTO dto);
		
		
	}

	
	


