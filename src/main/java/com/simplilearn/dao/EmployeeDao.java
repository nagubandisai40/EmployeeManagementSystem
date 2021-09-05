package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.model.Employee;
import com.simplilearn.util.HibernateUtil;

public class EmployeeDao {

	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Employee> showAllEmployees(){
		List<Employee> employees = new ArrayList<>();

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Employee");
			employees = query.list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return  employees;
	}

	public void updateEmployee(Employee employee){
		Transaction transaction = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Employee empDetails = session.load(Employee.class,employee.getEmployeeId());
			empDetails.setDob(employee.getDob());
			empDetails.setEmail(employee.getEmail());
			empDetails.setDepartment(employee.getDepartment());
			empDetails.setLastName(employee.getLastName());
			empDetails.setFirstName(employee.getFirstName());
			session.update(empDetails);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id){
		Transaction transaction =  null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class,id);
			if(employee!=null)
				session.delete(employee);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Employee getEmployee(int id) {
		Employee employee = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			employee = session.get(Employee.class,id);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return employee;
	}
}
