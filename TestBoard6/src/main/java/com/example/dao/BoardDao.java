package com.example.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dto.board.*;
import com.example.mybatis.mappers.board.*;

@Repository
public class BoardDao {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private BoardMapper boardMapper;

    public List<BoardDto> boardListAll(){

        boardMapper = sqlSession.getMapper(BoardMapper.class);
        List<BoardDto> boardDtoList = boardMapper.boardListAll();

        return boardDtoList;
    }
    
    public BoardDto boardDetail(int num) {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	BoardDto boardDto = boardMapper.boardDetail(num);
    	return boardDto;
    }
    
    public int boardNextNum() {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	int nextNum = boardMapper.boardNextNum();
    	return nextNum;
    } 
    
    public int boardUpdate(BoardDto updateDto) {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	int result = boardMapper.boardUpdate(updateDto);
    	return result;
    }
    
    public int boardCntPlus(int num) {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	int result = boardMapper.boardCntPlus(num);
    	return result;
    }
    
    public int boardWrite(BoardDto writeDto) {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	int result = boardMapper.boardWrite(writeDto);
    	return result;
    }
    
    public int boardDelete(int num) {
    	boardMapper = sqlSession.getMapper(BoardMapper.class);
    	int result = boardMapper.boardDelete(num);
    	return result;
    }
}