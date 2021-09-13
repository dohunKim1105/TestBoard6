package com.example.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.dto.user.*;
import com.example.mybatis.mappers.user.*;

@Repository
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> selectAll(){

        userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserDto> userDto = userMapper.selectAll();

        return userDto;
    }
    
    public UserDto idPwCheck(String id, String pw) {
    	userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto userDto = userMapper.selectOne(id, pw);

        return userDto;
    }
}