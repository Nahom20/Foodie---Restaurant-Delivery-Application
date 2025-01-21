package com.foodie.foodcatalogue.Service;

import com.foodie.foodcatalogue.Entity.Employee;
import com.foodie.foodcatalogue.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> gettoop10earningemployees(String depname){
        return employeeRepository.findTop10Department(depname);
    }

    public List<Employee> gethighestearningemployeeacrossdepartment(){
        return employeeRepository.findhighestpaidineachdepartment();
    }
}
