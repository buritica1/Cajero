package co.edu.uniajc.cajero.dao;


import java.util.List;

import co.edu.uniajc.cajero.model.Movimiento;


public interface MovimientoDao {
	
	public void save(Movimiento Movimiento);
	public Movimiento findById(int id);
	public List<Movimiento> findByIdall();
	public Movimiento Update(int id ,String desc);
	public Movimiento Delete(int id);

}
