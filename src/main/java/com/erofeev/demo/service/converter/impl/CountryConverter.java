package com.erofeev.demo.service.converter.impl;

import com.erofeev.demo.repo.model.Country;
import com.erofeev.demo.service.converter.Converter;
import com.erofeev.demo.service.converter.impl.CountryPopulator;
import com.erofeev.demo.service.model.CountryDTO;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter<S, T> implements Converter<Country, CountryDTO> {
    private CountryPopulator countryPopulator;

    public CountryConverter(CountryPopulator countryPopulator) {
        this.countryPopulator = countryPopulator;
    }

    @Override
    public CountryDTO convert(Country source) {
        CountryDTO countryDTO = new CountryDTO();
        countryPopulator.populate(source, countryDTO);
        return countryDTO;
    }
}
