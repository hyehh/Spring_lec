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
			// redirect�� Ű������! ������ ������� �ϴ� �����!(requestmapping���� redirect�ض�!)
			return "redirect:studentOK";
		}else {
			return "redirect:studentNG";
		}
	}
	
	// redirect:studentOK ������
	@RequestMapping("studentOK")
	public String ok(Model model) {
		return "student/studentOK";
	}
	
	// redirect:studentNG ������
	@RequestMapping("studentNG")
	public String ng(Model model) {
		return "student/studentNG";
	}
}
