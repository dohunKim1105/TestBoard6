package com.example.controller.test;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/test")
public class test {

	@RequestMapping(value = {"/", "swiperSlide"})
	public void swiperSlide() {
		System.out.println("controller : swiperSlide");
		
		
	}
}
