package com.example.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {
	
	@RequestMapping(value="/")
	public String base() {
		System.out.println("base");
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/test1")
	public void test1() {
		System.out.println("controller : test1");
	}
	
	@RequestMapping(value="/test2")
	public void test2() {
		System.out.println("controller : test2");
	}
}
