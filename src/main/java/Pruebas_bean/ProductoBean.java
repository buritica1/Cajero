package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.service.ProductoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "productoBean", eager = true)
@RequestScoped
public class ProductoBean {
	
	private String descripcion;
	private List<Producto> lista = new ArrayList<>();
	private ProductoService productoService;
	
	public ProductoBean() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductoService ProductoService = new ProductoService(session);
		productoService = new ProductoService(session);
		ProductoService.closeSession();
	}
	
	public void buttonAction() {
		productoService.save(new Producto(descripcion));
		addMessage("Datos de Descripcion:" + descripcion);
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void listar() {
		lista = productoService.findByIdall();
	}

	public List<Producto> getLista() {
		return lista;
	}

	public void setLista(List<Producto> lista) {
		this.lista = lista;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
