package co.edu.uniajc.cajero.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import co.edu.uniajc.cajero.dao.ImpUsuarioDao;
import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.model.Usuario;

public class UsuarioService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -783299566294239418L;
	private ImpUsuarioDao usuarioDao;
	
	public UsuarioService (Session session) {
		
		usuarioDao = new ImpUsuarioDao(session);
	}
	
	public Usuario findById(int id){
		return usuarioDao.findById(id);
	}
	
//	public Usuario Update(int id ,TipoIdentificacion tipoIdentificacion, String identificacion, String nombre, String apellido, String direccion, String celular, String email, Date fecActualiza){
//		return usuarioDao.Update(id,tipoIdentificacion,identificacion,nombre,apellido, direccion, celular,email,fecActualiza);
//	}
	
	public Usuario update(Usuario u){
		return usuarioDao.Update(u);
	}
	
	public List<Usuario> findByIdall() {
		return usuarioDao.findByIdall();
	}
	
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	public Usuario delete(int id){
		return usuarioDao.delete(id);
	}
	
	public void closeSession(){
		usuarioDao.closeSession();
	}		

}
