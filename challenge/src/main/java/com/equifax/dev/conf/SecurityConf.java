package com.equifax.dev.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity security) throws Exception {
	security.authorizeRequests().antMatchers("/index").permitAll().antMatchers("/").permitAll().anyRequest().authenticated();
	}
}
