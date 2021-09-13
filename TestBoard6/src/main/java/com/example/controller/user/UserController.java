package com.example.controller.user;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;


import com.example.dto.user.*;
import com.example.service.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = {"/", "login"})
    public String login(
    		Model model,
    		@RequestParam(value = "id") String id,
			@RequestParam(value = "pw") String pw,
			HttpSession session){
    	System.out.println("controller : login");
    	
    	UserDto userDto = new UserDto();
    	userDto.setId(id);
    	userDto.setPw(pw);
    	
    	userDto = userService.idPwCheck(id, pw);
    	
    	if(userDto == null) {
    		System.out.println("로그인 실패");
    		return "/user/login";
    	}else {
    		System.out.println("아이디 패스워드 체크 확인");
    		System.out.println("user_name : " + userDto.getUser_name());
    		System.out.println("id : " + userDto.getId());
    		System.out.println("pw : " + userDto.getPw());
    	}
    	
    	session.setAttribute("user", userDto);
  
    	return "redirect:/bbs/list";
    }
    
    @RequestMapping(value = {"/", "login"})
    public void login(){
    	System.out.println("controller : 로그인 페이지");
    }
    
    @RequestMapping(value = {"/", "logout"})
    public String logout(HttpSession session){
    	System.out.println("controller : logout");
    	
    	session.removeAttribute("user");
    	return "redirect:/bbs/list";
    }
    
}