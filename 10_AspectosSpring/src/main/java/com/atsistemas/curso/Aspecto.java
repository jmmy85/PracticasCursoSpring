package com.atsistemas.curso;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// La lógica que quiero ejecutar cuando se intercepte la ejecución de los beans
@Aspect
@Component
public class Aspecto {
	
	@Pointcut("execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String)) && args(num)")
	public void concreto(String num){}
	
	@Before(value="concreto(numero)")
	public void antesDelTarget(String numero){
		System.out.println("Antes del Target con dato: " + numero);
	}
	
	@After(value="concreto(numero)")
	public void despuesDelTarget(String numero){
		System.out.println("Después del Target con dato: " + numero);
	}
	
	@AfterReturning("execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String))")
	public void despuesDelTargetFiltrandoElResultado(String retorno){
		System.out.println("Después del Target con retorno: " + retorno);
	}
	
	@Around("execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String))")
	public void duranteElTarget(ProceedingJoinPoint pjp) throws Throwable {
		Object[] parametros = pjp.getArgs();
		System.out.println("El numero recibido es: " + parametros[0]);
		Object resultado = pjp.proceed(parametros);
		System.out.println("El resultado es: " + resultado);
	}

}
