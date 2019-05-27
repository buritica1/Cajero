package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.uniajc.cajero.model.Movimiento;
import co.edu.uniajc.cajero.model.Movimiento_;



/**
 * Home object for domain model class Movimiento.
 * @see co.edu.uniajc.cajero.dao.Movimiento
 * @author Hibernate Tools
 */
public class ImpMovimientoDao implements MovimientoDao   {

	private Session session;
	

	public ImpMovimientoDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Movimiento movimiento) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(movimiento);
			
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
	public Movimiento findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Movimiento Movimiento = null;
		try {
			tx = session.beginTransaction();
			
			// Contruccion para las piezas individuales de criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Movimiento> criteria = builder.createQuery(Movimiento.class);
			
			// Definir el tipo de entidad que retorna la consulta
			Root<Movimiento> root = criteria.from(Movimiento.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Movimiento_.idMovimiento), id)
					);
			
			Movimiento = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Movimiento;
	}
	
	@Override
	public List<Movimiento> findByIdall() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Movimiento> criteria = builder.createQuery(Movimiento.class);
			
			
			Root<Movimiento> root = criteria.from(Movimiento.class);
			
			criteria.select(root);
	
			List<Movimiento> lstMovimiento = session.createQuery(criteria).getResultList();
					
			tx.commit();
			
			return lstMovimiento;
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
	public Movimiento Update(Movimiento m) {
		Transaction tx = null;
		Movimiento Movimiento = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Movimiento> criteria = builder.createQuery(Movimiento.class);
			
			Root<Movimiento> root = criteria.from(Movimiento.class);
			
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Movimiento_.idMovimiento), m.getIdMovimiento())
					);
			Movimiento = session.createQuery(criteria).getSingleResult();
					
			Movimiento.setDescripcion(m.getDescripcion());
			session.update(Movimiento);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Movimiento;
	}

	@Override
	public Movimiento delete(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Movimiento Movimiento = null;
		try {
			tx = session.beginTransaction();
			
			Movimiento m = (Movimiento ) session.createCriteria(Movimiento.class)
					.add(Restrictions.eq("idMovimento", id)).uniqueResult();
			session.delete(m);
		 		       
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Movimiento;	
	}

	public void closeSession() {
		// TODO Auto-generated method stub
	}

	
}