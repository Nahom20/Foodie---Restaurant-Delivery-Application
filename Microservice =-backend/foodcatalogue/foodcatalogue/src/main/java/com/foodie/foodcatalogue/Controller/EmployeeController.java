package com.foodie.foodcatalogue.Controller;

import com.foodie.foodcatalogue.Entity.Employee;
import com.foodie.foodcatalogue.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("{depname}")
    public ResponseEntity<List<Employee>> gettop10hightearing(@PathVariable String depname){
        List<Employee> result = employeeService.gettoop10earningemployees(depname);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getdep")
    public ResponseEntity<List<Employee>> getthighestearningacrossdepartment(){
        List<Employee> result = employeeService.gettoop10earningemployees();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
