package com.walye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walye.entity.User;
import com.walye.service.IUserService;

@Controller
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping("/finduser")
	public ModelAndView finduser(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) long userId) {
		User user = userService.findUserById(userId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/success");
		mv.addObject("user", user);
		return mv;
	}

}
