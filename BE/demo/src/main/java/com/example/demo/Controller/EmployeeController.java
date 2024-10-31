package com.example.demo.Controller;

import com.example.demo.DTO.Request.EmployeeRequest;
import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employee) throws Exception {
//       Truong hop khi co exception
        Employee savedEmployee = employeeService.createEmployee(employee);
//        Truong hop dung
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees,HttpStatus.ACCEPTED);
    }
}
