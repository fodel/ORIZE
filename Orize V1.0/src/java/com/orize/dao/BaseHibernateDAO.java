package com.orize.dao;

import hibernate.HibernateSessionFactory;
import org.hibernate.Session;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
        
        public void beginTransaction(){
            getSession().beginTransaction();
        }
        
        public void commit(){
            getSession().getTransaction().commit();
        }
	
}