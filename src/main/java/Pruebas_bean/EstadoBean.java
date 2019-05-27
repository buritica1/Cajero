package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.Estado;
import co.edu.uniajc.cajero.service.EstadoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "estadoBean", eager = true)
@RequestScoped
public class EstadoBean {


	private String descripcion;
	
	private List<Estado> lista = new ArrayList<>();
	private EstadoService estadoService;
	
	public EstadoBean() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EstadoService EstadoService = new EstadoService(session);
		estadoService = new EstadoService(session);
		EstadoService.closeSession();
	}

	public void buttonAction() {
		
		estadoService.save(new Estado(descripcion));
		addMessage("Datos de usuario enviados!! Descripcion: " + descripcion);
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void listar() {
		
		lista = estadoService.findByIdall();
			
	}

	public List<Estado> getLista() {
		return lista;
	}

	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
