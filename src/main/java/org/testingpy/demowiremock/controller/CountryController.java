package org.testingpy.demowiremock.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.testingpy.demowiremock.dto.Country;
import org.testingpy.demowiremock.service.CountryService;

import java.util.List;

@RestController("/api")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/country/capital/{capital}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Country>> getByCapitals(@PathVariable("capital") String capital) {
        List<Country> countriesByCapital = this.countryService.getCountriesByCapital(capital);
        if(countriesByCapital.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(countriesByCapital);
    }

    @GetMapping(value = "/country/name/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Country>> getByName(@PathVariable("name") String name) {
        List<Country> countriesByCapital = this.countryService.getCountriesByName(name);
        if(countriesByCapital.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(countriesByCapital);
    }

    @GetMapping(value = "/country/region/{region}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Country>> getByRegion(@PathVariable("region") String region) {
        List<Country> countriesByCapital = this.countryService.getCountriesByRegion(region);
        if(countriesByCapital.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(countriesByCapital);
    }
}
