package co.edu.uniajc.cajero.dao;


import java.util.List;

import co.edu.uniajc.cajero.model.Estado;


public interface EstadoDao {
	
	public void save(Estado Estado);
	public Estado findById(int id);
	public List<Estado> findByIdall();
	public Estado Update(Estado E);
	public Estado Delete(int id);
	

}