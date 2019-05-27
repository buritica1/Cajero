package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.uniajc.cajero.model.Estado;
import co.edu.uniajc.cajero.model.Estado_;

/**
 * Home object for domain model class TipoIdentificacion.
 * @see co.edu.uniajc.cajero.dao.TipoIdentificacion
 * @author Hibernate Tools
 */
public class ImpEstadoDao implements EstadoDao   {

	private Session session;
	

	public ImpEstadoDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Estado Estado) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(Estado);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
	}			

	@Override
	public Estado findById(int id) {
		Transaction tx = null;
		Estado Estado = null;
		try {
			tx = session.beginTransaction();
			

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
			

			Root<Estado> root = criteria.from(Estado.class);
			
			
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Estado_.idEstado), id)
					);
			
			Estado = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Estado;
	}

	public List<Estado> findByIdall() {
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
			
			
			Root<Estado> root = criteria.from(Estado.class);
			

			criteria.select(root);
	
			List<Estado> lstEstado = session.createQuery(criteria).getResultList();
					

			
			tx.commit();
			
			return lstEstado;
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
			
			return null;
		}
		
	}

	@Override
	public Estado Update(Estado E) {
		Transaction tx = null;
		Estado Estado = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
			
			Root<Estado> root = criteria.from(Estado.class);
			
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Estado_.idEstado), E.getIdEstado())
					);
			Estado = session.createQuery(criteria).getSingleResult();
			
			Estado.setDescripcion(E.getDescripcion());
			session.update(Estado);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Estado;
	}
	
	@Override
	public Estado Delete(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Estado Estado = null;
		try {
			tx = session.beginTransaction();
			
			Estado E = (Estado ) session.createCriteria(Estado.class)
					.add(Restrictions.eq("idEstado", id)).uniqueResult();
			session.delete(E);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}
		return Estado;
	}

	public void closeSession() {
		// TODO Auto-generated method stub
		
	}

	
}
