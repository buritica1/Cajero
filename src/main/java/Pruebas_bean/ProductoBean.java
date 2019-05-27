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

import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.service.ProductoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

/**
 * 
 * @author Miguel Buritica
 *
 */
@ManagedBean(name = "productoBean", eager = true)
@RequestScoped
public class ProductoBean {
	
	private String descripcion;
	private List<Producto> lstProductos;

	private Session session;
	
	public ProductoBean() {
		lstProductos = new ArrayList<Producto>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		this.getLstProductos(session);
		
	}
	
	public void handleKeyEvent() {
		descripcion = descripcion.toUpperCase();
	}
	
	public void getLstProductos(Session session) {
		try {
			
			ProductoService productoService = new ProductoService(session);
			productoService = new ProductoService(session);
			lstProductos = productoService.findByIdall();
			productoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error getLstProductos: " + e.toString());
		}
		
	}
	
	public void buttonAction() {
		this.createProducto();
		addMessage("Datos de Descripcion:" + descripcion);
	}
	
	public void createProducto() {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			ProductoService productoService = new ProductoService(session);
			productoService = new ProductoService(session);
			productoService.save(new Producto(descripcion));
			productoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error crear producto:" + e.toString());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Producto Editado", ((Producto) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Producto Cancelado", ((Producto) event.getObject()).getDescripcion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void updateProducto(Producto p) {
		System.out.println("Producto a modificar");
		System.out.println("Descripcion: " + p.getDescripcion());
		
		ProductoService productoService = new ProductoService(session);
		productoService = new ProductoService(session);
		Producto productoActualizado = productoService.update(p);
		productoService.closeSession();
		
		System.out.println("Producto actualizado: descripcion: " + productoActualizado.getDescripcion());
		try {
			
		} catch (Exception e) {
			System.out.println("Error updateProducto(Producto p)");
		}
	}
	
	public void deleteProducto(int idProducto, String descripcion) {
		System.out.println("Producto eliminado: " + descripcion);
		System.out.println("Tamaño de la lista de Productos: " + lstProductos.size());
		
		ProductoService productoService = new ProductoService(session);
		productoService = new ProductoService(session);
		productoService.delete(idProducto);
		lstProductos = productoService.findByIdall();
		productoService.closeSession();
		
		System.out.println("Tamaño de la lista de de los producto incluyendo el registro eliminado: " + lstProductos.size());
		this.addMessage("Producto eliminado");
		
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
