package com.huertafc.department.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.huertafc.department.dto.DepartmentDTO;
import com.huertafc.department.entity.Department;
import com.huertafc.department.form.DepartmentForm;
import com.huertafc.department.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentDTO saveDepartment(final DepartmentForm departmentForm) {
		log.info("Insaide saveDepartment method of DepartmentService");
		final Department department = new Department(departmentForm.getDepartmentName(),
				departmentForm.getDepartmentAddress(), departmentForm.getDepartmentCode());
		departmentRepository.save(department);
		return DepartmentDTO.builder().departmentID(department.getDepartmentId())
				.departmentName(department.getDepartmentName()).departmentAddress(department.getDepartmentAddress())
				.departmentCode(department.getDepartmentCode()).build();
	}

	public DepartmentDTO findDepartmentById(final Long departmentId) {
		log.info("Insaide findDepartmentById method of DepartmentService");
		final Optional<Department> department = this.departmentRepository.findById(departmentId);
		return DepartmentDTO.builder().departmentID(department.get().getDepartmentId())
				.departmentName(department.get().getDepartmentName())
				.departmentAddress(department.get().getDepartmentAddress())
				.departmentCode(department.get().getDepartmentCode()).build();
	}

}
