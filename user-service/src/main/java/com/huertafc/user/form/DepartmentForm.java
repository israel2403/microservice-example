package com.huertafc.user.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentForm {

	private Long departmentID;

	private String departmentName;

	private String departmentAddress;

	private String departmentCode;
}
