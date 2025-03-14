package com.learn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.learn.vo.UserVO;

@Mapper
public interface UserMapper {

	List<UserVO> getAllUsers();
	int createUser(UserVO userVO); //mybatis  는 갯수로 보낸다. JPA는 한줄씩 가져와서 가공 하기에 데이터 형이 중요.
	UserVO getUserById(@Param("id") Long id);
	int updateUser(UserVO userVO);
	int deleteUser(@Param("id") Long id);
}

