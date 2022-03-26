package com.semi.flix.admin.board;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminBoardController {
	
	//@Autowired
	@Resource(name="adminboardService")
	AdminBoardService service;
	
	@RequestMapping(value="admin/board/writemain")
	String adminboard_main()
	{
		return "admin/board/writemain";
	}
	@RequestMapping(value="admin/board/listmain")
	String adminlist_main()
	{
		return "admin/board/listmain";
	}
	@RequestMapping(value="searchurl")
	@ResponseBody
	String searchurl(AdminBoardDto dto) {
		AdminBoardDto result = service.search(dto);
		System.out.println(result.getUrl());
		return result.getUrl();
	}
	@RequestMapping(value="/notfound")
	String notfound() {
		return "admin/board/NotFound";
	}
}
