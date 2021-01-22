package com.huertafc.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huertafc.user.dto.UserDTO;
import com.huertafc.user.form.UserForm;
import com.huertafc.user.service.UserService;
import com.huertafc.user.vo.ResponseTemplateVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserForm userForm) {
		log.info("Inside saveUser of userController");
		return new ResponseEntity<UserDTO>(userService.saveUser(userForm), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside getuserWithDepartment");
		return new ResponseEntity<ResponseTemplateVO>(userService.getUserWithDepartment(userId), HttpStatus.OK);
	}
}
