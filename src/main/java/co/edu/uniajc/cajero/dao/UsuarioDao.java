package co.edu.uniajc.cajero.dao;

import java.util.Date;
import java.util.List;


import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.model.Usuario;

public interface UsuarioDao {	
	
	public void save(Usuario usuario);
	public List<Usuario> findByIdall();
	public Usuario findById(int id);
	//public Usuario Update(int id ,TipoIdentificacion tipoIdentificacion, String identificacion, String nombre, String apellido, String direccion, String celular, String email, Date fecActualiza);
	public Usuario Update(Usuario u);
	public Usuario delete(int id);
}
