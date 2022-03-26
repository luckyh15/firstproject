package com.semi.flix.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("notice_Service")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public void insertNotice(NoticeDTO dto) {
		noticeDAO.insertNotice(dto);
	}

	@Override
	public void updateNotice(NoticeDTO dto) {
		noticeDAO.updateNotice(dto);
	}

	@Override
	public void deleteNotice(NoticeDTO dto) {
		noticeDAO.deleteNotice(dto);
	}

	@Override
	public NoticeDTO getNotice(NoticeDTO dto) {
		return noticeDAO.getNotice(dto);
	}

	@Override
	public List<NoticeDTO> getNotice_List(NoticeDTO dto) {

		return noticeDAO.getNotice_List(dto);
	}

}