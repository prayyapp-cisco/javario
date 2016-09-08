package org.shoban.hibernate.ehcache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import org.shoban.hibernate.ehcache.util.HibernateUtil;

public class HibernateSessionExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Current Session - no need to close
		Session currentSession = sessionFactory.getCurrentSession();
		
		//open new session
		Session newSession = sessionFactory.openSession();
		//perform db operations
		
		//close session
		newSession.close();
		
		//open stateless session
		StatelessSession statelessSession = sessionFactory.openStatelessSession();
		//perform stateless db operations
		
		//close session
		statelessSession.close();
		
		//close session factory
		sessionFactory.close();
		
	}

}