package com.huertafc.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO {

	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Long departmentId;
}
