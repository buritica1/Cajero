package co.edu.uniajc.cajero.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

import co.edu.uniajc.cajero.dao.ImpMovimientoDao;
import co.edu.uniajc.cajero.model.Movimiento;

public class MovimientoService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImpMovimientoDao movimientoDao;
	
	public MovimientoService(Session session) {
		movimientoDao = new ImpMovimientoDao(session);
	}
	
	public void save(Movimiento movimiento) {
		movimientoDao.save(movimiento);
	}
	
	public Movimiento findById(int id){
		return movimientoDao.findById(id);
	}
	
	public List<Movimiento> findByIdall() {
		return movimientoDao.findByIdall();
	}
	
	public Movimiento update(Movimiento m){
		return movimientoDao.Update(m);
	}
	
	public Movimiento delete(int id){
		return movimientoDao.delete(id);
	}
	
	public void closeSession(){
		movimientoDao.closeSession();
	}	
}