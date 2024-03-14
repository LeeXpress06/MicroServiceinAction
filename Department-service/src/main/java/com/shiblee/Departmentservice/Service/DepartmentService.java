package com.shiblee.Departmentservice.Service;

import com.shiblee.Departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
