package com.cavendish.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CountriesControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRouteFromHrvToAut() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/routing/hrv/aut").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            {
                              "route": ["HRV", "HUN", "AUT"]
                            } 
                        """));
    }
}
