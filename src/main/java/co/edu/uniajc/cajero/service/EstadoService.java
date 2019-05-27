package co.edu.uniajc.cajero.service;



import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import co.edu.uniajc.cajero.dao.ImpEstadoDao;
import co.edu.uniajc.cajero.model.Estado;

public class EstadoService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImpEstadoDao EstadoDao;
	
	public EstadoService(Session session) {
		
		EstadoDao = new ImpEstadoDao(session);
	
	}
	
	public Estado findById(int id){
		return EstadoDao.findById(id);
	}
	
	public List<Estado> findByIdall() {
		return EstadoDao.findByIdall();
	}
	
	public void save(Estado Estado) {
		EstadoDao.save(Estado);
	}
	
	public Estado Update(int id,String desc){
		return EstadoDao.Update(id,desc);
	}
	public Estado Delete(int id){
		return EstadoDao.Delete(id);
	}
	public void closeSession(){
		EstadoDao.closeSession();
	}
	
}

