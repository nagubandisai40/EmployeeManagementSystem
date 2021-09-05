package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.model.Department;
import com.simplilearn.util.HibernateUtil;

public class DepartmentDao {
	public void addDepartment(Department department){
		Transaction transaction =null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Department> viewAllDepartments(){
		List<Department> departments = new ArrayList<>();
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Department");
			departments = query.list();
			session.close();;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  departments;
	}

	public Department getDepartment(int deptId) {
		Department department = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			department = session.get(Department.class,deptId);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return department;
	}
}
