package com.huertafc.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.huertafc.user.dto.UserDTO;
import com.huertafc.user.entity.User;
import com.huertafc.user.form.DepartmentForm;
import com.huertafc.user.form.UserForm;
import com.huertafc.user.repository.UserResository;
import com.huertafc.user.vo.ResponseTemplateVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
	
	private final UserResository userRepository;
	
	private final RestTemplate restTemplate;
	
	public UserDTO saveUser(final UserForm userForm) {
		log.info("Inside saveUser of userService");
		final User user = new User(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(), userForm.getDepartmentId());
		userRepository.save(user);
		return UserDTO.builder()
				.userId(user.getUserId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.departmentId(user.getDepartmentId())
				.build();
	}
	
	public ResponseTemplateVO getUserWithDepartment(final Long userId) {
		final User user = userRepository.getOne(userId);
		log.info(user.toString());
		final DepartmentForm departmentForm = restTemplate.getForObject("http://localhost:9001/departments/".concat(userId.toString()), DepartmentForm.class);
		return createResponseTemplateVO(user, departmentForm);
	}
	
	private ResponseTemplateVO createResponseTemplateVO(final User user, final DepartmentForm departmentForm) {
		final UserDTO userDTO = UserDTO.builder()
				.userId(user.getUserId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.departmentId(user.getDepartmentId())
				.build();
		return ResponseTemplateVO.builder()
				.userDTO(userDTO)
				.department(departmentForm)
				.build();
	}
}
