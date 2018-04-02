package com.danielvargas.authentication;


import com.danielvargas.controller.StationController;
import com.danielvargas.repository.data.StationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class AuthenticationTest {

    private MockMvc mockMvc;
    @InjectMocks
    private StationController stationController;

    @Mock
    private StationRepository repository;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
                .standaloneSetup(stationController)
//                .apply(springSecurity())
                .build();
    }

    @Test
    public void stations_ShouldAlwaysReturnOk() throws Exception {
        mockMvc.perform(get("/stations")).andExpect(status().isOk());
    }

    @Test
    public void unauthenticatedUsersShouldNotBeAllow() throws Exception {
        mockMvc.perform(get("stations/1")).andExpect(status().isForbidden());
    }
}
