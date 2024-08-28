package com.cavendish.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

@SpringBootTest
public class CountriesServiceTests {

    @Autowired
    private CountriesService service;

    @Test
    public void findRoute() {
        assertLinesMatch(List.of("HRV", "HUN", "AUT"), service.findRoute("HRV", "AUT"));
        assertLinesMatch(List.of("CZE", "AUT", "ITA"), service.findRoute("CZE", "ITA"));
    }
}
