package com.example.mybatis.mappers.board;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.dto.board.*;

@Mapper
public interface FileMapper {

	public List<FileDto> selectFile(int num);
	
	public int fileUpload(@Param("file")FileDto fileDto);
	
	public int fileDelete(@Param("file")FileDto fileDto);
}

