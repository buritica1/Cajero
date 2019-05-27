package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import co.edu.uniajc.cajero.model.Banco;
import co.edu.uniajc.cajero.model.Banco_;



/**
 * Home object for domain model class TipoIdentificacion.
 * @see co.edu.uniajc.cajero.dao.TipoIdentificacion
 * @author Hibernate Tools
 */
public class ImpBancoDao implements BancoDao   {

	private Session session;
	

	public ImpBancoDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Banco Banco) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(Banco);
			
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
	public Banco findById(int id) {
		Transaction tx = null;
		Banco Tipoidentificacion = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<Banco> root = criteria.from(Banco.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Banco_.idBanco), id)
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

	public List<Banco> findByIdall() {
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<Banco> root = criteria.from(Banco.class);
			
			//construyendo la consulta 
			criteria.select(root);
	
			List<Banco> lstBanco = session.createQuery(criteria).getResultList();
					
			
			
			tx.commit();
			
			return lstBanco;
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
	public Banco Update(int id,String nit, String nombre,String direccion,String telefono) {
		Transaction tx = null;
		Banco banco = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<Banco> root = criteria.from(Banco.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Banco_.idBanco), id)
					);
			
			banco = session.createQuery(criteria).getSingleResult();
			
			//Update		
			banco.setNombre(nombre);
			session.update(banco);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return banco;
	}

	@Override
	public Banco Delete(int id) {
		Transaction tx = null;
		Banco banco = null;
		try {
			tx = session.beginTransaction();
			
			// frabrica  para las piezas individuales de criteria 
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			// Definir el tipo de entidad que retorna la consulta 
			Root<Banco> root = criteria.from(Banco.class);
			
			//construyendo la consulta 
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Banco_.idBanco), id)
					);
			
			banco = session.createQuery(criteria).getSingleResult();
			
			// Delete 
			//banco.setIdIdentificacion(id);			
			session.delete(banco);
		 		       
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return banco ;
	}

	public void closeSession() {
		// TODO Auto-generated method stub
		
	}

	

	

	
}

