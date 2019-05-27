package co.edu.uniajc.cajero.dao;

import java.util.List;

import co.edu.uniajc.cajero.model.Movimiento;

public interface MovimientoDao {
	
	public void save(Movimiento movimiento);
	public List<Movimiento> findByIdall();
	public Movimiento findById(int id);
	public Movimiento Update(Movimiento m);
	public Movimiento delete(int id);

}