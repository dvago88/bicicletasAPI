package com.danielvargas.controller;

import com.danielvargas.entity.authentication.Role;
import com.danielvargas.entity.authentication.User;
import com.danielvargas.entity.data.Station;
import com.danielvargas.entity.historial.Historial;
import com.danielvargas.repository.authentication.UserRepository;
import com.danielvargas.repository.data.StationRepository;
import com.danielvargas.repository.historial.HistorialRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class HistorialControllerTest {

    private MockMvc mockMvc;
    private User user;

    @InjectMocks
    private HistorialController controller;

    @Mock
    private StationRepository stationRepository;

    @Mock
    private HistorialRepository historialRepository;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
        Role role = new Role(1, "ADMIN");
        user = new User(1, "aaaa", role);
    }

    @Test
    public void createNewHistorial() throws Exception {
        Station station = new Station(1, true, 2);

        when(stationRepository.findById(1)).thenReturn(station);
        when(userRepository.findByCodigo("aaaa")).thenReturn(user);

        doAnswer(invocation -> {
            Historial h = (Historial) invocation.getArguments()[0];
            h.setId(1L);
            h.setUser(user);
            return null;
        }).when(historialRepository).save(any(Historial.class));

        mockMvc.perform(post("/historial/1/aaaa").content("1522618107206").contentType(MediaType.APPLICATION_JSON)/*.contentType(MediaType.APPLICATION_JSON_UTF8)*/)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
                .andReturn();
    }
}
