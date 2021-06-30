package com.springlec.base0502;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			// redirect는 키워드임! 저렇게 보내줘야 하는 방식임!(requestmapping으로 redirect해라!)
			return "redirect:studentOK";
		}else {
			return "redirect:studentNG";
		}
	}
	
	// redirect:studentOK 여기임
	@RequestMapping("studentOK")
	public String ok(Model model) {
		return "student/studentOK";
	}
	
	// redirect:studentNG 여기임
	@RequestMapping("studentNG")
	public String ng(Model model) {
		return "student/studentNG";
	}
}
