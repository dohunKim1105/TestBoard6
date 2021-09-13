package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dao.*;
import com.example.dto.board.*;

@Service
public class FileService {

    @Autowired
    private FileDao fileDao;
    
    public List<FileDto> selectFile(int num) {
    	return fileDao.selectFile(num);
    }
    
    public int fileUplaod(FileDto fileDto) {
    	return fileDao.fileUpload(fileDto);
    }

    public int fileDelete(FileDto fileDto) {
    	return fileDao.fileDelete(fileDto);
    }
    
}