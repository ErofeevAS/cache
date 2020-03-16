package com.erofeev.demo.service;

import com.erofeev.demo.repo.CountriesRepository;
import com.erofeev.demo.repo.model.Country;
import com.erofeev.demo.service.converter.Converter;
import com.erofeev.demo.service.model.CountryDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private CountriesRepository countriesRepository;
    private Converter<Country,CountryDTO> countryConverter;


    public CountryServiceImpl(CountriesRepository countriesRepository, Converter<Country,CountryDTO> countryConverter) {
        this.countriesRepository = countriesRepository;
        this.countryConverter = countryConverter;
    }

    @Override
    public List<Country> getCountries() {
        return countriesRepository.getAllBy();
    }

    @Override
    @Cacheable(cacheNames = "countriesCache", key = "#name")
    public CountryDTO getCountry(String name) {
        Country country = countriesRepository.getFirstByName(name);
        return countryConverter.convert(country);

    }

    @Override
    public Country update(Country country) {
        String name = country.getName();
        long population = country.getPopulation();
//        Country savedCountry = countriesRepository.update(name, population);
//        return savedCountry;

        return null;}
}
