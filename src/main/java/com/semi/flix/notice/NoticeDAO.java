package com.semi.flix.notice;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate sm;

	public void insertNotice(NoticeDTO dto) {
		System.out.println("===> Mybatis�� insertNotice() ��� ó��");
		sm.insert("NoticeDAO.insertNotice", dto);
	}

	public void updateNotice(NoticeDTO dto) {
		System.out.println("===> Mybatis�� updateNotice() ��� ó��");
		sm.update("NoticeDAO.updateNotice", dto);
	}

	public void deleteNotice(NoticeDTO dto) {
		System.out.println("===> Mybatis�� deleteNotice() ��� ó��");
		sm.update("NoticeDAO.deleteNotice", dto);
	}

	public NoticeDTO getNotice(NoticeDTO dto) {
		System.out.println("===> Mybatis�� getNotice() ��� ó��");
		return (NoticeDTO) sm.selectOne("NoticeDAO.getNotice", dto);
	}

	public List<NoticeDTO> getNotice_List(NoticeDTO dto)  {
		System.out.println("===> Mybatis�� getNoticeList() ��� ó��");
		return sm.selectList("NoticeDAO.getNotice_List", dto);
		
	}

}
