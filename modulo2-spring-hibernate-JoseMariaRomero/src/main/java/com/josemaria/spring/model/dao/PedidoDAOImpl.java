package com.josemaria.spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.josemaria.spring.model.dto.Pedido;

public class PedidoDAOImpl implements PedidoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PedidoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addPedido(Pedido p) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.persist(p);
			transaction.commit();
			logger.info("Pedido saved successfully, Pedido details="+p);
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

	public void updatePedido(Pedido p) {
		Transaction transaction = null;
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			session.update(p);
			transaction.commit();
			logger.info("Pedido updated successfully, Pedido details="+p);
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
	public List<Pedido> listPedidos() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Pedido> pedidosList = session.createQuery("from Pedido").list();
		transaction.commit();
		return pedidosList;
	}

	public void removePedido(int id) {
		Transaction transaction = null;
		try 
		{
			Session session = this.sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Integer idInteger = Integer.valueOf(id);
			Pedido p = (Pedido) session.load(Pedido.class, idInteger);
			if(null != p){
				session.delete(p);
			}
			transaction.commit();
			logger.info("Pedido deleted successfully, Pedido details="+p);
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
