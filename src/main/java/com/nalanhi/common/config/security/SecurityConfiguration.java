package com.nalanhi.common.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nalanhi.common.base.service.CustomUserDetailsService;

/**
 * @author jbeomh@gmail.com
 * @date 2018. 4. 18.
 * security 설정
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder); // 암호화
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic();
		
		http.authorizeRequests()
		    .antMatchers(AUTH_WHITELIST).permitAll()
		    .anyRequest().fullyAuthenticated()
		    .and()
		    .logout().permitAll();
		
		http.formLogin();
		
		// https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf-cookie
		http.csrf().disable();
		// https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#cors
		http.cors();
	}
	
	/*
	 * swagger 등 인증 없이 제공할 서비스
	 * https://stackoverflow.com/questions/37671125/how-to-configure-spring-security-to-allow-swagger-url-to-be-accessed-without-aut 
	 */
    private static final String[] AUTH_WHITELIST = {
    		// swagger-ui files
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // static resource files
            "/resources/**","/image/**","/bootstrap/**","/js/**", "/fonts/**", "/robots.txt"
    };
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired private CustomUserDetailsService userDetailsService;
	@Autowired private PasswordEncoder passwordEncoder;
}
