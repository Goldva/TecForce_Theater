//package com.tecforce.theater.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//    private UserDetailsService userDetailsService;
//
//	@Autowired
//	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.userDetailsService(userDetailsService)
//				.passwordEncoder(getShaPasswordEncoder());
//	}
//
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
////		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
////
////	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable();
//		http.authorizeRequests()
//				.antMatchers("/callback", "/username").permitAll()
//				.antMatchers("/**").authenticated()
//				.and()
//				.logout().permitAll();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
//
//	@Bean
//	public ShaPasswordEncoder getShaPasswordEncoder(){
//		return new ShaPasswordEncoder();
//	}
//
//
//}