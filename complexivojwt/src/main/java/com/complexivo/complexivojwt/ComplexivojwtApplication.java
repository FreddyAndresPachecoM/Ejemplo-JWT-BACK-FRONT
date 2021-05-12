package com.complexivo.complexivojwt;

import com.complexivo.complexivojwt.auth.JWTAuthorizationFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ComplexivojwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplexivojwtApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.cors().and().csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/login").permitAll()
			.antMatchers(HttpMethod.GET,"/crear-prueba").permitAll()
			.antMatchers(HttpMethod.POST,"/crear").permitAll()
			.antMatchers(HttpMethod.PUT,"/actualizar/{id}").permitAll()
			.antMatchers(HttpMethod.DELETE,"/eliminar/{id}").permitAll()
			.antMatchers(HttpMethod.GET,"/login/{username}/{contrasena}").permitAll()
			.anyRequest().authenticated();
		}


	}

}
