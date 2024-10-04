package org.testingpy.demowiremock.service;

import org.testingpy.demowiremock.dto.Country;

import java.util.Collections;
import java.util.List;

public interface CountryService {

    default List<Country> getCountriesByName(String countryName) {
        return Collections.emptyList();
    }

    default List<Country> getCountriesByCapital(String capital) {
        return Collections.emptyList();
    }

    default List<Country> getCountriesByRegion(String region) {
        return Collections.emptyList();
    }
}
