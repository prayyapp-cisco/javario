package org.shoban.hibernate.ehcache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.shoban.hibernate.ehcache.model.Employee;
import org.shoban.hibernate.ehcache.util.HibernateUtil;

public class HibernateGetVsLoad {

	public static void main(String[] args) {
		
		//Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Get Example
		Employee emp = (Employee) session.get(Employee.class, new Long(2));
		System.out.println("Employee get called");
		System.out.println("Employee ID= "+emp.getId());
		System.out.println("Employee Get Details:: "+emp+"\n");
		
		//load Example
		Employee emp1 = (Employee) session.load(Employee.class, new Long(1));
		System.out.println("Employee load called");
		System.out.println("Employee ID= "+emp1.getId());
		System.out.println("Employee load Details:: "+emp1+"\n");
		
		//Close resources
		tx.commit();
		sessionFactory.close();
	}
}
