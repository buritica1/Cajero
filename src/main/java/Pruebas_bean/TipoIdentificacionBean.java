package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "tipoIdentificacionBean", eager = true)
@RequestScoped
public class TipoIdentificacionBean {


	private String descripcion;
	private List<TipoIdentificacion> lstIdentificaciones;
	
	private Session session;
	
	public TipoIdentificacionBean() {
		lstIdentificaciones = new ArrayList<TipoIdentificacion>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		this.getLstIdentificaciones(session);
	}
	
	public void handleKeyEvent() {
		descripcion = descripcion.toUpperCase();
	}
	
	public void getLstIdentificaciones(Session session) {
		try {
			
			TipoIdentificacionService tipoIdentificacionService = new TipoIdentificacionService(session);
			tipoIdentificacionService = new TipoIdentificacionService(session);
			lstIdentificaciones = tipoIdentificacionService.findByIdall();
			tipoIdentificacionService.closeSession();
			
		} catch(Exception e) {
			System.out.println("Error getLstIdentificaciones: " + e.toString());
		}
	}
	
	public void buttonAction() {
		this.createTipoIdentificacion();
		addMessage("Datos de Descripcion:" + descripcion);
	}
	
	public void createTipoIdentificacion() {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			TipoIdentificacionService tipoIdentificacionService = new TipoIdentificacionService(session);
			tipoIdentificacionService.save(new TipoIdentificacion(descripcion));
			tipoIdentificacionService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error crear Tipo de Identificacion: " + e.toString());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Tipo de Identificacion Editado", ((TipoIdentificacion) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Tipo de Identificacion Cancelado", ((TipoIdentificacion) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void updateTipoIdentificacion(TipoIdentificacion tp) {
		System.out.println("Tipo de identificacion a modificar");
		System.out.println("Descripcion: " + tp.getDescripcion());
		
		TipoIdentificacionService tipoIdentificacionService = new TipoIdentificacionService(session);
		tipoIdentificacionService = new TipoIdentificacionService(session);
		TipoIdentificacion tipoidentificacionActualizado = tipoIdentificacionService.Update(tp);
		tipoIdentificacionService.closeSession();
		
		System.out.println("Tipo de Identificacion actualizado: descripcion: " + tipoidentificacionActualizado.getDescripcion());
		try {
			
		} catch (Exception e) {
			System.out.println("Error updateTipoIdentificacion(TipoIdentificacion tp)");
		}
	}
	
	public void deleteTipoIdentificacion(int idIdentificacion, String descripcion) {
		System.out.println("Tipo de identificacion eliminado: " + descripcion);
		System.out.println("Tamaño de la lista de tipo identificaciones: " + lstIdentificaciones.size());
		
		TipoIdentificacionService tipoIdentificacionService = new TipoIdentificacionService(session);
		tipoIdentificacionService = new TipoIdentificacionService(session);
		tipoIdentificacionService.delete(idIdentificacion);
		lstIdentificaciones = tipoIdentificacionService.findByIdall();
		tipoIdentificacionService.closeSession();
		
		System.out.println("Tamaño de la lista de de los Tipo de Identificacion incluyendo el registro eliminado: " + lstIdentificaciones.size());
		this.addMessage("Tipo de Identificacion");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<TipoIdentificacion> getLstIdentificaciones() {
		return lstIdentificaciones;
	}

	public void setLstIdentificaciones(List<TipoIdentificacion> lstIdentificaciones) {
		this.lstIdentificaciones = lstIdentificaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
