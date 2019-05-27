package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "tipoIdentificacionBean2", eager = true)
@RequestScoped
public class TipoIdentificacionBean2 {

	private TipoIdentificacionService tipoIdentificacionService;
	
	private List<TipoIdentificacion> lista = new ArrayList<>();
	
	public TipoIdentificacionBean2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TipoIdentificacionService TipoIdentificacionService = new TipoIdentificacionService(session);
		tipoIdentificacionService = new TipoIdentificacionService(session);
		TipoIdentificacionService.closeSession();
	}

	public void listar() {
		
		lista = tipoIdentificacionService.findByIdall();
			
	}

	public List<TipoIdentificacion> getLista() {
		return lista;
	}

	public void setLista(List<TipoIdentificacion> lista) {
		this.lista = lista;
	}
	
	
}
