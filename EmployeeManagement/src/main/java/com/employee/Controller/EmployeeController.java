package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Service.EmployeeService;
import com.employee.entity.Employee;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {
	
	
     // we need to import or depedence injection of employeeservice class into this class then only we access 
	//the menthods in controller -> we just autowried or contructor based injection
	
	
	//      class           objname
	
	private EmployeeService employeservice;

	public EmployeeController(EmployeeService employeservice) {
		super();
		this.employeservice = employeservice;
	}
	
	// we create saveemployee method
	//      returntype     generic class    methodname              class    objname
	@PostMapping
	private ResponseEntity<Employee>      saveEmployee(@RequestBody Employee employee){
		return  new ResponseEntity<Employee>(employeservice.saveEmployee(employee),HttpStatus.CREATED );
		
	}
	@GetMapping
	private List<Employee> getAllEmployees(){
		return employeservice.getAllEmployees();
	}
	@GetMapping("{id}")
	private ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") long empid){
		return new ResponseEntity<Employee>(employeservice.getEmployeeById(empid), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	private ResponseEntity<Employee> updateEmployee(@PathVariable ("id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeservice.updateEmploye(employee, id),HttpStatus.OK );
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deleteEmployee(@PathVariable ("id") long id){
		employeservice.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted Successfuly",HttpStatus.OK);
	}
}
