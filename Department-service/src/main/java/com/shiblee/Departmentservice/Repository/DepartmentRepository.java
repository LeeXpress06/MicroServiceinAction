package com.shiblee.Departmentservice.Repository;


import com.shiblee.Departmentservice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
