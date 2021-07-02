package com.springlec.base0802.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0802.command.BCommand;
import com.springlec.base0802.command.BListCommand;
import com.springlec.base0802.dao.BDao;

@Controller
public class BController {

	@Autowired
	private SqlSession sqlSession;
	
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
//		BDao dao = sqlSession.getMapper(BDao.class);
//		model.addAttribute("list", dao.listDao());
		
		command = new BListCommand();
		command.execute(sqlSession, model);
		
		return "addressbook/list";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "addressbook/write";
	}
	
	@RequestMapping("/writeAdd")
	public String writeAdd(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.writeDao(request.getParameter("name"), request.getParameter("telno"), 
				request.getParameter("address"), request.getParameter("email"), request.getParameter("relation"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		model.addAttribute("view", dao.viewDao(Integer.parseInt(request.getParameter("seqno"))));
		return "addressbook/view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.modifyDao(request.getParameter("name"), request.getParameter("telno"), 
				request.getParameter("address"), request.getParameter("email"), request.getParameter("relation"), 
				Integer.parseInt(request.getParameter("seqno")));
		model.addAttribute("view", dao.viewDao(Integer.parseInt(request.getParameter("seqno"))));
		return "addressbook/view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("seqno")));
		return "redirect:list";
	}
	
	@RequestMapping("/listQuery")
	public String listQuery(HttpServletRequest request, Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		model.addAttribute("list", dao.listQuery(request.getParameter("query"), request.getParameter("content")));
		return "addressbook/list";
	}
}
