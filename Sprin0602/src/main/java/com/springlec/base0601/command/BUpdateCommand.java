package com.springlec.base0601.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BDao;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		// 이렇게 해야 데이터 값을 받아 올 수 있음
		// key값, value값 - 데이터 값 (숫자, 문자 여러가지 올 수 있어서 object 타입 선언)
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bId = request.getParameter("bId");

		// 즉, 위의 방식처럼 model이 request로 감싸져 있음
		// 푸는 방식은 map을 사용해 푸는 것임
		
		BDao dao = new BDao();
		dao.update(bName, bTitle, bContent, Integer.parseInt(bId));
		
	}

}
