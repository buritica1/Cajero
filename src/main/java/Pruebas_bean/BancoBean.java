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

import co.edu.uniajc.cajero.model.Banco;
import co.edu.uniajc.cajero.service.BancoServices;
import co.edu.uniajc.cajero.util.HibernateUtil;


@ManagedBean(name = "bancoBean", eager = true)
@RequestScoped
public class BancoBean {
	
	private String nombre;
	private String nit;
	private String telefono;
	private String direccion;
	private List<Banco> lstBancos;

	private Session session;
	
	public BancoBean() {
		lstBancos = new ArrayList<Banco>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		this.getLstBancos(session);
		
	}
	
	public void handleKeyEvent() {
		nombre = nombre.toUpperCase();
	}
	
	public void getLstBancos(Session session) {
		try {
			
			BancoServices bancoService = new BancoServices(session);
			bancoService = new BancoServices(session);
			lstBancos = bancoService.findByIdall();
			bancoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error getLstBancos: " + e.toString());
		}
		
	}
	
	public void buttonAction() {
		this.createProducto();
		addMessage("Datos de Descripcion:" + nombre + "nit" + nit);
	}
	
	public void createProducto() {
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			BancoServices bancoService = new BancoServices(session);
			bancoService = new BancoServices(session);
			bancoService.save(new Banco(nit, nombre, direccion, telefono));
			bancoService.closeSession();
			
		} catch (Exception e) {
			System.out.println("Error crear banco:" + e.toString());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Banco Editado", ((Banco) event.getObject()).getNit());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Banco Cancelado", ((Banco) event.getObject()).getNit());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void updateBanco(Banco b) {
		System.out.println("Banco a modificar");
		System.out.println("Nit: " + b.getNit() + "Nombre: " + b.getNombre());
		
		BancoServices bancoService = new BancoServices(session);
		bancoService = new BancoServices(session);
		Banco bancoActualizado = bancoService.update(b);
		bancoService.closeSession();
		
		System.out.println("Banco actualizado: Nit: " + bancoActualizado.getNit());
		try {
			
		} catch (Exception e) {
			System.out.println("Error updateBanco(Banco B)");
		}
	}
	
	public void deleteBanco(int idBanco, String nit) {
		System.out.println("Banco eliminado: " + nit);
		System.out.println("Tamaño de la lista de Productos: " + lstBancos.size());
		
		BancoServices bancoService = new BancoServices(session);
		bancoService = new BancoServices(session);
		bancoService.delete(idBanco);
		lstBancos = bancoService.findByIdall();
		bancoService.closeSession();
		
		
		
		System.out.println("Tamaño de la lista de de los bancos incluyendo el registro eliminado: " + lstBancos.size());
		this.addMessage("Banco eliminado");
		
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public List<Banco> getLstBancos() {
		return lstBancos;
	}

	public void setLstBancos(List<Banco> lstBancos) {
		this.lstBancos = lstBancos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	
	}
