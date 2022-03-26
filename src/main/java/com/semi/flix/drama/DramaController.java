package com.semi.flix.drama;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.comment.CommentDto;

@Controller
public class DramaController {
	
	@Resource(name="dramaService")
	DramaService service;
	
	@RequestMapping("/drama/list")
	String Drama_list(Model model,DramaDto dto) {
		
		dto.setPageSize(12);
		dto.setStart( dto.getPg() * dto.getPageSize());
		
	
		List<DramaDto> list = service.getList(dto);
		int cnt = service.getTotal(dto);
		
		model.addAttribute("dramaList",list);
		model.addAttribute("totalCnt",cnt);
		
		return "drama/drama_list";
	}
	
	@RequestMapping("/drama/view")
	String Drama_view(DramaDto dto,CommentDto Cdto,Model model) {
		Cdto.setPageSize(4);
		Cdto.setStart(Cdto.getPg() * Cdto.getPageSize());
		
		List<CommentDto> list = service.commentList(Cdto);
		DramaDto resultDto = service.getView(dto);
		int commentCnt = service.commentTotal(Cdto);
		model.addAttribute("dramaDto",resultDto);
		model.addAttribute("commentList", list);
		model.addAttribute("commentTotalCnt", commentCnt);
		return "drama/drama_view";
	}
	
	@RequestMapping(value="/dramaComment/write")
	@ResponseBody 
	HashMap<String, String> comment_write(CommentDto dto) {
	System.out.println("comment_id : " + dto.getReview_seq()); 
	
	System.out.println("--------------> " + dto);
	//if(dto.getComment_id().equals("")) 
		service.commentinsert(dto); 
	//else
	//service.comment_update(dto);
	
	HashMap<String, String>map = new HashMap<String, String>();
	map.put("result","success"); return map; 
	}
	
	
	
}
