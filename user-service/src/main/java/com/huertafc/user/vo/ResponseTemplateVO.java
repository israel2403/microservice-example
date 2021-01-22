package com.huertafc.user.vo;

import com.huertafc.user.dto.UserDTO;
import com.huertafc.user.form.DepartmentForm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVO {

	private UserDTO userDTO;
	private DepartmentForm department;
}
