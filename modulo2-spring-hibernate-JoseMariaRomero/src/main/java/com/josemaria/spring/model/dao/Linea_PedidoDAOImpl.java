package com.josemaria.spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.josemaria.spring.model.dto.Linea_Pedido;

public class Linea_PedidoDAOImpl implements Linea_PedidoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(Linea_PedidoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addLinea_Pedido(Linea_Pedido l) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.persist(l);
			transaction.commit();
			logger.info("Linea_Pedido saved successfully, Article details="+l);
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

	public void updateLinea_Pedido(Linea_Pedido l) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(l);
			transaction.commit();
			logger.info("Linea_Pedido updated successfully, Linea_Pedido details="+l);
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
	public List<Linea_Pedido> listLineas_Pedido() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Linea_Pedido> linea_PedidoList = session.createQuery("from Linea_Pedido").list();
		transaction.commit();
		return linea_PedidoList;
	}

	public void removeLinea_Pedido(long id) {
		Transaction transaction = null;
		try 
		{
			
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Long idLong = Long.valueOf(id);
			Linea_Pedido l = (Linea_Pedido) session.load(Linea_Pedido.class, idLong);
			if(null != l){
				session.delete(l);
			}
			transaction.commit();
			logger.info("Linea_Pedido deleted successfully, Linea_Pedido details="+l);
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
