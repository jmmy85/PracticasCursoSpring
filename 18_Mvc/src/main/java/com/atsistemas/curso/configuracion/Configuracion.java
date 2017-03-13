package com.atsistemas.curso.configuracion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.atsistemas.curso.controladores.interceptores.CustomInterceptor;

@Configuration
@EnableWebMvc // Activa unos HandlerMappings
@ComponentScan("com.atsistemas.curso.controladores")
public class Configuracion extends WebMvcConfigurerAdapter {
	
	// Interceptors son aspectos (ServletFilter del mundo de Spring)
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor());
		registry.addInterceptor(new LocaleChangeInterceptor());
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("inicio");
		//super.addViewControllers(registry);
	}

	@Bean
	public InternalResourceViewResolver viewResolver(){
		return new InternalResourceViewResolver("WEB-INF/Paginas/",".jsp");
	}

}
