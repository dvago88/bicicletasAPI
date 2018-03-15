package com.danielvargas.config.security;

import com.danielvargas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    UserService userService;

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTH_HEADER);
        System.out.println("AUTH_HEADER");
        System.out.println(authHeader);
        System.out.println("Authentication header:");
        System.out.println(request.getHeader("Authentication"));
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String error = "";
        String authToken = getToken(request);
        if (authToken != null) {
            //obtenemos el usuario del token
            String username = tokenHelper.getUsernameFromToken(authToken);
            if (username != null) {
                //Obetenemos el usuaio
                UserDetails userDetails = userService.loadUserByUsername(username);
                //Creamos la autenticación
                TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                authentication.setToken(authToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                error = "Nombre de usuario del token no encontrado en la Base de Datos";
            }
        }
        if (!error.equals("")) {
            System.out.println(error);
            SecurityContextHolder.getContext().setAuthentication(new AnonAuthentication());//previene que se cargue /login
        }
        chain.doFilter(request, response);
    }
}