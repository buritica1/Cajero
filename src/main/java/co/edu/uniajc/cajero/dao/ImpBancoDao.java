package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.uniajc.cajero.model.Banco;
import co.edu.uniajc.cajero.model.Banco_;

/**
 * Home object for domain model class Producto.
 * @see co.edu.uniajc.cajero.dao.Producto
 * @author Hibernate Tools
 */
public class ImpBancoDao implements BancoDao {
	
	private Session session;
	
	public ImpBancoDao(Session session) {
		this.session = session;
	}

	@Override
	public void save(Banco banco) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(banco);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public Banco findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Banco Banco = null;
		try {
			tx = session.beginTransaction();
			
			// Contruccion para las piezas individuales de criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			// Definir el tipo de entidad que retorna la consulta
			Root<Banco> root = criteria.from(Banco.class);
			
			//construyendo la consulta
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Banco_.idBanco), id)
					);
			
			Banco = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
			
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Banco;
	}

	@Override
	public List<Banco> findByall() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			Root<Banco> root = criteria.from(Banco.class);
			
			criteria.select(root);
			
			List<Banco> lstBanco= session.createQuery(criteria).getResultList();
			
			tx.commit();
			
			return lstBanco;
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
			return null;
		}
	}
/*
	@Override
	public Producto Update(int id, String desc) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Producto producto = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
			
			Root<Producto> root = criteria.from(Producto.class);
			
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Producto_.idProducto), id)
					);
			
			producto = session.createQuery(criteria).getSingleResult();
			
			//Update
			producto.setDescripcion(desc);
			session.update(producto);
			
			tx.commit();
		}
		catch (Exception e ) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return producto;
	}
*/
	@Override
	public Banco Update(Banco B) {
		Transaction tx = null;
		Banco Banco = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
			
			Root<Banco> root = criteria.from(Banco.class);
			
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Banco_.idBanco), B.getIdBanco())
					);
			Banco = session.createQuery(criteria).getSingleResult();
			
			Banco.setNombre(B.getNombre());
			Banco.setNit(B.getNit());
			Banco.setDireccion(B.getDireccion());
			Banco.setTelefono(B.getTelefono());
			session.update(Banco);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return Banco;
	}
	
	@Override
	public Banco Delete(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Banco Banco = null;
		try {
			tx = session.beginTransaction();
			
			Banco B = (Banco ) session.createCriteria(Banco.class)
					.add(Restrictions.eq("idBanco", id)).uniqueResult();
			session.delete(B);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}
		return Banco;
	}
	
	public void closeSession() {
		// TODO Auto-generated method stub
	}

}
