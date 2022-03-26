package com.semi.flix.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;





@Controller
@SessionAttributes("Notice")

public class NoticeController {
	@Autowired
	private NoticeService notice_Service;

	@RequestMapping(value = "/go_insertNotice.do")
	public String go_insertNotice() throws IOException {
		
		return "notice/insertNotice";
	}
	@RequestMapping(value = "/insertNotice.do")
	public String insertNotice(NoticeDTO dto) throws IOException {
		System.out.println("[-----------------------]" + dto);
		notice_Service.insertNotice(dto);
		return "redirect:/getNotice_List.do";
	}
	@RequestMapping(value = "/go_updateNotice.do")
	public String go_updateNotice(NoticeDTO dto) {
		notice_Service.getNotice(dto);
		return "notice/updateNotice";
	}
	@RequestMapping("/updateNotice.do")
	public String updateNotice(@ModelAttribute("notice") NoticeDTO dto) {
		notice_Service.updateNotice(dto);
		return "redirect:/getNotice_List.do";
		// return "notice/getNoticeList";
	}
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeDTO dto) {
		notice_Service.deleteNotice(dto);
		return "redirect:/getNotice_List.do";
	}
	
	@RequestMapping(value = "/getNotice.do")
	public String getNotice(Model model, NoticeDTO dto) {
		model.addAttribute("notice", notice_Service.getNotice(dto)); // Model 占쏙옙占쏙옙 占쏙옙占쏙옙
		System.out.println("===> Mybatis占쏙옙 getNotice() 占쏙옙占� 처占쏙옙");
		return "notice/getNotice"; // View 占싱몌옙 占쏙옙占쏙옙
	}
	@RequestMapping(value = "getNotice_List.do")
	public String getNotice_List(Model model, NoticeDTO dto, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		System.out.println("===> Mybatis占쏙옙 getNoticeList() 占쏙옙占� 처占쏙옙");
		System.out.println("===========1111==========" + dto.getId());

		dto.setId((String) session.getAttribute("id"));

		model.addAttribute("notice_List", notice_Service.getNotice_List(dto));
		System.out.println("===> 占쏙옙트占싼뤄옙 getNoticeList() 占쏙옙占시놂옙占쏙옙占�");
		System.out.println(model);
		// return "redirect:getNoticeList.do";
		return "notice/getNotice_List"; // View 占싱몌옙 占쏙옙占쏙옙
	}
}
	

	


