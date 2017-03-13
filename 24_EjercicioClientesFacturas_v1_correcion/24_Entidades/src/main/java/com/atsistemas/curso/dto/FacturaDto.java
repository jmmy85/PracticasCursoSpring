package com.atsistemas.curso.dto;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.atsistemas.curso.entidades.Cliente;

public class FacturaDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double cantidad;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
}
