package org.testingpy.demowiremock.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.testingpy.demowiremock.dto.Country;
import org.testingpy.demowiremock.service.CountryService;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final String countryApiUrl;
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public CountryServiceImpl(@Value("${api.country.url}") String countryApiUrl, RestClient restClient, ObjectMapper objectMapper) {
        this.countryApiUrl = countryApiUrl;
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    public List<Country> getCountriesByName(String countryName) {
        return getExchange("/name/", countryName);
    }

    public List<Country> getCountriesByCapital(String capital) {
        return getExchange("/capital/", capital);
    }


    public List<Country> getCountriesByRegion(String region) {
        return getExchange("/region/", region);
    }

    private List<Country> getExchange(String pathParam, String valueOfParam) {
        return restClient.get()
                .uri(countryApiUrl + pathParam + valueOfParam)
                .exchange((request, response) -> {
                    if (response.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(204))) {
                        return Collections.emptyList();
                    } else if (response.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(200)) || response.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(206))) {
                        return objectMapper.readValue(response.getBody(), new TypeReference<>() {});
                    }
                    throw new RemoteException("Error en la invocación del servicio");
                });
    }
}
