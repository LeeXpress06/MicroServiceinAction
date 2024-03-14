package com.shiblee.Employeeservice.service;

import com.shiblee.Employeeservice.Dto.EmployeeDto;
import com.shiblee.Employeeservice.Entity.ResponseAPI;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ResponseAPI getfullInfoById(long id);


}
