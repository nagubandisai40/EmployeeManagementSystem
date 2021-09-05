package com.simplilearn.util;

import java.io.FileReader;
import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.simplilearn.model.Complience;
import com.simplilearn.model.Department;
import com.simplilearn.model.Employee;
import com.simplilearn.model.LoginMaster;
import com.simplilearn.model.StatusReport;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null){
			try{
				Configuration configuration = new Configuration();
				Properties settings = new Properties();

				settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL,"jdbc:mysql://mysql:3306/emsdb?useSSL=false");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS,"root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				settings.put(Environment.HBM2DDL_AUTO,"update");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(LoginMaster.class);
				configuration.addAnnotatedClass(Employee.class);
				configuration.addAnnotatedClass(Department.class);
				configuration.addAnnotatedClass(StatusReport.class);
				configuration.addAnnotatedClass(Complience.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		System.out.println("Returning session Factory");
		return sessionFactory;
	}
}
