package com.atsistemas.curso.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atsistemas.curso.entidades.Cliente;

public interface ClienteDao extends JpaRepository<Cliente,Long>{
	@Query("from Cliente c where c.nombre = :nombre") // la variable (:nombre) debe coincidir con el parámetro
	List<Cliente> consultarPorNombre(String nombre);
	
	//La equivalencia en Spring Data-Jpa es:
	//List<Cliente> FindByNombre(String nombre);
}
