package com.semi.flix.admin.aniboard;

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
public class AniBoardController {
	
	//@Autowired
	@Resource(name="aniboardService")
	AniBoardService service;
	
	@RequestMapping(value="/admin/aniboard/list", method=RequestMethod.GET)
	String aniboard_list(Model model, AniBoardDto dto)
	{
		System.out.println("--------------------------------");
		System.out.println(dto.getKey() + ", " + dto.getKeyword());
		dto.setStart(dto.getPg()*10);
		
		List<AniBoardDto> list = service.getList(dto);
		System.out.println("-----------" + list);
		
		model.addAttribute("aniboardList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/aniboard/aniboard_list"; //jsp 파일명
	}
	
	//	/board/view?id=1
	@RequestMapping(value="/admin/aniboard/view", method=RequestMethod.GET)
	String aniboard_view(String board_seq, Model model)
	{
		System.out.println("toString");
		AniBoardDto dto = service.getView(board_seq);
		model.addAttribute("aniboardDto",dto);
		return "admin/aniboard/aniboard_view";
	}
	
	@RequestMapping(value="/admin/aniboard/write")
	String aniboard_write(Model model)
	{
		model.addAttribute("aniboardDto", new AniBoardDto());
		return "admin/aniboard/aniboard_write";
	}
	
	@RequestMapping(value="/admin/aniboard/save")
	String aniboard_save(AniBoardDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
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
			   dto.setAni_images(fileNameList.get(0));
		   else
			   dto.setAni_images(dto.getAni_images()); // 사진 변경 안함
		   
		if( dto.getBoard_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/aniboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/aniboard/delete")
	String aniboard_delete(AniBoardDto dto)
	{
		service.delete(dto.getBoard_seq());
		
		return "redirect:/admin/aniboard/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/aniboard/modify")
	String aniboard_modify(AniBoardDto dto, Model model)
	{
		System.out.println(service.getView(dto.getBoard_seq()));
		model.addAttribute( "aniboardDto", service.getView(dto.getBoard_seq()) );
		return "admin/aniboard/aniboard_write"; //write.jsp로 이동한다.
	}
	
}
