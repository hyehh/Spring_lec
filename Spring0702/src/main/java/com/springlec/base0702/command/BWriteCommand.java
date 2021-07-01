package com.springlec.base0702.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0702.dao.BDao;

public class BWriteCommand implements BCommand {
	
	private BDao dao = null;
	
	@Autowired
	public void daoAuto(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest httpServletRequest = (HttpServletRequest) map.get("request");
		
		String bName = httpServletRequest.getParameter("bName");
		String bTitle = httpServletRequest.getParameter("bTitle");
		
		dao.write(bName, bTitle);
	}

}
