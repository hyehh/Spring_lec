package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BSelectCommand;
import com.springlec.base0602.command.BUpdateCommand;
import com.springlec.base0602.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand selectCommand = null;
	private BCommand updateCommand = null;
	private BCommand deleteCommand = null;
	
	// 이 태그를 사용해야 di 사용가능!! 이게 servlet에 있는지 검사해줌!!
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand select, BCommand update, BCommand delete) { 
		this.listCommand = list;
		this.writeCommand = write;
		this.selectCommand = select;
		this.updateCommand = update;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
		
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		// model 에 request라는 이름으로 담기고 command에서 request를 map을 통해 푼다!
		model.addAttribute("request", request);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String select(HttpServletRequest request, Model model) {
		System.out.println("select()");
		
		model.addAttribute("request", request);
		selectCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		
		// model 에 request라는 이름으로 담기고 command에서 request를 map을 통해 푼다!
		model.addAttribute("request", request);
		updateCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
}
