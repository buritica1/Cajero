package co.edu.uniajc.cajero.model;
// Generated 7/04/2019 01:08:10 PM by Hibernate Tools 5.2.12.Final


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Movimiento generated
 */
@Entity
@Table(name = "Movimiento")
public class Movimiento implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMovimiento;
	private String descripcion;


	public Movimiento() {
	}
	
	public Movimiento(String string, int i, String string2) {
	}

	public Movimiento(String descripcion) {
		this.descripcion = descripcion;

	}
	
	public Integer getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
