package com.semi.flix.admin.review;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
	
	//@Autowired
	@Resource(name="reviewService")
	ReviewService service;
	
	@RequestMapping(value="/admin/review/list", method=RequestMethod.GET)
	String review_list(Model model, ReviewDto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<ReviewDto> list = service.getList(dto);
		
		model.addAttribute("reviewList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/review/review_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/review/view", method=RequestMethod.GET)
	String review_view(String seq, Model model)
	{
		System.out.println("toString");
		ReviewDto dto = service.getView(seq);
		model.addAttribute("reviewDto",dto);
		System.out.println("dto--------------->" + dto);
		return "admin/review/review_view";
	}
	
	
	@RequestMapping(value="/admin/review/delete")
	String review_delete(ReviewDto dto)
	{
		service.delete(dto.getSeq());
		
		return "redirect:/admin/review/list"; //글을쓰고나면 다시돌아가기
	}

}
