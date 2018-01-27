package com.danielvargas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .and()
                .csrf().ignoringAntMatchers("/**");
//                .csrf().csrfTokenRepository(csrfTokenRepository());

//        create an SQL DDL update script
    }

}
