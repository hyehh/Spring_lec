package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BDeleteCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BSelectCommand;
import com.springlec.base0601.command.BUpdateCommand;
import com.springlec.base0601.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		// model 에 request라는 이름으로 담기고 command에서 request를 map을 통해 푼다!
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String select(HttpServletRequest request, Model model) {
		System.out.println("select()");
		
		model.addAttribute("request", request);
		command = new BSelectCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		
		// model 에 request라는 이름으로 담기고 command에서 request를 map을 통해 푼다!
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
