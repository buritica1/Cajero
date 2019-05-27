package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.Movimiento;
import co.edu.uniajc.cajero.service.MovimientoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "movimientoBean", eager = true)
@RequestScoped
public class MovimientoBean {


	private String descripcion;
	
	private List<Movimiento> lista = new ArrayList<>();
	private MovimientoService movimientoService;
	
	public MovimientoBean() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MovimientoService MovimientoService = new MovimientoService(session);
		movimientoService = new MovimientoService(session);
		MovimientoService.closeSession();
	}

	public void buttonAction() {
		
		movimientoService.save(new Movimiento(descripcion));
		addMessage("Datos de movimiento enviados!! Descripcion: " + descripcion);
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void listar() {
		
		lista = movimientoService.findByIdall();
			
	}

	public List<Movimiento> getLista() {
		return lista;
	}

	public void setLista(List<Movimiento> lista) {
		this.lista = lista;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}