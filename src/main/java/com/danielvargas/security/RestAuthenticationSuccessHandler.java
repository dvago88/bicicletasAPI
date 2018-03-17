package com.danielvargas.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.danielvargas.entity.authentication.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//No sé donde poner estas clases... si en el config o en el controller o en otro lado
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        clearAuthenticationAttributes(request);
        User user = (User) authentication.getPrincipal();
        String jwt = tokenHelper.generateToken(user.getUsername());

        UserTokenState userTokenState = new UserTokenState(jwt, EXPIRES_IN, user.getPrimerNombre());
        try {

            String jwtResponse = objectMapper.writeValueAsString(userTokenState);
            response.setContentType("application/json");
            response.getWriter().write(jwtResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private class UserTokenState {
        private String jws;
        private int expires;
        private String userName;

        public UserTokenState(String jws, int expires, String userName) {
            this.jws = jws;
            this.expires = expires;
            this.userName = userName;
        }

        public String getJws() {
            return jws;
        }

        public void setJws(String jws) {
            this.jws = jws;
        }

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expire) {
            this.expires = expire;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}