package com.semi.flix.admin.member;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.Visit.VisitDto;
import com.semi.flix.Visit.VisitService;
import com.semi.flix.admin.adminQ_A.AdminQ_ADto;
import com.semi.flix.admin.adminQ_A.AdminQ_AService;
import com.semi.flix.admin.mail.MailDto;
@Controller
public class AdminMemberController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Resource(name="adminmemberService")
	AdminMemberService adminmemberService;
	@Resource(name="visitService")
	VisitService visitService;
	@Resource(name="adminQ_AService")
	AdminQ_AService q_a_Service;
	
	@RequestMapping("/admin/adminmember/join")
	String adminmember_register(Model model)
	{
		AdminMemberDto dto = new AdminMemberDto();
		model.addAttribute("adminmemberDto", dto);
		return "admin/member/adminmember_register";
	}
	
	@RequestMapping("/admin/adminmember/myinfo")
	String adminmember_myinfo(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("adminuserid");
		if(userid==null)
			return "redirect:/admin/adminindex";
		
		AdminMemberDto dto = new AdminMemberDto();
		dto.setUserid(userid);
		
		AdminMemberDto resultDto = adminmemberService.getInfo(dto);
		model.addAttribute("adminmemberDto", resultDto);
		return "admin/member/adminmember_view";
	}
	
	@RequestMapping("/admin/adminmember/isDuplicate")
	@ResponseBody	//Ajax�슂泥��떆 �뜲�씠�꽣媛� 異쒕젮�뤌�빞 �븳�떎. jsp �씠�룞�쓣 留됰뒗�떎.
					//�옄諛� 媛앹껜瑜� json�삎�깭濡� �쟾�솚�떆耳쒖꽌 諛섑솚�븳�떎.
	public HashMap<String, String> adminmember_isDuplicate(AdminMemberDto dto)
	{
		System.out.println("userid : " + dto.getUserid());
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("result", adminmemberService.isDuplicate(dto)+"");

		return map;
	}
	
	@RequestMapping(value="/admin/adminmember/insert", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public HashMap<String, String> adminmember_insert(AdminMemberDto dto)
	{
		System.out.println("userid : " + dto.getUserid());
		
		if( dto.getId().equals("") )
			adminmemberService.insert(dto);
		else
			adminmemberService.update(dto);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/admin/adminmember/login_proc")
	@ResponseBody
	public HashMap<String, String> adminmember_login_proc(AdminMemberDto dto, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		AdminMemberDto resultDto = adminmemberService.getInfo(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		
		System.out.println(resultDto);
		
		if(resultDto==null)
		{
			map.put("flag", "2");
		}
		else
		{
			if(resultDto.getPassword().equals(dto.getPassword()))
			{
				map.put("flag", "1");	//濡쒓렇�씤 �꽦怨듭떆 �꽭�뀡�뿉 �젙蹂대�� ���옣�븳�떎.
				session.setAttribute("id", resultDto.getId());
				session.setAttribute("adminuserid", resultDto.getUserid());
				session.setAttribute("username", resultDto.getUsername());///////
				session.setAttribute("email", resultDto.getEmail());
				session.setAttribute("phone", resultDto.getPhone());
			}
			else
			{
				map.put("flag", "3");
			}
		}
		
		return map;
	}
	
	@RequestMapping(value="/admin/adminmember/logout")
	public String adminmember_logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/admin/adminindex";
	}
	
	@RequestMapping(value="/admin/adminmember/findId")
	public String adminmember_findId(HttpServletRequest request)
	{
		return "admin/member/adminmember_findId";
	}
	
	@RequestMapping(value="/admin/adminmember/findPassword")
	public String adminmember_findPassword(HttpServletRequest request)
	{
		return "admin/member/adminmember_findPassword";
	}
	
	@RequestMapping(value="/admin/adminmember/findId_proc")
	@ResponseBody
	public HashMap<String,String> adminmember_findId_proc(AdminMemberDto dto)
	{
		// �씠由�, �씠硫붿씪,, �쟾�솕踰덊샇 �솗�떊
		System.out.println("[adminmember_findId_proc----->]"+dto);
		AdminMemberDto findDto = adminmemberService.findId(dto);
		System.out.println(findDto);
		HashMap map = new HashMap<String, String>();
		System.out.println(map);
		
		if(findDto==null)
			map.put("result", "fail");
		else {
			map.put("result", findDto.getUserid());
			map.put("adminuserid", findDto.getUserid());
			map.put("username", findDto.getUsername());
		}
		return map;
	}
	
	@RequestMapping(value="/admin/adminmember/findPassword_proc")
	@ResponseBody
	public HashMap<String,String> adminmember_findPassword_proc(AdminMemberDto dto)
	{
		AdminMemberDto findDto = adminmemberService.findPassword(dto);
		HashMap map = new HashMap<String, String>();
		if(findDto==null)
			map.put("result", "fail");
		else
		{
			map.put("result", findDto.getPassword());
			map.put("adminuserid", findDto.getUserid());
			map.put("username", findDto.getUsername());
		}
		return map;
	}
	//http://localhost:8080/flixpedia/admin/adminmember/juso
	@RequestMapping(value="/admin/adminmember/update")
	@ResponseBody
	public HashMap<String,String> adminmember_update(AdminMemberDto dto)
	{
		adminmemberService.update(dto);
		HashMap map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/admin/adminindex")
	   public String adminmember_index(HttpServletRequest request)
	   {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("adminuserid");
		System.out.println("----------------------->" + userid);
		
		if(userid==null) {
			return "/admin/adminindex";
		} else {
			return "redirect:/admin/adminhome";
		}
	   }
	
	@RequestMapping(value="/admin/adminhome", method=RequestMethod.GET)
	   public String adminmember_home(Model model, AdminMemberDto dto, VisitDto dto2, AdminQ_ADto dto3)
	   {
		  model.addAttribute("totalCnt", visitService.getTotal(dto2));
		  System.out.println("-----------------1111----------"+visitService.getTotal(dto2));
		  model.addAttribute("cnt", adminmemberService.cnt(dto));
		  model.addAttribute("user", adminmemberService.user(dto));
		  model.addAttribute("category", adminmemberService.category(dto));
		  model.addAttribute("dataList", visitService.getMonth());
		  model.addAttribute("q_a_cnt", q_a_Service.getTotal(dto3));
	      return "/admin/adminhome";
	   }
	@RequestMapping("/admin/adminmember/juso")
	String jusoPopup() {
		return "admin/adminmember/juso";
	}
	@RequestMapping(value="/admin/mailsend")
	   public String mailSend(Model model)
	   {
	
		model.addAttribute("mailDto", new MailDto());
		
	      return "/admin/util/mailSend";
	   }
	
}
