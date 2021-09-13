package com.example.controller.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.board.*;
import com.example.service.*;

@Controller
@RequestMapping(value = "/bbs")
public class PagingController {

	@Autowired
	private PagingService pagingService;
	
	@GetMapping("/list")
	public String boardList(PagingDto pagingDto, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		System.out.println("controller : boardList");
		
		int total = pagingService.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		pagingDto = new PagingDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", pagingDto);
		model.addAttribute("viewAll", pagingService.selectBoard(pagingDto.getStart()-1, pagingDto.getCntPerPage()));
		return "/bbs/list";
	}

}
