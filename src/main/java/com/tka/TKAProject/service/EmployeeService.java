package com.tka.TKAProject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.TKAProject.dao.EmployeeDAO;
import com.tka.TKAProject.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String message = employeeDAO.addEmployee(employee);
		return message;
	}


	public String updateEmployee(Employee employee, int eId) {
		// TODO Auto-generated method stub
		String message = employeeDAO.updateEmployee(employee,eId);
		return message;
	}


	public String deleteEmployee(int eId) {
		// TODO Auto-generated method stub
		String message = employeeDAO.deleteEmployee(eId);
		return message;
	}


	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> list = employeeDAO.getAllEmployee();
		return list;
	}


	public Employee getParticularEmployee(int eId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.getParticularEmployee(eId);
		return employee;
	}


	public Map doLogin(Employee employee) {
		// TODO Auto-generated method stub
		
		String message = null;
		Employee emp = employeeDAO.doLogin(employee);
		Map map = new HashMap();
		
		if(emp!=null){
			
			message = "Valid User";
			map.put("msg", message);
			map.put("user", emp);
			
		}else {
			
			message = "Invalid User";
			map.put("msg", message);
			map.put("user", emp);
			
		}
		
		return map;
		
	}


	public List<Employee> getEmployeeBetween(double minSal, double maxSal) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeDAO.getEmployeeBetween(minSal, maxSal);
		return list;
	}


	public List<Employee> getEmployeeStatus(String status) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeDAO.getEmployeeStatus(status);
		return list;
		
	}


	public String getEmployeeStatusChange(int eId) {
		// TODO Auto-generated method stub
		String message = employeeDAO.getEmployeeStatusChange(eId);
		return message;
	}


	public String getEmployeeStatusChangeByIdAndStatus(int eId, String status) {
		// TODO Auto-generated method stub
		String message = employeeDAO.getEmployeeStatusChangeByIdAndStatus(eId,status);
		return message;
	}


	

}
