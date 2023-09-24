package com.booking.springdemo.controller;

import com.booking.springdemo.entity.Hotel;
import com.booking.springdemo.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    Logger logger = LoggerFactory.getLogger(HelloWorldControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HotelRepository hotelRepository;

    @BeforeEach
    void setup() {
        Hotel alex = new Hotel(100L, "alex");
        Hotel blex = new Hotel(102L, "blex");
        Hotel clex = new Hotel(103L, "clex");
        hotelRepository.saveAllAndFlush(Arrays.asList(alex, blex, clex));
        logger.info("added data to db");
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.stream().map(Hotel::toString).forEach(logger::info);
    }

    @Test
    void demoTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/booking/hotel-id/100")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


        String responseString = result.getResponse().getContentAsString();
        logger.info(responseString);
        assertNotNull(responseString);
    }


}