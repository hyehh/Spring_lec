package com.springlec.base0702.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0702.command.BCommand;
import com.springlec.base0702.command.BDeleteCommand;
import com.springlec.base0702.command.BListCommand;
import com.springlec.base0702.command.BWriteCommand;
import com.springlec.base0702.util.Constant;

@Controller
public class BController {

	BCommand command = null;
	JdbcTemplate template = null;
	
	@Autowired
	public void setTemplete(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("write")
	public String write() {
		return "write";
	}
	
	@RequestMapping("writeAdd")
	public String writeAdd(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
}
