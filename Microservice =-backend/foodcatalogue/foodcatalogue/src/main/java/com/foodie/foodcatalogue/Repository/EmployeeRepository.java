package com.foodie.foodcatalogue.Repository;

import com.foodie.foodcatalogue.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from employee e where e.department.depname = :depname order by e.employee.salary desc")
    List<Employee> findTop10Department(@Param("depname") String depname);

    @Query("select e from employee e where e.salary = (select max(e2.salary) from employee e2 where e2.department = e.department)")
    List<Employee> findhighestpaidineachdepartment();
}
