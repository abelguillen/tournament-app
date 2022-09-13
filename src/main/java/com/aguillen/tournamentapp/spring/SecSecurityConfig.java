package com.aguillen.tournamentapp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@ComponentScan(basePackages = { "com.aguillen.tournamentapp.security" })
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/login").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/jugador/list").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/jugador/create").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/jugador/{id}").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/jugador/update").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/jugador/delete").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/partido/list").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/partido/create").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/partido/{id}").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/partido/update").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/partido/delete").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/user/list").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/user/{id}").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/user/create").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/user/update").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/user/delete").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/role/list").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/role/{id}").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/role/create").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/role/update").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/role/delete").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/privilege/list").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/privilege/{id}").hasAuthority("READ_PRIVILEGE")
					.antMatchers("/privilege/create").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/privilege/update").hasAuthority("WRITE_PRIVILEGE")
					.antMatchers("/privilege/delete").hasAuthority("WRITE_PRIVILEGE")
					.anyRequest().authenticated()
				.and()
					.cors()
				.and()
					.httpBasic();
	}

	@Bean
	public RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = "ADMIN > USER";
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}

	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandlerCustom() {
		DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
		expressionHandler.setRoleHierarchy(roleHierarchy());
		return expressionHandler;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

}
