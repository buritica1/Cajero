package co.edu.uniajc.cajero.dao;


import java.util.List;

import co.edu.uniajc.cajero.model.TipoIdentificacion;


public interface TipoIdentificacionDao {
	
	public void save(TipoIdentificacion TipoIdentificacion);
	public TipoIdentificacion findById(int id);
	public List<TipoIdentificacion> findByIdall();
	public TipoIdentificacion Update(int id ,String desc);
	public TipoIdentificacion Delete(int id);
	

}
