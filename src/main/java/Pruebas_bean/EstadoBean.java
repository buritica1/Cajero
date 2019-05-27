package Pruebas_bean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import co.edu.uniajc.cajero.model.Estado;
import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.service.EstadoService;
import co.edu.uniajc.cajero.service.ProductoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "estadoBean", eager = true)
@RequestScoped

public class EstadoBean {
	
	private String descripcion;
	private List<Estado> lstEstado;

	private Session session;
	
	public EstadoBean() {
		lstEstado= new ArrayList<Estado>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		this.getLstEstado(session);
		
	}
	
	public void handleKeyEvent() {
		descripcion = descripcion.toUpperCase();
	}
	
	public void getLstEstado(Session session) {
		try {
			
			EstadoService estadoService = new EstadoService(session);
			estadoService = new EstadoService(session);
			lstEstado= estadoService.findByIdall();
			estadoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error getLstEstado: " + e.toString());
		}
		
	}
	
	public void buttonAction() {
		this.createEstado();
		addMessage("Datos de Descripcion:" + descripcion);
	}
	
	public void createEstado() {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			EstadoService estadoService = new EstadoService(session);
			estadoService = new EstadoService(session);
			estadoService.save(new Estado(descripcion));
			estadoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error crear Estado:" + e.toString());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado Editado", ((Estado) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Estado Cancelado", ((Estado) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void updateEstado(Estado E) {
		System.out.println("Estado a modificar");
		System.out.println("Descripcion: " + E.getDescripcion());
		
		EstadoService estadoService = new EstadoService(session);
		estadoService = new EstadoService(session);
		Estado estadoActualizado = estadoService.Update(E);
		estadoService.closeSession();
		
		System.out.println("Estado actualizado: descripcion: " + estadoActualizado.getDescripcion());
		try {
			
		} catch (Exception e) {
			System.out.println("Error updateEstado(Estado E)");
		}
	}
	
	public void deleteEstado(int idEstado, String descripcion) {
		System.out.println("Estado eliminado: " + descripcion);
		System.out.println("Tamaño de la lista de Estados: " + lstEstado.size());
		
		EstadoService estadoService = new EstadoService(session);
		estadoService = new EstadoService(session);
		estadoService.Delete(idEstado);
		lstEstado= estadoService.findByIdall();
		estadoService.closeSession();
		
		System.out.println("Tamaño de la lista de de los Estados incluyendo el registro eliminado: " + lstEstado.size());
		this.addMessage("Estado eliminado");
		
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Estado> getLstEstado() {
		return lstEstado;
	}

	public void setLstEstado(List<Estado> lstEstado) {
		this.lstEstado= lstEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
