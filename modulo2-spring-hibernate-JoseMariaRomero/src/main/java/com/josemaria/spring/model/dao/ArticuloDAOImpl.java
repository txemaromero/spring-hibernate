package com.josemaria.spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.josemaria.spring.model.dto.Articulo;

public class ArticuloDAOImpl implements ArticuloDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticuloDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addArticulo(Articulo a) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.persist(a);
			transaction.commit();
			logger.info("Article saved successfully, Article details="+a);
		}
		catch (Exception e)
		{
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	public void updateArticulo(Articulo a) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.update(a);
			transaction.commit();
			logger.info("Article updated successfully, Article details="+a);
		}
		catch (Exception e)
		{
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }	
	}

	@SuppressWarnings("unchecked")
	public List<Articulo> listArticulos() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Articulo> articlesList = session.createQuery("from Articulo").list();
		transaction.commit();
		return articlesList;
	}

	public void removeArticulo(int id) {
		Transaction transaction = null;
		try 
		{
			
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Integer idInteger = Integer.valueOf(id);
			Articulo a = (Articulo) session.load(Articulo.class, idInteger);
			if(null != a){
				session.delete(a);
			}
			transaction.commit();
			logger.info("Article deleted successfully, Article details="+a);
		}
		catch (Exception e)
		{
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}
