package com.springlec.base0302;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 이거 꼭 써주기
@RequestMapping("test")
public class MyController {
	
	@RequestMapping("/view1")
	public String view1() {
		return "test/view1";
	}
}
