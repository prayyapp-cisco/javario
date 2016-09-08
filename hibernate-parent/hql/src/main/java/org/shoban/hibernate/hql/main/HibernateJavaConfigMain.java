package org.shoban.hibernate.namedquery.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.shoban.hibernate.namedquery.model.Employee1;
import org.shoban.hibernate.namedquery.util.HibernateUtil;

public class HibernateJavaConfigMain {

	public static void main(String[] args) {
		Employee1 emp = new Employee1();
		emp.setName("Lisa");
		emp.setRole("Manager");
		emp.setInsertTime(new Date());
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
