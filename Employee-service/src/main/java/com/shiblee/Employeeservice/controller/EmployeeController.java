package com.shiblee.Employeeservice.controller;

import com.shiblee.Employeeservice.Dto.EmployeeDto;
import com.shiblee.Employeeservice.Entity.ResponseAPI;
import com.shiblee.Employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseAPI> getEmployeeById(@PathVariable long id){
        ResponseAPI responseAPI = employeeService.getfullInfoById(id);
       return new ResponseEntity<>(responseAPI, HttpStatus.FOUND);
    }

}
