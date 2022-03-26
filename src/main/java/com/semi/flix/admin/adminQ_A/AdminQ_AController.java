package com.semi.flix.admin.adminQ_A;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.admin.admincomment.AdminCommentDto;

@Controller
public class AdminQ_AController {
	
	//@Autowired
	@Resource(name="adminQ_AService")
	AdminQ_AService service;
	
	@RequestMapping(value="/admin/q_a/list", method=RequestMethod.GET)
	String adminQ_A_list(Model model, AdminQ_ADto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<AdminQ_ADto> list = service.getList(dto);
		
		model.addAttribute("q_a_list", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/q_a/q_a_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/q_a/view", method=RequestMethod.GET)
	String adminQ_A_view(String seq, Model model)
	{
		System.out.println("toString");
		AdminQ_ADto dto = service.getView(seq);
		model.addAttribute("q_aDto",dto);
		return "admin/q_a/q_a_view";
	}
	
	@RequestMapping(value="/admin/q_a/delete")
	String adminQ_A_delete(AdminQ_ADto dto, String q_a_seq)
	{
		System.out.println("---------"+ dto.getSeq());
		service.delete(q_a_seq);
		
		return "redirect:/admin/q_a/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/comment/write")
	@ResponseBody
	HashMap<String, String> comment_write(AdminCommentDto dto)
	{
		System.out.println("seq: " + dto.getSeq());
		service.comment_insert(dto);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map; 
	}
	
	@RequestMapping(value="/admin/comment/list")
	@ResponseBody
	List<AdminCommentDto> comment_list(AdminCommentDto dto)
	{
		System.out.println("board_id : " + dto.getSeq());
		List<AdminCommentDto> list = service.getCommentList(dto);
		return list; 
	}
	
	@RequestMapping(value="/admin/comment/getView")
	@ResponseBody
	AdminCommentDto comment_getView(AdminCommentDto dto)
	{
		System.out.println("board_id : " + dto.getSeq());
		AdminCommentDto resultDto = service.getCommentView(dto);
		return resultDto; 
	}
	
	
	@RequestMapping(value="/admin/comment/delete")
	@ResponseBody
	HashMap<String, String> comment_delete(AdminCommentDto dto)
	{
		service.comment_delete(dto);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map; 
	}
}
