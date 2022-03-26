package com.semi.flix.notice;

import java.util.List;

public interface NoticeService {

	void insertNotice(NoticeDTO dto);

	// �� ����
	void updateNotice(NoticeDTO dto);

	// �� ����
	void deleteNotice(NoticeDTO dto);

	// �� �� ��ȸ
	NoticeDTO getNotice(NoticeDTO dto);

	// �� ��� ��ȸ
	List<NoticeDTO> getNotice_List(NoticeDTO dto);

}
