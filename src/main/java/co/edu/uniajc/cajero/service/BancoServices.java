package co.edu.uniajc.cajero.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;


import co.edu.uniajc.cajero.dao.ImpBancoDao;
import co.edu.uniajc.cajero.dao.ImpTipoIdentificacionDao;
import co.edu.uniajc.cajero.dao.ImpUsuarioDao;
import co.edu.uniajc.cajero.model.Banco;
import co.edu.uniajc.cajero.model.TipoIdentificacion;

public class BancoServices implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ImpBancoDao bancoDao;
	
	public BancoServices(Session session) {
		
		bancoDao = new ImpBancoDao(session);
	
	}
	
	public Banco findById(int id){
		return bancoDao.findById(id);
	}
	
	public List<Banco> findByIdall() {
		return bancoDao.findByIdall();
	}
	
	public void save(Banco Banco) {
		bancoDao.save(Banco);
	}
	
	public Banco Update(int id,String nit, String nom,String dir,String tel){
		return bancoDao.Update(id,nit,nom,dir,tel);
	}
	public Banco Delete(int id){
		return bancoDao.Delete(id);
	}
	public void closeSession(){
		bancoDao.closeSession();
	}
	

}
