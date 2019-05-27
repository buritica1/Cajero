package Pruebas_bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import co.edu.uniajc.cajero.model.Movimiento;
import co.edu.uniajc.cajero.service.MovimientoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

/**
 * 
 * 
 *
 */
@ManagedBean(name = "movimientoBean", eager = true)
@RequestScoped
public class MovimientoBean {

	private String descripcion;
	private List<Movimiento> lstMovimientos;
	
	private Session session;
	
	public MovimientoBean() {
		lstMovimientos = new ArrayList<Movimiento>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		this.getLstMovimientos(session);
		
	}

	public void handleKeyEvent() {
		descripcion = descripcion.toUpperCase();
	}
	
	public void getLstMovimientos(Session session) {
		try {
			
			MovimientoService movimientoService = new MovimientoService(session);
			movimientoService = new MovimientoService(session);
			lstMovimientos = movimientoService.findByIdall();
			movimientoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error getLstMovimientos: " + e.toString());
		}
		
	}
	
	public void buttonAction() {
		this.createMovimiento();
		addMessage("Datos de Descripcion:" + descripcion);
	}
	
	public void createMovimiento() {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			MovimientoService movimientoService = new MovimientoService(session);
			movimientoService = new MovimientoService(session);
			movimientoService.save(new Movimiento(descripcion));
			movimientoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error crear movimiento:" + e.toString());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Movimiento Editado", ((Movimiento) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Movimiento Cancelado", ((Movimiento) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void updateMovimiento(Movimiento m) {
		System.out.println("Movimiento a modificar");
		System.out.println("Descripcion: " + m.getDescripcion());
		
		MovimientoService movimientoService = new MovimientoService(session);
		movimientoService = new MovimientoService(session);
		Movimiento movimientoActualizado = movimientoService.update(m);
		movimientoService.closeSession();
		
		System.out.println("Movimiento actualizado: descripcion: " + movimientoActualizado.getDescripcion());
		try {
			
		} catch (Exception e) {
			System.out.println("Error updateMovimiento(Movimiento m)");
		}
	}
	
	public void deleteMovimiento(int idMovimiento, String descripcion) {
		System.out.println("Movimiento eliminado: " + descripcion);
		System.out.println("Tamaño de la lista de Movimiento: " + lstMovimientos.size());
		
		MovimientoService movimientoService = new MovimientoService(session);
		movimientoService = new MovimientoService(session);
		movimientoService.delete(idMovimiento);
		lstMovimientos = movimientoService.findByIdall();
		movimientoService.closeSession();
		
		System.out.println("Tamaño de la lista de de los Movimiento incluyendo el registro eliminado: " + lstMovimientos.size());
		this.addMessage("Movimiento eliminado");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Movimiento> getLstMovimientos() {
		return lstMovimientos;
	}

	public void setLstMovimientos(List<Movimiento> lstMovimientos) {
		this.lstMovimientos = lstMovimientos;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}