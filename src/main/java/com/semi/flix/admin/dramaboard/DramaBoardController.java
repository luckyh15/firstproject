package com.semi.flix.admin.dramaboard;

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
public class DramaBoardController {
	
	//@Autowired
	@Resource(name="dramaboardService")
	DramaBoardService service;
	
	@RequestMapping(value="/admin/dramaboard/list", method=RequestMethod.GET)
	String dramaboard_list(Model model, DramaBoardDto dto)
	{

		dto.setStart(dto.getPg()*10);
		
		List<DramaBoardDto> list = service.getList(dto);
		
		model.addAttribute("dramaboardList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/dramaboard/dramaboard_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/dramaboard/view", method=RequestMethod.GET)
	String dramaboard_view(String board_seq, Model model)
	{
		System.out.println("toString");
		DramaBoardDto dto = service.getView(board_seq);
		model.addAttribute("dramaboardDto",dto);
		return "admin/dramaboard/dramaboard_view";
	}
	
	@RequestMapping(value="/admin/dramaboard/write")
	String dramaboard_write(Model model)
	{
		model.addAttribute("dramaboardDto", new DramaBoardDto());
		return "admin/dramaboard/dramaboard_write";
	}
	
	@RequestMapping(value="/admin/dramaboard/save")
	String dramaboard_save(DramaBoardDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
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
			   dto.setDrama_images(fileNameList.get(0));
		   else
			   dto.setDrama_images(dto.getDrama_images()); // 사진 변경 안함
		   
		if( dto.getBoard_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/dramaboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/dramaboard/delete")
	String dramaboard_delete(DramaBoardDto dto)
	{
		service.delete(dto.getBoard_seq());
		
		return "redirect:/admin/dramaboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/dramaboard/modify")
	String dramaboard_modify(DramaBoardDto dto, Model model)
	{
		System.out.println(service.getView(dto.getBoard_seq()));
		model.addAttribute( "dramaboardDto", service.getView(dto.getBoard_seq()) );
		return "admin/dramaboard/dramaboard_write"; //write.jsp로 이동한다.
	}
	
}
