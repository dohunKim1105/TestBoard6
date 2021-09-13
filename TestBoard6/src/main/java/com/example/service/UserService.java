package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dao.*;
import com.example.dto.user.*;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserDto> selectAll(){
        return userDao.selectAll();
    }
    
    public UserDto idPwCheck(String id, String pw) {
    	return userDao.idPwCheck(id, pw);
    }
}