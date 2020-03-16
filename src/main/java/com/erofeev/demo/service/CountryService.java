package com.erofeev.demo.service;

import com.erofeev.demo.repo.model.Country;
import com.erofeev.demo.service.model.CountryDTO;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    CountryDTO getCountry(String name);

    Country update(Country country);
}
