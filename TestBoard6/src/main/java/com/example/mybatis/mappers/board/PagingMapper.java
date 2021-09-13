package com.example.mybatis.mappers.board;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.dto.board.*;


@Mapper
public interface PagingMapper {
	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<BoardDto> selectBoard(int startPoint, int row);
}
