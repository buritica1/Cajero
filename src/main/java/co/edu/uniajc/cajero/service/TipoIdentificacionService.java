package co.edu.uniajc.cajero.service;



import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import co.edu.uniajc.cajero.dao.ImpTipoIdentificacionDao;
import co.edu.uniajc.cajero.model.TipoIdentificacion;

public class TipoIdentificacionService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImpTipoIdentificacionDao tipoIdentificacionDao;
	
	public TipoIdentificacionService(Session session) {
		
		tipoIdentificacionDao = new ImpTipoIdentificacionDao(session);
	
	}
	
	public TipoIdentificacion findById(int id){
		return tipoIdentificacionDao.findById(id);
	}
	
	public List<TipoIdentificacion> findByIdall() {
		return tipoIdentificacionDao.findByIdall();
	}
	
	public void save(TipoIdentificacion TipoIdentificacion) {
		tipoIdentificacionDao.save(TipoIdentificacion);
	}
	
	public TipoIdentificacion Update(int id,String desc){
		return tipoIdentificacionDao.Update(id,desc);
	}
	public TipoIdentificacion Delete(int id){
		return tipoIdentificacionDao.Delete(id);
	}
	public void closeSession(){
		tipoIdentificacionDao.closeSession();
	}
	
}

