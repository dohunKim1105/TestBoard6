package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dao.*;
import com.example.dto.board.*;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public List<BoardDto> boardListAll(){
        return boardDao.boardListAll();
    }
    
    public BoardDto boardDetail(int num) {
    	return boardDao.boardDetail(num);
    }
    
    public int boardNextNum() {
    	return boardDao.boardNextNum();
    }
    
    public int boardUpdate(BoardDto updateDto) {
    	return boardDao.boardUpdate(updateDto);
    }
    
    public int boardWrite(BoardDto writeDto) {
    	int result = boardDao.boardWrite(writeDto);
    	if(result <= 0) {
			System.out.println("write ERROR");
		}else {
			System.out.println("updateResult : " + result);
		}
    	
    	return result;
    }
    
    public int boardDelete(int num) {
    	return boardDao.boardDelete(num);
    }
    
    public int boardCntPlus(int num) {
    	return boardDao.boardCntPlus(num);
    }
   
}