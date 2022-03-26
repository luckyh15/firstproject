package com.semi.flix.enter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.comment.CommentDto;
import com.semi.flix.enter.EnterDto;

@Controller
public class EnterController {
	
	@Resource(name="enterService")
	EnterService service;
	
	//�쎒�댆 紐⑸줉 �럹�씠吏� �씠�룞
	@RequestMapping("/enter/list")
	String enter_list(Model model, EnterDto dto) {
		
		dto.setPageSize(12);
		dto.setStart( dto.getPg() * dto.getPageSize());
		
		List<EnterDto> list = service.getList(dto);
		int cnt = service.getTotal(dto);
		
		model.addAttribute("enterList",list);
		model.addAttribute("totalCnt",cnt);
		
		return "entertain/entertain_list";
	}
	
	//�쎒�댆 �긽�꽭蹂닿린 �럹�씠吏�
	@RequestMapping("/enter/view")
	String enter_view(EnterDto dto, CommentDto Cdto, Model model) {
		
		Cdto.setPageSize(4);
		Cdto.setStart(Cdto.getPg() * Cdto.getPageSize());
		
		List<CommentDto> list = service.commentList(Cdto);
		EnterDto resultDto = service.getView(dto);
		int commentCnt = service.commentTotal(Cdto);
		model.addAttribute("enterDto",resultDto);
		model.addAttribute("commentList", list);
		model.addAttribute("commentTotalCnt", commentCnt);
		return "entertain/entertain_view";
	}
	
	
//	@RequestMapping(value="/comment/write")
//	@ResponseBody 
//	HashMap<String, String> comment_write(CommentDto dto) {
//	System.out.println("comment_id : " + dto.getReview_seq()); 
//	
//	System.out.println("--------------> " + dto);
//	//if(dto.getComment_id().equals("")) 
//		service.commentinsert(dto); 
//	//else
//	//service.comment_update(dto);
//	
//	HashMap<String, String>map = new HashMap<String, String>();
//	map.put("result","success"); return map; 
//	}
	
}
