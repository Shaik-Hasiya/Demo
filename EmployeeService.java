package com.example.demo.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);

	List<Employee> getAllEmployees();

	void deleteEmployeeById(long id);
	
}
