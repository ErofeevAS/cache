package com.erofeev.demo.service.converter.impl;

import com.erofeev.demo.repo.model.City;
import com.erofeev.demo.repo.model.Country;
import com.erofeev.demo.repo.model.President;
import com.erofeev.demo.service.converter.Populator;
import com.erofeev.demo.service.model.CityDTO;
import com.erofeev.demo.service.model.CountryDTO;
import com.erofeev.demo.service.model.PresidentDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CountryPopulator implements Populator<Country, CountryDTO> {
    private Populator<President, PresidentDTO> presidentPopulator;
    private Populator<List<City>, List<CityDTO>> cityListPopulator;

    public CountryPopulator(Populator<President, PresidentDTO> presidentPopulator,
                            Populator<List<City>, List<CityDTO>> cityListPopulator) {
        this.presidentPopulator = presidentPopulator;
        this.cityListPopulator = cityListPopulator;
    }

    @Override
    public void populate(Country source, CountryDTO target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPopulation(source.getPopulation());
        President president = source.getPresident();
        PresidentDTO presidentDTO = new PresidentDTO();
        target.setPresident(presidentDTO);
        presidentPopulator.populate(president, presidentDTO);
        List<City> cities = source.getCities();
        List<CityDTO> cityDTOList = new ArrayList<>();
        target.setCities(cityDTOList);
        cityListPopulator.populate(cities, cityDTOList);
    }
}
