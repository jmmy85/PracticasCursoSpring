package com.atsistemas.curso.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FACTURAS")
//@Access(AccessType.PROPERTY)
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NOMBRE") //Si coinciden no es necesario, pero se pone en este caso para tener un ejemplo
	private String nombre;
	
	// "cliente" es el nombre del campo que tenemos en Facturas
	@OneToMany(mappedBy="cliente")
	// En caso de mapeo unidireccional, habría que indicar el nombre del campo dentro de la tabla
	// que contiene la FK que referencia a la tabla CLIENTES
	//@JoinColumn(name="ID_CLIENTE")
	private List<Factura> facturas;
	
	// Porque al usar Hibernate, éste nos lo exige,
	// es el único que es capaz de emplear
	public Cliente() {
		super();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Cliente(String nombre, List<Factura> facturas) {
		super();
		this.nombre = nombre;
		this.facturas = facturas;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
