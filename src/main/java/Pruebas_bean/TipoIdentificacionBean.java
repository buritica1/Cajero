package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "tipoIdentificacionBean", eager = true)
@RequestScoped
public class TipoIdentificacionBean {


	private String descripcion;
	
	private List<TipoIdentificacion> lista = new ArrayList<>();
	private TipoIdentificacionService tipoIdentificacionService;
	
	public TipoIdentificacionBean() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TipoIdentificacionService TipoIdentificacionService = new TipoIdentificacionService(session);
		tipoIdentificacionService = new TipoIdentificacionService(session);
		TipoIdentificacionService.closeSession();
	}

	public void buttonAction() {
		
		tipoIdentificacionService.save(new TipoIdentificacion(descripcion));
		addMessage("Datos de usuario enviados!! Descripcion: " + descripcion);
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
