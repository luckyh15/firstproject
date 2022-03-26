package com.semi.flix.Q_A;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.semi.flix.admin.adminQ_A.AdminQ_AService;
import com.semi.flix.admin.admincomment.AdminCommentDto;

@Controller
@SessionAttributes("Q_A")
public class Q_A_Controller {
	
	@Resource(name="adminQ_AService")
	AdminQ_AService service;
	
	@Autowired
	private Q_A_Service q_a_Service;

	@RequestMapping(value = "go_insertQ_A.do")
	public String go_insertQ_A() throws IOException {
		return "q_a/insertQ_A";

	}

	@RequestMapping(value = "insertQ_A.do")
	public String insertQ_A(Q_A_DTO dto) throws IOException {
		System.out.println("[-----------------------]" + dto.getUser_seq());
		q_a_Service.insertQ_A(dto);
		return "redirect:/getQ_A_List.do";
	}

	@RequestMapping(value = "go_updateQ_A.do")
	public String go_updateQ_A(Q_A_DTO dto) {
		q_a_Service.getQ_A(dto);
		return "q_a/updateQ_A";
	}

	@RequestMapping("updateQ_A.do")
	public String updateQ_A(@ModelAttribute("q_a") Q_A_DTO dto) {
		q_a_Service.updateQ_A(dto);
		return "redirect:/getQ_A_List.do";
		// return "notice/getNoticeList";
	}

	@RequestMapping("deleteQ_A.do")
	public String deleteQ_A(Q_A_DTO dto) {
		q_a_Service.deleteQ_A(dto);
		return "redirect:/getQ_A_List.do";
	}

	@RequestMapping(value = "getQ_A.do")
	public String getQ_A(Model model, Q_A_DTO dto) {
		model.addAttribute("q_a", q_a_Service.getQ_A(dto)); // Model 占쏙옙占쏙옙 占쏙옙占쏙옙
		System.out.println("===> Mybatis占쏙옙 getNotice() 占쏙옙占� 처占쏙옙");
		
		AdminCommentDto tempDto = new AdminCommentDto();
		tempDto.setQ_a_seq(dto.getQ_a_seq());
		List<AdminCommentDto> list = service.getCommentList(tempDto);
		System.out.println(list);
		model.addAttribute("q_aList",list);
		return "q_a/getQ_A"; // View 占싱몌옙 占쏙옙占쏙옙
	}

	@RequestMapping(value = "getQ_A_List.do")
	public String getQ_A_List(Model model, Q_A_DTO dto, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		System.out.println("===> Mybatis占쏙옙 getNoticeList() 占쏙옙占� 처占쏙옙");
		System.out.println("===========1111==========" + dto.getUser_seq());

		dto.setUser_seq((String) session.getAttribute("userseq"));

		model.addAttribute("q_a_List", q_a_Service.getQ_A_List(dto));
		System.out.println("===> 占쏙옙트占싼뤄옙 getNoticeList() 占쏙옙占시놂옙占쏙옙占�");
		System.out.println(model);
		// return "redirect:getNoticeList.do";
		return "q_a/getQ_A_List"; // View 占싱몌옙 占쏙옙占쏙옙
	}
}
	