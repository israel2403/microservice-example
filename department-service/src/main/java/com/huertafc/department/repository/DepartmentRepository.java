package com.huertafc.department.repository;

import org.springframework.stereotype.Repository;

import com.huertafc.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends  JpaRepository<Department, Long> {

	Department findByDepartmentId(final Long departmentId);
}
