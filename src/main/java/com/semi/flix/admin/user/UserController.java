package com.semi.flix.admin.user;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.semi.flix.admin.member.AdminMemberDto;

@Controller
public class UserController {
	
	//@Autowired
	@Resource(name="userService")
	UserService service;
	
	@RequestMapping(value="/admin/user/list", method=RequestMethod.GET)
	String user_list(Model model, UserDto dto)
	{
		System.out.println("toString");
		dto.setStart(dto.getPg()*10);
		
		List<UserDto> list = service.getList(dto);
		
		model.addAttribute("userList", list);
		model.addAttribute("totalCnt", service.getTotal(dto));
		System.out.println("list---------------->" + list);
		return "admin/user/user_list"; //jsp 파일명
	}
	
	@RequestMapping(value="/admin/user/view", method=RequestMethod.GET)
	String user_view(String user_seq, Model model)
	{
		System.out.println("toString");
		UserDto dto = service.getView(user_seq);
		model.addAttribute("userDto",dto);
		return "admin/user/user_view";
	}
	
	@RequestMapping(value="/admin/user/write")
	String user_write(Model model)
	{
		model.addAttribute("userDto", new UserDto());
		return "admin/user/user_write";
	}
	
	@RequestMapping(value="/admin/user/save")
	String user_save(UserDto dto, HttpServletRequest req, MultipartHttpServletRequest multi )
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
			   dto.setUser_images(fileNameList.get(0));
		   else
			   dto.setUser_images(dto.getUser_images()); // 사진 변경 안함
		   
		if( dto.getUser_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		return "redirect:/admin/user/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/user/delete")
	String user_delete(UserDto dto)
	{
		service.delete(dto.getUser_seq());
		
		return "redirect:/admin/user/list"; //글을쓰고나면 다시돌아가기
	}
	
	@RequestMapping(value="/admin/user/modify")
	String user_modify(UserDto dto, Model model)
	{
		System.out.println(service.getView(dto.getUser_seq()));
		model.addAttribute( "userDto", service.getView(dto.getUser_seq()) );
		return "admin/user/user_write"; //write.jsp로 이동한다.
	}
	
	@RequestMapping("/admin/user/isDuplicate")
	@ResponseBody	//Ajax요청시 데이터가 출려돼야 한다. jsp 이동을 막는다.
					//자바 객체를 json형태로 전환시켜서 반환한다.
	public HashMap<String, String> user_isDuplicate(UserDto dto)
	{
		System.out.println("user_id : " + dto.getUser_id());
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("result", service.isDuplicate(dto)+"");

		return map;
	}
	
	@RequestMapping(value="/admin/user/insert", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public HashMap<String, String> user_insert(UserDto dto)
	{
		System.out.println("userid : " + dto.getUser_id());
		
		if( dto.getUser_seq().equals("") )
			service.insert(dto);
		else
			service.update(dto);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/admin/user/update")
	@ResponseBody
	public HashMap<String,String> user_update(UserDto dto)
	{
		service.update(dto);
		HashMap map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/admin/user/juso")
	String jusoPopup() {
		return "admin/user/juso";
	}
	
}
