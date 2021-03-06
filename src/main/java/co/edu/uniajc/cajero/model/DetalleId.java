package co.edu.uniajc.cajero.model;
// Generated 7/04/2019 01:08:10 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DetalleId generated by hbm2java
 */
@Entity
@Table(name = "DetalleId")
public class DetalleId implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetalle;
	private int idTransaccion;

	public DetalleId() {
	}

	public DetalleId(int idDetalle, int idTransaccion) {
		this.idDetalle = idDetalle;
		this.idTransaccion = idTransaccion;
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetalleId))
			return false;
		DetalleId castOther = (DetalleId) other;

		return (this.getIdDetalle() == castOther.getIdDetalle())
				&& (this.getIdTransaccion() == castOther.getIdTransaccion());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdDetalle();
		result = 37 * result + this.getIdTransaccion();
		return result;
	}

}
