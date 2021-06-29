package com.springlec.base0301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */

// @Controller 이거 적혀있어야 진짜 Controller!

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// .jsp 안써도 됨!
	@RequestMapping("board/view")
	public String view() {
		return "board/view";
	}
	
	// 요즘 방식 
	@RequestMapping("board/content")
	public String content(Model model) {
		// content.jsp한테 데이터를 주려면 Model model 이게 필요함
		// 안드로이드 생각하면 intent 라고 생각하면 됨!
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	// 예전 방식 
	@RequestMapping("board/reply")
	public ModelAndView reply() {
		// return 값이 ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", 30);
		modelAndView.setViewName("board/reply");
		return modelAndView;
	}
	
	
}
