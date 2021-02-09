package com.paypal.bfs.test.employeeserv.repository;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.entity.Employee;

//import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeJpaRepository  extends CrudRepository<Employee, Integer>{

}
