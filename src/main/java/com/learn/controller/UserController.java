package com.learn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.service.UserService;
import com.learn.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserVO> getAllUsers() {
		List<UserVO> result = null;
//		Map<String, Object> elem1 = new HashMap<>(); // map은 new 못해요
//		elem1.put("name", "test1");
//
//		Map<String, Object> elem2 = new HashMap<>(); // map은 new 못해요 hashmap 가능 넣은 순서대로 불가 . linkedhashmap 순서 대로 가능.
//		elem2.put("name", "test2");
//
//		result = new ArrayList<>(); // list 는 new 못해요 Array 는 가능
//		result.add(elem1);
//		result.add(elem2);
		
		result = userService.getAllUsers();
		return result;
	}
	
	
	
	

	@PostMapping 
	public String createUser(@RequestBody UserVO userVO) {
		String result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("name", userName);
//		result = elem;
		int cnt = userService.createUser(userVO);
		result = "result:" + cnt;
		return result;
	}

	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable Long id) {
		UserVO result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		result = elem;
		result = userService.getUserById(id);
		return result;
	}

	
	@PostMapping("/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody UserVO userVO) {
		String result = null;
//		Map<String, Object> result = null;
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		elem.put("name", userName);
//		result = elem;
		
		int cnt = userService.updateUser(id, userVO); 
				result = "Update:"+cnt;
		return result;
	}
	

	@PostMapping("/delete")
	public String deleteUser(@RequestBody UserVO userVO) {
			String result = null;
		
//		Map<String, Object> elem = new HashMap<>();
//		elem.put("id", id);
//		result = elem;
		
		int cnt = userService.deleteUser(userVO.getId());
		result = "Delete :" + cnt + "(" + userVO.getId() + ")";
		return result;
	}
	
	
	

}
