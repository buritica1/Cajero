package Pruebas_bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import co.edu.uniajc.cajero.model.Banco;
import co.edu.uniajc.cajero.service.BancoServices;
import co.edu.uniajc.cajero.util.HibernateUtil;

@ManagedBean(name = "bancoBean", eager = true)
@RequestScoped
public class BancoBean {


	private String nit, nombre, telefono, direccion;
	
	private List<Banco> lista = new ArrayList<>();
	private BancoServices bancoServices;
	
	public BancoBean() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		BancoServices BancoService = new BancoServices(session);
		bancoServices = new BancoServices(session);
		BancoService.closeSession();
	}

	public void buttonAction() {
		
		bancoServices.save(new Banco(nit,nombre,direccion,telefono));
		addMessage("Datos de usuario enviados!! Descripcion: " + nit);
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void listar() {
		
		lista = bancoServices.findByIdall();
			
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<Banco> getLista() {
		return lista;
	}

	public void setLista(List<Banco> lista) {
		this.lista = lista;
	}

	public BancoServices getBancoServices() {
		return bancoServices;
	}

	public void setBancoServices(BancoServices bancoServices) {
		this.bancoServices = bancoServices;
	}

	

}
