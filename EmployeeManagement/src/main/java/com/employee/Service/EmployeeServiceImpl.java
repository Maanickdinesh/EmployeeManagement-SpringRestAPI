package com.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Exception.ResourceNotFoundException;
import com.employee.Repository.EmployeeRepository;
import com.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	        //interface        //obj
	
	private EmployeeRepository EmployeeRepo;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
				super();
				EmployeeRepo = employeeRepo;
			}



	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeRepo.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeRepo.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
//		// TODO Auto-generated method stub
		Optional<Employee> employee = EmployeeRepo.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
//		return EmployeeRepo.findById(id).orElseThrow(() -> 
//		new ResourceNotFoundException("Employee", "Id", id));

	}



	@Override
	public Employee updateEmploye(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee ExstingEmployee = EmployeeRepo.findById(id).orElseThrow (()->
		
		 new ResourceNotFoundException("Employee", "id", id));
		
		ExstingEmployee.setFirstName(employee.getFirstName());
		ExstingEmployee.setLastName(employee.getLastName());
		ExstingEmployee.setEmail(employee.getEmail());
		
		EmployeeRepo.save(ExstingEmployee);
		return ExstingEmployee;
		
		
	}



	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		EmployeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		
		EmployeeRepo.deleteById(id);
	}



	

}
