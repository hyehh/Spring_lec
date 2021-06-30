package com.springlec.base0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("index")
	public String goIndex() {
		return "index";
	}
	
	// Get 방식으로 받고, value는 student - action="student"
	@RequestMapping(method = RequestMethod.GET, value = "student")
	// 받을 때는 , 보내줄 때는
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequsetMethod.GET");
		
		// 변수명 id
		String id = httpServletRequest.getParameter("id");
		System.out.println("id " + id);
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	// Post 방식으로 받고, value는 student - action="student"
	@RequestMapping(method = RequestMethod.POST, value = "student")
	// 받을 때는 , 보내줄 때는
	public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
		System.out.println("RequsetMethod.POST");
		
		// 변수명 id
		String id = httpServletRequest.getParameter("id");
		System.out.println("id " + id);
		
		// modelandview는 새로 인스턴스 생성해줘야함
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/studentId");
		mv.addObject("studentId", id);
		
		return mv;
	}
	
	// Get 방식으로 받고, value는 student - action="student"
	@RequestMapping("studentGet")
	// 받을 때는 , 보내줄 때는
	public String goStudentGet(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequsetMethod.GET");
		
		// 변수명 id
		String id = httpServletRequest.getParameter("id");
		System.out.println("id " + id);
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	// value는 studentPost - action="studentPost"
	@RequestMapping("studentPost")
	// 받을 때는 , 보내줄 때는
	public String goStudentPost(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequsetMethod.POST");
		
		// 변수명 id
		String id = httpServletRequest.getParameter("id");
		System.out.println("id " + id);
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
}
