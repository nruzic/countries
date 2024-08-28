package com.cavendish.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CountriesRepository {

    @Autowired
    private CountriesInMemoryStorage storage;

    public Map<String, Country> getCountries() {
        return this.storage.countries();
    }

}
