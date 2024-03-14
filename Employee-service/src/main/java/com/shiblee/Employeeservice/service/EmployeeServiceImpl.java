package com.shiblee.Employeeservice.service;

import com.shiblee.Employeeservice.Dto.DepartmentDto;
import com.shiblee.Employeeservice.Dto.EmployeeDto;
import com.shiblee.Employeeservice.Entity.Employee;
import com.shiblee.Employeeservice.Entity.ResponseAPI;
import com.shiblee.Employeeservice.Mapper.EmployeeMapper;
import com.shiblee.Employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    private WebClient webClient;



    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveDEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);
        return savedEmployeeDto;
    }

    public ResponseAPI getfullInfoById(long id ){
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto   = EmployeeMapper.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = webClient.get()  // type of request webclient is doing
                .uri("http:://localhost:8080/api/departments" + employee.getDepartmentCode()) // request resoirce and link
                .retrieve()                                         // retrieve
                .bodyToMono(DepartmentDto.class)    // convert to mono
                .block();  // block the asynchronous
        ResponseAPI responseAPI = null;
        return new ResponseAPI(departmentDto,employeeDto);
    }








}
