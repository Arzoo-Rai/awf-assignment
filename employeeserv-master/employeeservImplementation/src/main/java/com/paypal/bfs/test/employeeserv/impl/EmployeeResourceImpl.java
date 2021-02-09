package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repository.EmployeeJpaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	
	@Autowired
	EmployeeJpaRepository empRepository;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
    	Optional<com.paypal.bfs.test.employeeserv.entity.Employee> emp = empRepository.findById(Integer.parseInt(id));
        Employee employee= new Employee();
        employee.setId(emp.get().getId());
		employee.setFirstName(emp.get().getFirstName());
		employee.setLastName(emp.get().getLastName());
		employee.setAddressLine1(emp.get().getAddressLine1());
		employee.setAddressLine2(emp.get().getAddressLine2());
		employee.setZip(emp.get().getZip());
		employee.setState(emp.get().getState());
		employee.setCountry(emp.get().getCountry());
		

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		com.paypal.bfs.test.employeeserv.entity.Employee emp = new com.paypal.bfs.test.employeeserv.entity.Employee();
		emp.setId(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setAddressLine1(employee.getAddressLine1());
		emp.setAddressLine2(employee.getAddressLine2());
		emp.setZip(employee.getZip());
		emp.setState(employee.getState());
		emp.setCountry(employee.getCountry());
		empRepository.save(emp);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
