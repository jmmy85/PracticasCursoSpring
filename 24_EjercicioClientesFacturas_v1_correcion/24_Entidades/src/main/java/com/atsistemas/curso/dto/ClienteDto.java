package com.atsistemas.curso.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.atsistemas.curso.entidades.Factura;

public class ClienteDto {
	
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
	private List<FacturaDto> facturas;

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

	public List<FacturaDto> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaDto> facturas) {
		this.facturas = facturas;
	}

}
