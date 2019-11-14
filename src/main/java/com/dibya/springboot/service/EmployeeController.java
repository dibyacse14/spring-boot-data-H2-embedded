package com.dibya.springboot.service;

import com.dibya.springboot.dao.EmployeeDAO;
import com.dibya.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    EmployeeDAO employeeDAO;
    // Select, Insert, Delete, Update Operations for an Employee

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    Employee getEmployee(@RequestParam Integer id){
        return  employeeService.findOne(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws InterruptedException {
//        Employee savedEmployee = employeeService.save(employee);
        Employee savedEmployee = employeeDAO.insertEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    Map deleteEmployee(@RequestParam Integer id){
        employeeService.delete(id);

        Map<String, String> status = new HashMap<>();
        status.put("Status", "Success");
        return status;
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    String addAllEmployees(@RequestBody List<Employee> employeeList){
        employeeService.save(employeeList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE)
    String addAllEmployees(){
        employeeService.deleteAll();
        return "SUCCESS";
    }
}
