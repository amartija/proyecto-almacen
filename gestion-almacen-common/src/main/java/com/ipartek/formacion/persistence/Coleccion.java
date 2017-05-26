package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity(name = "coleccion")
@Table(name = "coleccion")
@NamedQueries({ @NamedQuery(name = "coleccion.getAll", query = "SELECT co FROM coleccion co") })
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "coleccion.getPrendas", procedureName = "prendagetByColeccion", resultClasses = Prenda.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class) }) })
public class Coleccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	private String year;
	private String gama;
	private String tematica;
	private Date fEntrada;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "codigo_fabricante")
	private Fabricante fabricante;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "coleccion_prenda", joinColumns = {
			@JoinColumn(name = "codigo_coleccion") }, inverseJoinColumns = { @JoinColumn(name = "codigo_prenda") })
	private List<Prenda> prendas;

	/**
	 * @return the prendas
	 */
	public List<Prenda> getPrendas() {
		return prendas;
	}

	/**
	 * @param prendas
	 *            the prendas to set
	 */
	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	/**
	 * @return the fabricante
	 */
	public Fabricante getFabricante() {
		return fabricante;
	}

	/**
	 * @param fabricante
	 *            the fabricante to set
	 */
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Coleccion() {
		super();

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Date getfEntrada() {
		return fEntrada;
	}

	public void setfEntrada(Date fEntrada) {
		this.fEntrada = fEntrada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Coleccion && this.codigo == ((Coleccion) obj).getCodigo()) {
			iguales = true;
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "Coleccion [codigo=" + codigo + ", year=" + year + ", tematica=" + tematica + "]";
	}

}
