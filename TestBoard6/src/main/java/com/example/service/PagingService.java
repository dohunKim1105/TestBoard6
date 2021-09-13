package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dao.*;
import com.example.dto.board.*;

@Service
public class PagingService {

	@Autowired
	private PagingDao pagingDao;

	public int countBoard() {
		return pagingDao.countBoard();
	}

	public List<BoardDto> selectBoard(int startPoint, int row) {
		return pagingDao.selectBoard(startPoint, row);
	}


}