package co.edu.uniajc.cajero.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

import co.edu.uniajc.cajero.dao.ImpBancoDao;
import co.edu.uniajc.cajero.model.Banco;

public class BancoServices implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImpBancoDao bancoDao;
	
	public BancoServices(Session session) {
		bancoDao = new ImpBancoDao(session);
	}
	
	public void save(Banco banco) {
		bancoDao.save(banco);
	}
	
	public Banco finById(int id) {
		return bancoDao.findById(id);
	}
	
	public List<Banco> findByIdall() {
		return bancoDao.findByall();
	}
	
	public Banco update(Banco banco) {
		return bancoDao.Update(banco);
	}
	
	public Banco delete(int id) {
		return bancoDao.Delete(id);
	}
	
	public void closeSession() {
		bancoDao.closeSession();
	}
}
