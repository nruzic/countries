package com.cavendish.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountriesControllerIT {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getRouteFromCzeToIta() {
        ResponseEntity<CountriesResponseBody> response = template.getForEntity("/routing/cze/ita", CountriesResponseBody.class);
        assertThat(response.getBody()).isEqualTo(new CountriesResponseBody(List.of("CZE", "AUT", "ITA")));
    }

    @Test
    public void getRouteFromBihToIta() {
        ResponseEntity<CountriesResponseBody> response = template.getForEntity("/routing/BIH/Ita", CountriesResponseBody.class);
        assertThat(response.getBody()).isEqualTo(new CountriesResponseBody(List.of("BIH", "HRV", "SVN", "ITA")));
    }

    @Test
    public void getRouteFromHrvToArg() {
        ResponseEntity<CountriesResponseBody> response = template.getForEntity("/routing/hrv/arg", CountriesResponseBody.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
