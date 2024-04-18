package com.employee.Service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	//returntype  methodname   class    obj
	  Employee    saveEmployee(Employee employee);
	  List<Employee> getAllEmployees();
      Employee getEmployeeById(long id);
      Employee updateEmploye(Employee employe,long id);
      void deleteEmployee(long id);
      
}
