package com.order.management.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.jaasapi.JaasApiIntegrationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Value("${username}")
//	private String adminUsername;
//
//	@Value("${password}")
//	private String adminPassword;

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		DefaultHttpFirewall firewall = new DefaultHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		//firewall.setAllowSemicolon(true);
		return firewall;
	}

	@Override
	public void configure(WebSecurity web) {
		web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}

	@Bean
	public JaasApiIntegrationFilter jaasApiIntegrationFilter() {
		JaasApiIntegrationFilter filter = new JaasApiIntegrationFilter();
		filter.setCreateEmptySubject(true);
		return filter;
	}

	@Bean
	public FilterRegistrationBean<JaasApiIntegrationFilter> jassApiFilterRegistration() {
		FilterRegistrationBean<JaasApiIntegrationFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(jaasApiIntegrationFilter());
		return registration;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll();
		//.antMatchers("/hawtio/**").hasAuthority("PRIV_ADMINCONSOLE")
		//.antMatchers("/controller/**").hasAuthority("PRIV_CONTROLLER");

		http.httpBasic();

		http.csrf().disable();
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//		.withUser(adminUsername).password(adminPassword).roles("ADMIN")
//		.authorities("PRIV_CONTROLLER", "PRIV_ADMINCONSOLE");
//	}

}
