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
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand deleteCommand = null;
	JdbcTemplate template = null;
	
	@Autowired
	public void setTemplete(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@Autowired
	public void commandAuto(BCommand list, BCommand write, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		listCommand.execute(model);
		return "list";
	}
	
	@RequestMapping("write")
	public String write() {
		return "write";
	}
	
	@RequestMapping("writeAdd")
	public String writeAdd(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		writeCommand.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		return "redirect:list";
	}
	
}
