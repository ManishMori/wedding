package com.buildingoutloud.wedding.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.buildingoutloud.wedding.handler.WeddingAppAccessDeniedHandler;
import com.buildingoutloud.wedding.handler.WeddingAppAuthenticationEntryPoint;
import com.buildingoutloud.wedding.handler.WeddingAppAuthenticationFailureHandler;
import com.buildingoutloud.wedding.handler.WeddingAppAuthenticationSuccessHandler;
import com.buildingoutloud.wedding.handler.WeddingAppLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WeddingAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.authorizeRequests().antMatchers("/registration", "/login")
			.permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint())
			.accessDeniedHandler(accessDeniedHandler())
			.and()
			.formLogin()
			.successHandler(successHandler())
			.failureHandler(failureHandler())
			.permitAll()
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessHandler(logoutSuccessHandler())
			.permitAll();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new WeddingAppLogoutSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler failureHandler() {
		return new WeddingAppAuthenticationFailureHandler();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new WeddingAppAuthenticationSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WeddingAppAccessDeniedHandler();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new WeddingAppAuthenticationEntryPoint();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(AuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider AuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
}
