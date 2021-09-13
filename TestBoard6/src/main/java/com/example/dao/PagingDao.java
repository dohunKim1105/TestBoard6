package com.example.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dto.board.*;
import com.example.mybatis.mappers.board.*;

@Repository
public class PagingDao {

    @Autowired
    private SqlSession sqlSession;

    @Autowired PagingMapper pagingMapper;
    
    public int countBoard() {
    	pagingMapper = sqlSession.getMapper(PagingMapper.class);
    	int result = pagingMapper.countBoard();
    	return result;
    }
    
    public List<BoardDto> selectBoard(int startPoint, int row) {
    	pagingMapper = sqlSession.getMapper(PagingMapper.class);
    	List<BoardDto> result = pagingMapper.selectBoard(startPoint, row);
    	return result;
    }
}