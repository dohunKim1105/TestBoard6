package com.example.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dto.board.*;
import com.example.mybatis.mappers.board.*;

@Repository
public class FileDao {
	
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private FileMapper fileMapper;
    
    public List<FileDto> selectFile(int num) {
    	fileMapper = sqlSession.getMapper(FileMapper.class);
    	List<FileDto> list = fileMapper.selectFile(num);
    	return list; 
    }
    
	public int fileUpload(FileDto fileDto) {
    	fileMapper = sqlSession.getMapper(FileMapper.class);
    	int result = fileMapper.fileUpload(fileDto);
    	return result;
    }
	
	public int fileDelete(FileDto fileDto) {
		fileMapper = sqlSession.getMapper(FileMapper.class);
		int result = fileMapper.fileDelete(fileDto);
		return result;
	}

}
