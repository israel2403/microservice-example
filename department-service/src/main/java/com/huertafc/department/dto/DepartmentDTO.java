package com.huertafc.department.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartmentDTO {
	
	private Long departmentID;
	
	private String departmentName;
	
	private String departmentAddress;
	
	private String departmentCode;
}
