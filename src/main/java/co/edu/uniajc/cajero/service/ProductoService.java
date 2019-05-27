package co.edu.uniajc.cajero.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

import co.edu.uniajc.cajero.dao.ImpProductoDao;
import co.edu.uniajc.cajero.model.Producto;

public class ProductoService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImpProductoDao productoDao;
	
	public ProductoService(Session session) {
		productoDao = new ImpProductoDao(session);
	}
	
	public void save(Producto producto) {
		productoDao.save(producto);
	}
	
	public Producto finById(int id) {
		return productoDao.findById(id);
	}
	
	public List<Producto> findByIdall() {
		return productoDao.findByall();
	}
	
	public Producto update(Producto producto) {
		return productoDao.Update(producto);
	}
	
	public Producto delete(int id) {
		return productoDao.delete(id);
	}
	
	public void closeSession() {
		productoDao.closeSession();
	}
}
