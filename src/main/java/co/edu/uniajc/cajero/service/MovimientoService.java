package co.edu.uniajc.cajero.service;



import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import co.edu.uniajc.cajero.dao.ImpMovimientoDao;
import co.edu.uniajc.cajero.model.Movimiento;


public class MovimientoService implements Serializable{
	
	/**
	 * Servicio 
	 */
	private static final long serialVersionUID = 1L;
	private ImpMovimientoDao movimientoDao;
	
	public MovimientoService(Session session) {
		
		movimientoDao = new ImpMovimientoDao(session);
	
	}
	
	public Movimiento findById(int id){
		return movimientoDao.findById(id);
	}
	
	public List<Movimiento> findByIdall() {
		return movimientoDao.findByIdall();
	}
	
	public void save(Movimiento Movimiento) {
		movimientoDao.save(Movimiento);
	}
	
	public Movimiento Update(int id,String desc){
		return movimientoDao.Update(id,desc);
	}
	public Movimiento Delete(int id){
		return movimientoDao.Delete(id);
	}
	public void closeSession(){
		movimientoDao.closeSession();
	}
	
}
