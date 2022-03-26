package com.semi.flix.webtoon;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.comment.CommentDto;

@Controller
public class WebToonController {

	@Resource(name = "webtoonService")
	WebtoonService service;

	// 占쎌럲占쎈뙀 筌뤴뫖以� 占쎈읂占쎌뵠筌욑옙 占쎌뵠占쎈짗
	@RequestMapping("/webtoon/list")
	String webtoon_list(Model model, WebtoonDto dto) {
		dto.setPageSize(12);
		dto.setStart(dto.getPg() * dto.getPageSize());
		
		System.out.println("키키키키키키키킼키키키키킼키키키키킼키 : " + dto.getKey());
		
		List<WebtoonDto> list = service.getList(dto);
		int cnt = service.getTotal(dto);
		
		
		model.addAttribute("webtoonList", list);
		model.addAttribute("totalCnt", cnt);
		
		

		return "webtoon/webtoon_list";
	}

	// 占쎌럲占쎈뙀 占쎄맒占쎄쉭癰귣떯由� 占쎈읂占쎌뵠筌욑옙
	@RequestMapping("/webtoon/view")
	String webtoon_view(WebtoonDto dto, CommentDto Cdto, Model model) {

		Cdto.setPageSize(4);
		Cdto.setStart(Cdto.getPg() * Cdto.getPageSize());
		
		List<CommentDto> list = service.commentList(Cdto);
		WebtoonDto resultDto = service.getView(dto);
		int commentCnt = service.commentTotal(Cdto);
		model.addAttribute("webtoonDto", resultDto);
		model.addAttribute("commentList", list);
		model.addAttribute("commentTotalCnt", commentCnt);
		return "webtoon/webtoon_view";
	}

	
	@RequestMapping(value="/comment/write")
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
