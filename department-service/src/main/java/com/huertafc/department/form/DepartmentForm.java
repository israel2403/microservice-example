package com.huertafc.department.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class DepartmentForm {

	@NotBlank(message = "departmentName property does not be empty")
	private String departmentName;

	@NotBlank(message = "departmentAddress property does not be empty")
	private String departmentAddress;

	@NotBlank(message = "departmentCode property does not be empty")
	private String departmentCode;
}
