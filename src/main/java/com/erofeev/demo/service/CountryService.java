package com.erofeev.demo.service;

import com.erofeev.demo.repo.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    Country getCountry(String name);

    Country update(Country country);
}
