package com.tka.TKAProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.TKAProject.entity.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(employee);
			transaction.commit();
			message = "Employee Added Successfully.";
			
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
			
		}
		return message;
	}

	public String updateEmployee(Employee employee, int eId) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee e = session.get(Employee.class, eId);
			e.setSalary(employee.getSalary());
			e.setStatus(employee.getStatus());
			session.merge(e);
			transaction.commit();
			message="Employee Updated Successfully.";
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return message;
	}

	public String deleteEmployee(int eId) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, eId);
			session.remove(employee);
			transaction.commit();
			message = "Employee Deleted Successfully";
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		List<Employee> employeeList = null;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Employee";
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			employeeList = query.list();
			transaction.commit();
			
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return employeeList;
	}

	public Employee getParticularEmployee(int eId) {

		Session session = null;
		Transaction transaction = null;
		Employee employee = null;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, eId);
			transaction.commit();
			
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return employee;
	}

	public Employee doLogin(Employee employee) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		Employee emp = null;
		
		try{
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Employee where emailId=:empEmail and mobileNo=:mobNo";
			Query<Employee> query =  session.createQuery(hqlQuery,Employee.class);
			query.setParameter("empEmail", employee.getEmailId());
			query.setParameter("mobNo", employee.getMobileNo());
			emp = query.uniqueResult();
			transaction.commit();
			
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
			
		}finally {
			if(session!=null)
				session.close();
		}
		
		return emp;
		
	}

	public List<Employee> getEmployeeBetween(double minSal, double maxSal) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		List<Employee> list = null;
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Employee where salary between :minSal and :maxSal";
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("minSal", minSal);
			query.setParameter("maxSal", maxSal);
			list = query.list();
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return list;
		
	}

	public List<Employee> getEmployeeStatus(String status) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		List<Employee> list = null;
		try {
			
			session = sessionFactory.openSession();
			transaction= session.beginTransaction();
			String hqlQuery = "from Employee where status=:s";
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("s", status);
			 list = query.list();
			 transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
				
		return list;
	}

	public String getEmployeeStatusChange(int eId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee emp = session.get(Employee.class, eId);
			String status = emp.getStatus();
			if(status.equals("Active")) {
				emp.setStatus("Inactive");
				message = "Status Changed Successfully.";
			}
			else if(status.equals("Inactive")) {
				emp.setStatus("Active");
				message = "Status Changed Successfully.";
			}
			else {
				message = "Suspended employee does not change status";
			}
			session.merge(emp);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
		
	}

	public String getEmployeeStatusChangeByIdAndStatus(int eId, String status) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee emp = session.get(Employee.class, eId);
			
			if(status.equals("Active")) {
				emp.setStatus("Inactive");
				message = "Status Changed Successfully.";
			}
			else if(status.equals("Inactive")) {
				emp.setStatus("Active");
				message = "Status Changed Successfully.";
			}
			else {
				message = "Suspended employee does not change status";
			}
			session.merge(emp);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return message;
	}


}
