//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//import org.springframework.data.domain.Sort;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//
//import com.example.demo.model.Employee;
//import com.example.demo.repository.EmployeeRepository;
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	private String SortDirection;
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public void saveEmployee(Employee employee) {
//		// TODO Auto-generated method stub
//		this.employeeRepository.save(employee);
//
//	}
//
//	@Override
//	public Employee getEmployeeById(long id) {
//		// TODO Auto-generated method stub
//		Optional<Employee> optional = employeeRepository.findById(id);
//		Employee employee = null;
//		if (optional.isPresent()) {
//			employee = optional.get();
//		} else {
//			throw new RuntimeException(" Employee not found for id :: " + id);
//		}
//		return employee;
//	}	
//
//	@Override
//	public void deleteEmployeeById(long id) {
//		// TODO Auto-generated method stub
//		this.employeeRepository.deleteById(id);
//
//	}
//
//	@Override
//	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
//		Sort sort = SortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//			Sort.by(sortField).descending();
//		
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//		return this.employeeRepository.findAll(pageable);	}
//}
package com.example.demo.service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}