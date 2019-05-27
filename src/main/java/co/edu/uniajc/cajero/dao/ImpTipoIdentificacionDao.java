package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.model.TipoIdentificacion_;

/**
 * Home object for domain model class TipoIdentificacion.
 * @see co.edu.uniajc.cajero.dao.TipoIdentificacion
 * @author Hibernate Tools
 */
public class ImpTipoIdentificacionDao implements TipoIdentificacionDao   {

	private Session session;
	

	public ImpTipoIdentificacionDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(TipoIdentificacion TipoIdentificacion) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(TipoIdentificacion);
			
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
	public TipoIdentificacion findById(int id) {
		Transaction tx = null;
		TipoIdentificacion Tipoidentificacion = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<TipoIdentificacion> criteria = builder.createQuery(TipoIdentificacion.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<TipoIdentificacion> root = criteria.from(TipoIdentificacion.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(TipoIdentificacion_.idIdentificacion), id)
					);
			
			Tipoidentificacion = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Tipoidentificacion;
	}

	public List<TipoIdentificacion> findByIdall() {
		Transaction tx = null;
		//TipoIdentificacion Tipoidentificacion = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<TipoIdentificacion> criteria = builder.createQuery(TipoIdentificacion.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<TipoIdentificacion> root = criteria.from(TipoIdentificacion.class);
			
			//construyendo la consulta 
			criteria.select(root);
	
			List<TipoIdentificacion> lstTipoIdentificacion = session.createQuery(criteria).getResultList();
					
			//Tipoidentificacion = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
			
			return lstTipoIdentificacion;
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
	public TipoIdentificacion Update(TipoIdentificacion tp) {
		Transaction tx = null;
		TipoIdentificacion Tipoidentificacion = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<TipoIdentificacion> criteria = builder.createQuery(TipoIdentificacion.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<TipoIdentificacion> root = criteria.from(TipoIdentificacion.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(TipoIdentificacion_.idIdentificacion), tp.getIdIdentificacion())
					);
			
			Tipoidentificacion = session.createQuery(criteria).getSingleResult();
			
			//Update		
			Tipoidentificacion.setDescripcion(tp.getDescripcion());
			session.update(Tipoidentificacion);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Tipoidentificacion;
	}

	@Override
	public TipoIdentificacion delete(int id) {
		Transaction tx = null;
		TipoIdentificacion Tipoidentificacion = null;
		try {
			tx = session.beginTransaction();
			
			TipoIdentificacion tp = (TipoIdentificacion ) session.createCriteria(TipoIdentificacion.class)
					.add(Restrictions.eq("idIdentificacion", id)).uniqueResult();
			session.delete(tp);
		 		       
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Tipoidentificacion ;
	}

	public void closeSession() {
		// TODO Auto-generated method stub
		
	}

	
}
