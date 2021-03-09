package com.tectoro.mvc.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtils.class);
	
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()	{
		Session session = null;
		try	{
			if(threadLocal.get() == null)	{
				session = sessionFactory.openSession();
				threadLocal.set(session);
			}
			else	{
				session = threadLocal.get();
			}
		}
		catch(HibernateException he)	{
			logger.error(" <<<<<<<<<<<<<<<<<<<<<<<<<< HibernateException occurred while getting Session {}",he);
		}
		catch(Exception e) {
			logger.error(" <<<<<<<<<<<<<<<<<<<<<<<<<< SystemException occurred while getting Session {}",e);
		}
		return session;
	}
	
	public void closeSession()	{
		Session session = null;
		if(threadLocal.get() != null)	{
			session = threadLocal.get();
			session.close();
			threadLocal.remove();
		}
	}
	
	public void closeSessionFactory()	{
		sessionFactory.close();
	}
	
	public <T> T saveEntity(T entity)	{
		Transaction txn = null;
		Session session = null;
		try	{
			session = getSession();
			txn = session.beginTransaction();
			session.save(entity);
			txn.commit();
		}
		catch(HibernateException he)	{
			txn.rollback();
			logger.error(" <<<<<<<<<<<<<<<<<<<<<<< HibernateException occurred at saveEntity {}",he);
		}
		catch(Exception e)	{
			txn.rollback();
			logger.error(" <<<<<<<<<<<<<<<<<<<<<<< HibernateException occurred at saveEntity {}",e);
		}
		finally	{
			closeSession();
		}
		return entity;
	}
}
