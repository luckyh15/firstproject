package com.semi.flix.admin.enterboard;

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
public class EnterBoardController {
	
	//@Autowired
	@Resource(name="enterboardService")
	EnterBoardService service;
	
	@RequestMapping(value="/admin/enterboard/list", method=RequestMethod.GET)
	String enterboard_list(Model model, EnterBoardDto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<EnterBoardDto> list = service.getList(dto);
		
		model.addAttribute("enterboardList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/enterboard/enterboard_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/enterboard/view", method=RequestMethod.GET)
	String enterboard_view(String board_seq, Model model)
	{
		System.out.println("toString");
		EnterBoardDto dto = service.getView(board_seq);
		model.addAttribute("enterboardDto",dto);
		return "admin/enterboard/enterboard_view";
	}
	
	@RequestMapping(value="/admin/enterboard/write")
	String enterboard_write(Model model)
	{
		model.addAttribute("enterboardDto", new EnterBoardDto());
		return "admin/enterboard/enterboard_write";
	}
	
	@RequestMapping(value="/admin/enterboard/save")
	String enterboard_save(EnterBoardDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
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
			   dto.setEnter_images(fileNameList.get(0));
		   else
			   dto.setEnter_images(dto.getEnter_images()); // 사진 변경 안함
		   
		if( dto.getBoard_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/enterboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/enterboard/delete")
	String enterboard_delete(EnterBoardDto dto)
	{
		service.delete(dto.getBoard_seq());
		
		return "redirect:/admin/enterboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/enterboard/modify")
	String enterboard_modify(EnterBoardDto dto, Model model)
	{
		System.out.println(service.getView(dto.getBoard_seq()));
		model.addAttribute( "enterboardDto", service.getView(dto.getBoard_seq()) );
		return "admin/enterboard/enterboard_write"; //write.jsp로 이동한다.
	}
	
}
