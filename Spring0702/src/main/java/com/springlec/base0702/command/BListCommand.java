package com.springlec.base0702.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0702.dao.BDao;
import com.springlec.base0702.dto.BDto;

public class BListCommand implements BCommand {

	private BDao dao = null;
	
	@Autowired
	public void daoAuto(BDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		ArrayList<BDto> dto = dao.list();
		model.addAttribute("list", dto);
	}

}
