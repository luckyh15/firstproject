package com.semi.flix.admin.movieboard;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.semi.flix.admin.common.AdminFileUploadUtil;

@Controller
public class MovieBoardController {
	
	//@Autowired
	@Resource(name="movieboardService")
	MovieBoardService service;
	
	@RequestMapping(value="/admin/movieboard/list", method=RequestMethod.GET)
	String movieboard_list(Model model, MovieBoardDto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<MovieBoardDto> list = service.getList(dto);
		
		model.addAttribute("movieboardList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/movieboard/movieboard_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/movieboard/view", method=RequestMethod.GET)
	String movieboard_view(String board_seq, Model model)
	{
		System.out.println("toString");
		MovieBoardDto dto = service.getView(board_seq);
		model.addAttribute("movieboardDto",dto);
		return "admin/movieboard/movieboard_view";
	}
	
	@RequestMapping(value="/admin/movieboard/write")
	String movieboard_write(Model model)
	{
		model.addAttribute("movieboardDto", new MovieBoardDto());
		return "admin/movieboard/movieboard_write";
	}
	
	@RequestMapping(value="/admin/movieboard/save")
	String movieboard_save(MovieBoardDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
	{
		System.out.println("-------------->" + dto);
		
		System.out.println("----------------------"+multi.getFile("upload"));
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("upload"));
		   
		   List<String> fileNameList = new ArrayList<String>();
		   String path = req.getServletContext().getRealPath("/");
		   System.out.println("물리적 위치값 : " + path);
		   AdminFileUploadUtil.upload(path, multiList, fileNameList);
		   
		   // 사진 변경
		   if(fileNameList.size() > 0)
			   dto.setMovie_images(fileNameList.get(0));
		   else
			   dto.setMovie_images(dto.getMovie_images()); // 사진 변경 안함
		   
		if( dto.getBoard_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/movieboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/movieboard/delete")
	String movieboard_delete(MovieBoardDto dto)
	{
		service.delete(dto.getBoard_seq());
		
		return "redirect:/admin/movieboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/movieboard/modify")
	String movieboard_modify(MovieBoardDto dto, Model model)
	{
		System.out.println(service.getView(dto.getBoard_seq()));
		model.addAttribute( "movieboardDto", service.getView(dto.getBoard_seq()) );
		return "admin/movieboard/movieboard_write"; //write.jsp로 이동한다.
	}
	
}
