package com.danielvargas.config;

import com.danielvargas.security.RestAuthenticationEntryPoint;
import com.danielvargas.security.RestAuthenticationFailureHandler;
import com.danielvargas.security.RestAuthenticationSuccessHandler;
import com.danielvargas.security.TokenAuthenticationFilter;
import com.danielvargas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

//TODO: Implementar apropiadamente la seguridad según los roles
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Los errores lo da Intellij por error..
    @Autowired
    private UserService userService;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        /*auth.authenticationProvider(domainUsernamePasswordAuthenticationProvider()).
                authenticationProvider(backendAdminUsernamePasswordAuthenticationProvider()).
                authenticationProvider(tokenAuthenticationProvider());*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
        return new TokenAuthenticationFilter();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization","Authentication", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests().antMatchers(HttpMethod.GET, "/stations").permitAll()
                .anyRequest().hasRole("USER")
                .anyRequest().authenticated()
               /* .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(restAuthenticationEntryPoint)*/
                .and()
                    .formLogin()
                    .loginProcessingUrl("/perform_login")
//                .permitAll()
                    .successHandler(restAuthenticationSuccessHandler)
                    .failureHandler(restAuthenticationFailureHandler)
                .and()
                    .cors()
                .and()
                    .csrf().disable();
//                .csrf().ignoringAntMatchers("/**");//por ahora
//                .csrf().csrfTokenRepository(csrfTokenRepository());

//        create an SQL DDL update script
    }
//AuthenticationSuccessHandler:
//    https://javapointers.com/tutorial/spring-custom-authenticationsuccesshandler-example-2/
//    https://stackoverflow.com/questions/7470405/authenticationsuccesshandler-example-for-spring-security-3

//    best: https://www.codesandnotes.be/2014/10/31/restful-authentication-using-spring-security-on-spring-boot-and-jquery-as-a-web-client/

//    csrf:
//    es de otra pregunta pero la respuesta muestra csrf: https://stackoverflow.com/questions/32498868/custom-login-form-configure-spring-security-to-get-a-json-response

//    https://github.com/aditzel/spring-security-csrf-filter/blob/master/src/main/java/com/allanditzel/springframework/security/web/csrf/CsrfTokenResponseHeaderBindingFilter.java

}
