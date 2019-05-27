package co.edu.uniajc.cajero.dao;

import java.util.List;

import co.edu.uniajc.cajero.model.Producto;

public interface ProductoDao {
	
	public void save(Producto producto);
	public Producto findById(int id);
	public List<Producto> findByall();
	public Producto Update(int id, String desc);
	public Producto Delete(int id);	

}
