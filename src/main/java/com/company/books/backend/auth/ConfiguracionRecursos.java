package com.company.books.backend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ConfiguracionRecursos extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {		
		//Pueden acceder los clientes a esta ruta a traves del metodo Get sin Token de autorización
		 http.authorizeRequests().antMatchers(HttpMethod.GET, "v1/categorias").permitAll()
		 .anyRequest().authenticated();//Para los demas recursos se necesita autenticacion
	}

}
