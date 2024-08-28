package com.cavendish.countries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CountriesInMemoryStorage {

    @Autowired
    private ObjectMapper countriesObjectMapper;

    private final TypeReference<List<Country>> countriesListTypeReference = new TypeReference<List<Country>>() {
    };

    private final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {

        List<Country> countriesList;
        try (InputStream countriesStream = this.getClass().getClassLoader().getResourceAsStream("countries.json")) {
            countriesList = this.countriesObjectMapper.readValue(countriesStream, this.countriesListTypeReference);
        }

        for (Country country : countriesList) {
            countries.put(country.cca3(), country);
        }
    }

    public Map<String, Country> countries() {
        return this.countries;
    }
}
