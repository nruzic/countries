package com.cavendish.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountriesInMemoryStorageTests {

    @Autowired
    private CountriesInMemoryStorage storage;

    @Test
    public void countries() {
        Map<String, Country> countries = storage.countries();
        assertEquals(250, countries.size());
        for (Country country : countries.values()) {
            System.out.println(country);
        }
    }
}
