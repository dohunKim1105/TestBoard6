package com.example.mybatis.mappers.user;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.dto.user.*;

@Mapper
public interface UserMapper {
	public List<UserDto> selectAll();
	
	public UserDto selectOne(String id, String pw);
}
