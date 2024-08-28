package com.cavendish.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountriesService {

    private static final Logger logger = LoggerFactory.getLogger(CountriesService.class);

    @Autowired
    private CountriesRepository repository;

    @Cacheable(cacheNames = {"findRouteCache"})
    public List<String> findRoute(String origin, String destination) {
        logger.info("Calculating route from {} to {}", origin, destination);
        final List<String> route = this.findRouteUsingBFS(origin, destination, repository.getCountries());
        if (route == null)
                throw new CountriesNoRouteException("No route found for origin: " + origin + " and destination: " + destination);
        return route;
    }

    private List<String> findRouteUsingBFS(String originCountryName, String destinationCountryName, Map<String, Country> countries) {

        final Country originCountry = countries.get(originCountryName);
        if (originCountry == null) // Origin country not found
            return null;

        final Country destinationCountry = countries.get(originCountryName);
        if (destinationCountry == null) // Destination country not found
            return null;

        final Queue<List<String>> routesQueue = new LinkedList<>();     // potential routes to explore
        final Set<String> visitedCountries = new HashSet<>();           // track visited countries to avoid loops

        visitedCountries.add(originCountry.cca3());
        routesQueue.add(List.of(originCountry.cca3()));
        while (!routesQueue.isEmpty()) {

            final List<String> route = routesQueue.remove();
            final String routeLastCountryName = route.getLast();

            if (routeLastCountryName.equals(destinationCountryName)) // we came to destination
                return route;

            Country country = countries.get(routeLastCountryName);
            if (country == null) // Country on route not found, skip route
                continue;

            List<String> neighbourCountryNames = country.borders();
            for (String neighborCountryName : neighbourCountryNames) { // for each neighbor

                if (!visitedCountries.contains(neighborCountryName)) { // we didn't visit this country yet

                    visitedCountries.add(neighborCountryName); // add neighbour to visited list

                    // Add new potential route to explore
                    List<String> newRoute = new ArrayList<>(route);
                    newRoute.add(neighborCountryName);
                    routesQueue.add(newRoute);
                }
            }
        }

        return null; // No route
    }
}
