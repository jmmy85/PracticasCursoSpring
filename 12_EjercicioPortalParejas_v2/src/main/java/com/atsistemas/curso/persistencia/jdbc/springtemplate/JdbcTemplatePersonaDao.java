package com.atsistemas.curso.persistencia.jdbc.springtemplate;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Repository
public class JdbcTemplatePersonaDao implements PersonaDao {
	

	public static final String INSERT_PERSONAS = "INSERT INTO PERSONA(ID, NOMBRE, EDAD, ALTURA, GENERO) VALUES (?,?,?,?,?)";
	public static final String SELECT_TODAS_PERSONAS = "SELECT ID, NOMBRE, EDAD, ALTURA, GENERO FROM PERSONA";
	public static final String SELECT_PERSONA_NOMBRE = "SELECT ID, NOMBRE, EDAD, ALTURA, GENERO FROM PERSONA WHERE NOMBRE = ?";
	public static final String SELECT_PERSONA_ID = "SELECT ID, NOMBRE, EDAD, ALTURA, GENERO FROM PERSONA WHERE ID = ?";

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplatePersonaDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void insertar(Persona persona) {
		getJdbcTemplate().update(INSERT_PERSONAS,
				persona.getId()
				, persona.getNombre()
				, persona.getEdad()
				, persona.getAltura()
				, persona.getGenero());
	}

	public List<Persona> consultarPorNombre(String nombre) {
		 List<Persona> resultado = getJdbcTemplate().query(SELECT_PERSONA_NOMBRE,new Object[]{nombre}, new PersonaRowMapper());
		 
		 return resultado;
	}

	public Persona consultarPorId(long id) {
		 Persona resultado = getJdbcTemplate().queryForObject(SELECT_TODAS_PERSONAS,new Object[]{id},new PersonaRowMapper());
		 
		 return resultado;
	}

	public Collection<Persona> consultarTodos() {
		 List<Persona> query = (List<Persona>)getJdbcTemplate().query(SELECT_TODAS_PERSONAS,new PersonaRowMapper());
		 
		 return query;
	}

}
