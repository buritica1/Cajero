package co.edu.uniajc.cajero.dao;

import java.util.List;

import co.edu.uniajc.cajero.model.Banco;


public interface BancoDao{
	
	public void save(Banco banco);
	public Banco findById(int id);
	public List<Banco> findByall();
	public Banco Update(Banco B);
	public Banco Delete(int id);	
	
}
