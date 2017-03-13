package com.atsistemas.curso.entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="idPersona")
	private long id;
	private String nombre;
	private int edad;
	private double altura;
	private String genero;
	
	/*
	private Persona ideal;
	@OneToMany
	private List<Persona> afines;
	*/
	
	// Constructor porque probablemente emplee una clase con un framework que precise
	// construir los objetos con el consntructor por defecto
	public Persona(){
		super();
	}
	
	// Constructor por comodidad
	public Persona(long id,String nombre,int edad, double altura, String genero){
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.genero = genero;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", genero="
				+ genero + "]";
	}
	
	
}
