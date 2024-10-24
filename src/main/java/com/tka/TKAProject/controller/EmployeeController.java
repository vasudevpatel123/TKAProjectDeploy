package com.tka.TKAProject.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tka.TKAProject.entity.Employee;
import com.tka.TKAProject.service.EmployeeService;

@RestController
@RequestMapping("employeeAPI")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		String message = employeeService.addEmployee(employee);
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("updateEmployee/{eId}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,@PathVariable int eId) {
		String message = employeeService.updateEmployee(employee,eId);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("deleteEmployee/{eId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int eId) {
		String message = employeeService.deleteEmployee(eId);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = employeeService.getAllEmployee();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getParticularEmployee/{eId}")
	public ResponseEntity<Employee> getParticularEmployee(@PathVariable int eId){
		Employee employee  = employeeService.getParticularEmployee(eId);
		return ResponseEntity.ok(employee);
		
	}
	
	@PostMapping("login")
	public ResponseEntity<Map> doLogin(@RequestBody Employee employee) {
		Map map = employeeService.doLogin(employee);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("employeeBetween/{minSal}/{maxSal}")
	public ResponseEntity<List<Employee>> getEmployeeBetween(@PathVariable double minSal, @PathVariable double maxSal) {
		List<Employee> list = employeeService.getEmployeeBetween(minSal,maxSal);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("employeeStatus/{status}")
	public ResponseEntity<List<Employee>> getEmployeeStatus(@PathVariable String status) {
		List<Employee> list = employeeService.getEmployeeStatus(status);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("employeeStatusChange/{eId}")
	public ResponseEntity<String> getEmployeeStatusChange(@PathVariable int eId) {
		String message = employeeService.getEmployeeStatusChange(eId);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("employeeStatusChangeByIdAndStatus/{eId}/{status}")
	public ResponseEntity<String> getEmployeeStatusChangeByIdAndStatus(@PathVariable int eId, @PathVariable String status) {
		String message = employeeService.getEmployeeStatusChangeByIdAndStatus(eId,status);
		return ResponseEntity.ok(message);
	}
	
	
	
}
