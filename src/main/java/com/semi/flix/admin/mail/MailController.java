package com.semi.flix.admin.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.flix.admin.mail.MailDto;
import com.semi.flix.admin.user.UserDto;
import com.semi.flix.admin.user.UserService;

@Controller
public class MailController {
	@Resource(name="mailService")
	MailService service;
	@Resource(name="userService")
	UserService service2;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value="/admin/find", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> Mail_find(UserDto dto)
	{
		System.out.println("email : " + dto.getEmail());
		int id = service2.Mail_find(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(id != 0) {
			map.put("result", id+"");
		}
		else {
			map.put("result", "fail");
		}
		return map;
	}
	
	 @RequestMapping(value = "/admin/sendMail", method = RequestMethod.POST)
	    public String sendMailTest2(MailDto dto) throws Exception{
		 	
	        String subject = dto.getTitle();
	        String content = dto.getContent();
	        String from = dto.getEmail2();
	        String to = dto.getEmail1();
	        
	        System.out.println(dto);
	        
	        
	        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            
	            public void prepare(MimeMessage mimeMessage) throws Exception{
	                final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	                
	                mailHelper.setFrom(from);
	                mailHelper.setTo(to);
	                mailHelper.setSubject(subject);
	                mailHelper.setText(content, true);
	 
	            }
	        };
	        
	        try {    
	            mailSender.send(preparator);
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }        
	        service.insert(dto);
	        
	        return "redirect:/admin/list";
	        
	    }
	 
	 @RequestMapping(value="/admin/list", method=RequestMethod.GET)
		String mail_getList(Model model, MailDto dto)
		{
		 	System.out.println("toString");
			dto.setStart(dto.getPg()*10);
			
			List<MailDto> list = service.getList(dto);
			
			model.addAttribute("mailList", list);
			model.addAttribute("totalCnt", service.getTotal(dto));
			
			System.out.println(list);
			System.out.println(service.getTotal(dto));
			System.out.println("list--------------->" + list);
			return "admin/util/util_list"; //jsp 파일명
		}
	 
	 @RequestMapping(value="/admin/view", method=RequestMethod.GET)
		String Mail_View(String seq, Model model)
		{
			System.out.println("toString");
			MailDto dto = service.getView(seq);
			model.addAttribute("mailDto",dto);
			return "admin/util/mail_view";
		}
	 
}
