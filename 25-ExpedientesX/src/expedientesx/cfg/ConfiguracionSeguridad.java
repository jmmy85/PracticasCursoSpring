package expedientesx.cfg;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("Fernando").password("1234").roles("AGENTE");
	        auth.inMemoryAuthentication().withUser("Mulder").password("fox").roles("AGENTE_ESPECIAL");
	        auth.inMemoryAuthentication().withUser("Scully").password("dana").roles("AGENTE_ESPECIAL");
	        auth.inMemoryAuthentication().withUser("Skinner").password("walter").roles("DIRECTOR");
	}
//	*/
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//	        auth.userDetailsService(userDetailsService());
//	}
//
//	public UserDetailsService userDetailsService(){
//	    Properties usuarios = new Properties();
//	        usuarios.put("Fernando","1234,ROLE_AGENTE,enabled");
//	        usuarios.put("Mulder"  ,"fox,ROLE_AGENTE_ESPECIAL,enabled");
//	        usuarios.put("Scully"  ,"dana,ROLE_AGENTE_ESPECIAL,enabled");
//	        usuarios.put("Skinner" ,"walter,ROLE_DIRECTOR,enabled");
//
//	        return new InMemoryUserDetailsManager(usuarios);
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests()
	        .antMatchers("/**").access("hasAnyRole('AGENTE_ESPECIAL','DIRECTOR')");
	        
	        http
	        .rememberMe()
	                .rememberMeParameter("remember-me-param")
	                .rememberMeCookieName("my-remember-me")
	                .tokenValiditySeconds(86400);
	        http
	        .sessionManagement()
	            .sessionFixation()
	            .migrateSession();
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        PasswordEncoder encoder = new BCryptPasswordEncoder();
	        auth.userDetailsService(userDetailsService()).passwordEncoder(encoder);
	}

	public UserDetailsService userDetailsService(){
	    Properties usuarios = new Properties();
	        usuarios.put("Fernando","$2a$10$SMPYtil7Hs2.cV7nrMjrM.dRAkuoLdYM8NdVrF.GeHfs/MrzcQ/zi,ROLE_AGENTE,enabled");
	        usuarios.put("Mulder"  ,"$2a$10$M2JRRHUHTfv4uMR4NWmCLebk1r9DyWSwCMZmuq4LKbImOkfhGFAIa,ROLE_AGENTE_ESPECIAL,enabled");
	        usuarios.put("Scully"  ,"$2a$10$cbF5xp0grCOGcI6jZvPhA.asgmILATW1hNbM2MEqGJEFnRhhQd3ba,ROLE_AGENTE_ESPECIAL,enabled");
	        usuarios.put("Skinner" ,"$2a$10$ZFtPIULMcxPe3r/5VunbVujMD7Lw8hkqAmJlxmK5Y1TK3L1bf8ULG,ROLE_DIRECTOR,enabled");

	        return new InMemoryUserDetailsManager(usuarios);
	}
}
