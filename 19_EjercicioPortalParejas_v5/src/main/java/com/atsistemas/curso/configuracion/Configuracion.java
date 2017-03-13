package com.atsistemas.curso.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScans({
@ComponentScan("com.atsistemas.curso.controladores"),
@ComponentScan("com.atsistemas.curso.servicios"),
@ComponentScan("com.atsistemas.curso.negocio")})
@EnableJpaRepositories("com.atsistemas.curso.persistencia")
@EnableWebMvc
public class Configuracion {

}
