package com.example.controller.board;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.board.*;
import com.example.dto.user.*;
import com.example.service.*;

@Controller
@RequestMapping(value = "/bbs")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = { "/", "list" })
	public void boardList(Model model, HttpServletRequest request) {
		System.out.println("controller : list");

		List<BoardDto> list = boardService.boardListAll();
		model.addAttribute("boardList", list);
	}

	@GetMapping(value = { "/", "write" })
	public String boardWrite(HttpSession session) {
		System.out.println("controller : write get");
		
		if(session == null || session.getAttribute("user") == null) {
			System.out.println("session is null");
			return "redirect:/user/login";
		}else {
			System.out.println("session is not null");
			return "/bbs/write";
		}
	}

	@PostMapping(value = { "/", "write" })
	public String boardWrite(
			HttpSession session,
			@RequestParam(value = "title") String title, 
			@RequestParam(value = "content") String content) {
		System.out.println("controller : write post");

		//세션
		UserDto userDto = (UserDto) session.getAttribute("user");
		
		//넘어온 값으로 boardDto 생성
		BoardDto writeDto = new BoardDto(title, content, userDto.user_name, 0);
		
		int result = boardService.boardWrite(writeDto);
		writeDto.setNum(result);
		
		return "redirect:/bbs/detail?num=" + result;
	}

	@RequestMapping(value = { "/", "detail" })
	public void boardDetail(Model model, int num) {
		System.out.println("controller : boardDetail");

		int updateResult = boardService.boardCntPlus(num);
		
		if (updateResult == 1) {
			System.out.println("updateResult == 1");
			BoardDto resultBoardDto = boardService.boardDetail(num);
			model.addAttribute("boardDto", resultBoardDto);
			
			List<FileDto> fileDtoList = fileService.selectFile(resultBoardDto.getNum());
			System.out.println("fileDtoList size : " + fileDtoList.size());
			model.addAttribute("fileList", fileDtoList);
		} else {
			System.out.println("update ERROR");
		}
	}

	@RequestMapping(value = { "/", "modify" })
	public void boardModify(Model model, int num) {
		System.out.println("controller : modify");

		BoardDto boardDto = boardService.boardDetail(num);
		model.addAttribute("boardDto", boardDto);
		
		System.out.println("num : " + boardDto.getNum());
		System.out.println("title : " + boardDto.getTitle());
		System.out.println("content : " + boardDto.getContent());
	}

	@RequestMapping(value = { "/", "update" })
	public String boardUpdate(Model model, 
			@RequestParam(value = "num") String numStr,
			@RequestParam(value = "writer") String writer, 
			@RequestParam(value = "title") String title, 
			@RequestParam(value = "content") String content) {
		System.out.println("controller : update");
		
		int num = Integer.parseInt(numStr);
		System.out.println("num : " + num);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		BoardDto updateDto = new BoardDto();
		updateDto.setNum(num);
		updateDto.setTitle(title);
		updateDto.setContent(content);

		int updateResult = boardService.boardUpdate(updateDto);

		if (updateResult == 1) {
			System.out.println("updateResult == 1");
			BoardDto resultBoardDto = boardService.boardDetail(num);
			model.addAttribute("boardDto", resultBoardDto);
		} else {
			System.out.println("update ERROR");
		}
		System.out.println("num : " + num);
		return "/bbs/detail";
	}
	
	@RequestMapping(value= {"/", "delete"})
	public String boardDelete(HttpSession session,
			@RequestParam(value = "num") int num) {
		System.out.println("contoller : delete");
		
		if(session == null || session.getAttribute("user") == null) {
			System.out.println("session is null");
			return "redirect:/user/login";
		}else {
			System.out.println("session is not null");
			
			BoardDto boardDto = boardService.boardDetail(num);
			String writer = boardDto.getWriter();
			
			UserDto userDto = (UserDto) session.getAttribute("user");
			if(userDto.getUser_name().equals(writer)) {
				int result = boardService.boardDelete(num);
				if(result == 1) {
					System.out.println("board delete success");
				}else {
					System.out.println("board delete fail : 쿼리문");
				}
			}else {
				System.out.println("board delete fail : 세션 없음");				
			}
			return "redirect:/bbs/list";
		}
		
	}

}
