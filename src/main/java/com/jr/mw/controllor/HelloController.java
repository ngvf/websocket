package com.jr.mw.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created by 杨端端
 */
@Controller
@RequestMapping("/demo")
public class HelloController {
	
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "他来了");
		return "hello";
	}


}