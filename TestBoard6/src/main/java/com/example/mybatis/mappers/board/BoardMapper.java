package com.example.mybatis.mappers.board;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.dto.board.*;


@Mapper
public interface BoardMapper {
	public List<BoardDto> boardListAll();
	
	public BoardDto boardDetail(int num);
	
	public int boardNextNum();
	
	public int boardUpdate(@Param("dto")BoardDto updateDto);
	
	public int boardWrite(@Param("dto")BoardDto writeDto);
	
	public int boardDelete(int num);
	
	public int boardCntPlus(int num);
}
