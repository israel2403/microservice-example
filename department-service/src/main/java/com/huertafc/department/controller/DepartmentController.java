package com.huertafc.department.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huertafc.department.dto.DepartmentDTO;
import com.huertafc.department.form.DepartmentForm;
import com.huertafc.department.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	private final DepartmentService departmentService;

	@PostMapping("/")
	public ResponseEntity<DepartmentDTO> 
		saveDepartment(@RequestBody final DepartmentForm department) {
			log.info("Insaide saveDepartment method of DepartmentController");
			return new ResponseEntity<DepartmentDTO>(departmentService.saveDepartment(department), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable(value = "id") long departmentId) {
		return new ResponseEntity<DepartmentDTO>(departmentService.findDepartmentById(departmentId), HttpStatus.OK);
	}

}
