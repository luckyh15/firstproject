package com.semi.flix.admin.toonboard;

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
public class ToonBoardController {
	
	//@Autowired
	@Resource(name="toonboardService")
	ToonBoardService service;
	
	@RequestMapping(value="/admin/toonboard/list", method=RequestMethod.GET)
	String toonboard_list(Model model, ToonBoardDto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<ToonBoardDto> list = service.getList(dto);
		
		model.addAttribute("toonboardList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/toonboard/toonboard_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/toonboard/view", method=RequestMethod.GET)
	String toonboard_view(String board_seq, Model model)
	{
		System.out.println("toString");
		ToonBoardDto dto = service.getView(board_seq);
		model.addAttribute("toonboardDto",dto);
		return "admin/toonboard/toonboard_view";
	}
	
	@RequestMapping(value="/admin/toonboard/write")
	String toonboard_write(Model model)
	{
		model.addAttribute("toonboardDto", new ToonBoardDto());
		return "admin/toonboard/toonboard_write";
	}
	
	@RequestMapping(value="/admin/toonboard/save")
	String toonboard_save(ToonBoardDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
	{
		System.out.println("-------------->" + dto);
		System.out.println("----------------------"+multi.getFile("upload"));
		
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("upload"));
		   
		   List<String> fileNameList = new ArrayList<String>();
		   String path = req.getServletContext().getRealPath("/");
		   System.out.println("물리적 위치값 : " + path);
		   AdminFileUploadUtil.upload(path, multiList, fileNameList);
		   
		   if(fileNameList.size() > 0)
			   dto.setToon_images(fileNameList.get(0));
		   else
			   dto.setToon_images(dto.getToon_images());
		   
		if( dto.getBoard_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/toonboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/toonboard/delete")
	String toonboard_delete(ToonBoardDto dto)
	{
		service.delete(dto.getBoard_seq());
		
		return "redirect:/admin/toonboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/toonboard/modify")
	String toonboard_modify(ToonBoardDto dto, Model model)
	{
		System.out.println(service.getView(dto.getBoard_seq()));
		model.addAttribute( "toonboardDto", service.getView(dto.getBoard_seq()) );
		return "admin/toonboard/toonboard_write"; //write.jsp로 이동한다.
	}
	
}
