package co.edu.uniajc.cajero.dao;

import java.util.List;

import co.edu.uniajc.cajero.model.Banco;


public interface BancoDao{
	
	public void save(Banco Banco);
	public Banco findById(int id);
	public List<Banco> findByIdall();
	public Banco Update(int id ,String nit, String nombre, String direccion, String telefono);
	public Banco Delete(int id);

}
