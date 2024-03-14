package com.shiblee.Employeeservice.Entity;

import com.shiblee.Employeeservice.Dto.DepartmentDto;
import com.shiblee.Employeeservice.Dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseAPI {
    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
}
