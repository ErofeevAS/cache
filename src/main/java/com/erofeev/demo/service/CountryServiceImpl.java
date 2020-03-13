package com.erofeev.demo.service;

import com.erofeev.demo.repo.CountriesRepository;
import com.erofeev.demo.repo.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountriesRepository countriesRepository;


    public CountryServiceImpl(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    @Override
    public List<Country> getCountries() {
        return countriesRepository.getAllBy();
    }

    @Override
    public Country getCountry(String name) {
        Country country = countriesRepository.getFirstByName(name);
        return country;
    }

    @Override
    public Country update(Country country) {
        String name = country.getName();
        long population = country.getPopulation();
//        Country savedCountry = countriesRepository.update(name, population);
//        return savedCountry;

        return null;}
}
