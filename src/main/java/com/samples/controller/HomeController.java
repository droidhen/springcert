package com.samples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value="/haha")
	public ModelAndView index(HttpServletRequest request,
            HttpServletResponse response){
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
