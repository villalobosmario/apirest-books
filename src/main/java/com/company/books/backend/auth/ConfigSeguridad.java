package com.company.books.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigSeguridad extends WebSecurityConfigurerAdapter {
    
	@Autowired
	public UserDetailsService usuarioService;
	
	@Bean
	public BCryptPasswordEncoder passwordEnconder( ) {
		return new BCryptPasswordEncoder();
	}

	@Bean("authenticationManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}



	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEnconder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {		
		//Pueden acceder los clientes a esta ruta a traves del metodo Get sin Token de autorización
/*		 http.authorizeRequests().antMatchers(HttpMethod.GET, "v1/categorias").permitAll()
		 .anyRequest().authenticated()//Para los demas recursos se necesita autenticacion
		 .and().csrf().disable()//Deshabilita la regla de origenes cruzado 
		 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
	}

	@Override
	public void configure(WebSecurity web) throws Exception {//El sistema ignora estas URI para acceder a Swagger UI 
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/**", "/swagger-resources/**",
				"/swagger-ui.html", "webjars/**", "/api-docs/**");
	}
	
	
	
}
