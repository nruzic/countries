package com.cavendish.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private CountriesService service;

    @GetMapping("/routing/{origin}/{destination}")
    public CountriesResponseBody getRoute(@PathVariable String origin, @PathVariable String destination) {
        String originCountryName = origin != null ? origin.toUpperCase() : origin;
        String destinationCountryName = destination != null ? destination.toUpperCase() : destination;
        List<String> route = this.service.findRoute(originCountryName, destinationCountryName);
        return new CountriesResponseBody(route);
    }
}
