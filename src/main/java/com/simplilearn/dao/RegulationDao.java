package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.model.Complience;
import com.simplilearn.util.HibernateUtil;

public class RegulationDao {

	public void addRegulation(Complience complience){
		Transaction transaction =null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(complience);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Complience> viewAllCompliences(){
		List<Complience> compliences = new ArrayList<>();
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("FROM compliences");
			compliences = query.list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return  compliences;
	}
}
