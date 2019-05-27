package co.edu.uniajc.cajero.model;
// Generated 7/04/2019 01:08:10 PM by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cajero generated by hbm2java
 */
@Entity
@Table(name = "Cajero")
public class Cajero implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCajero;
	private Banco banco;
	private BigDecimal saldo;
	private String ubicacion;
	private int indServicio;
//	private Set transaccions = new HashSet(0);

	public Cajero() {
	}

	public Cajero(Banco banco, BigDecimal saldo, int indServicio) {
		this.banco = banco;
		this.saldo = saldo;
		this.indServicio = indServicio;
	}

	//public Cajero(Banco banco, BigDecimal saldo, String ubicacion, int indServicio, Set transaccions) {
	//	this.banco = banco;
	//	this.saldo = saldo;
	//	this.ubicacion = ubicacion;
	//	this.indServicio = indServicio;
	//	this.transaccions = transaccions;
	//}

	public Integer getIdCajero() {
		return this.idCajero;
	}

	public void setIdCajero(Integer idCajero) {
		this.idCajero = idCajero;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getIndServicio() {
		return this.indServicio;
	}

	public void setIndServicio(int indServicio) {
		this.indServicio = indServicio;
	}

//	public Set getTransaccions() {
//		return this.transaccions;
//	}

	//public void setTransaccions(Set transaccions) {
	//	this.transaccions = transaccions;
	//}

}