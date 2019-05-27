package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.model.Producto_;

/**
 * Home object for domain model class Producto.
 * @see co.edu.uniajc.cajero.dao.Producto
 * @author Hibernate Tools
 */
public class ImpProductoDao implements ProductoDao {
	
	private Session session;
	
	public ImpProductoDao(Session session) {
		this.session = session;
	}

	@Override
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(producto);
			
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
	public Producto findById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Producto producto = null;
		try {
			tx = session.beginTransaction();
			
			// Contruccion para las piezas individuales de criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
			
			// Definir el tipo de entidad que retorna la consulta
			Root<Producto> root = criteria.from(Producto.class);
			
			//construyendo la consulta
			criteria.select(root);
			criteria.where(
					builder.equal(root.get(Producto_.idProducto), id)
					);
			
			producto = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
			
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public List<Producto> findByall() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
			
			Root<Producto> root = criteria.from(Producto.class);
			
			criteria.select(root);
			
			List<Producto> lstProducto = session.createQuery(criteria).getResultList();
			
			tx.commit();
			
			return lstProducto;
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
			return null;
		}
	}

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

	@Override
	public Producto Delete(int id) {
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
			
			// Delete
			producto.setIdProducto(id);
			session.delete(producto);
			
			tx.commit();
		}
		catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}
		return null;
	}
	
	public void closeSession() {
		// TODO Auto-generated method stub
	}

}
