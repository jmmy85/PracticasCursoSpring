package com.atsistemas.curso.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atsistemas.curso.entidades.Factura;

public interface FacturaDao extends JpaRepository<Factura,Long> {
	@Query("from Factura f where f.cantidad = :cant")
	List<Factura> consultarPorCantidad(float cantidad);
}
