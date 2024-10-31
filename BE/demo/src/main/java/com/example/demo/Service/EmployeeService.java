package com.example.demo.Service;

import com.example.demo.DTO.Request.EmployeeRequest;
import com.example.demo.Entity.Employee;
import com.example.demo.Exception.CurrEmployeeException;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeRequest request) throws CurrEmployeeException {
        Employee employee = new Employee();
        if(request.getName().equals("Triet")){
            throw new CurrEmployeeException(Employee.class,"id", "2");
        }
        employee.setName(request.getName());
        employee.setAge(request.getAge());

        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
}
