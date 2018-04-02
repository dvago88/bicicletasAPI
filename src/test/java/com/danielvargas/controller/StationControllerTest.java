package com.danielvargas.controller;

import com.danielvargas.entity.data.Station;
import com.danielvargas.repository.data.StationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StationControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private StationController stationController;

    @Mock
    private StationRepository repository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(stationController)
                .build();
    }

    @Test
    public void stations_ReturnListOfStationsAsJson() throws Exception {
        List<Station> stations = Arrays.asList(
                new Station(1, true, 3),
                new Station(2, true, 0),
                new Station(3, true, 1),
                new Station(4, false, 3)
        );
        when(repository.findAll()).thenReturn(stations);

        mockMvc.perform(get("/stations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        verify(repository).findAll();
    }

    @Test
    public void station_number_ReturnThatStationAsJson() throws Exception {
        Station station = new Station(1, true, 2);
        when(repository.findById(1)).thenReturn(station);

        mockMvc.perform(get("/stations/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        verify(repository).findById(1);
    }

    @Test
    public void postANewStationShouldAddItAndReturn201AndTheNewlyCreatedStation() throws Exception {
        MvcResult result = mockMvc.perform(post("/stations/1"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

// El resultado lo convertimos a string y luego a un objeto para revisar si devuelve lo correcto
        String content = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        Station station = mapper.readValue(content, Station.class);
        assertEquals(station.getId(), 1);
        assertEquals(station.getNumberOfUses(), 0);
        assertFalse(station.isAvailable());
    }

    @Test
    public void postAnExistingUnavailableStationShouldReturn202AndTheStationWithOneExtraUse() throws Exception {
        Station station = new Station(1, false, 2);
        when(repository.findById(1)).thenReturn(station);

        MvcResult result = mockMvc.perform(post("/stations/1"))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        Station stationResponse = mapper.readValue(content, Station.class);
        assertEquals(stationResponse.getId(), 1);
        assertEquals(stationResponse.getNumberOfUses(), 3);
        assertTrue(stationResponse.isAvailable());
    }

    @Test
    public void postAnExistingAvailableStationShouldReturn202AndTheStationWithSameUse() throws Exception {
        Station station = new Station(1, true, 2);
        when(repository.findById(1)).thenReturn(station);

        MvcResult result = mockMvc.perform(post("/stations/1"))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        Station stationResponse = mapper.readValue(content, Station.class);
        assertEquals(stationResponse.getId(), 1);
        assertEquals(stationResponse.getNumberOfUses(), 2);
        assertFalse(stationResponse.isAvailable());
    }

    @Test
    public void ifStationIsNotFoundReturn404() {
//        TODO: crear este test, no debe pasar en el momento...
    }
}

