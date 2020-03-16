package com.erofeev.demo.service.converter.impl;

import com.erofeev.demo.repo.model.City;
import com.erofeev.demo.service.converter.Populator;
import com.erofeev.demo.service.model.CityDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityListPopulator implements Populator<List<City>, List<CityDTO>> {
    @Override
    public void populate(List<City> source, List<CityDTO> target) {
        for (City city : source) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setId(city.getId());
            cityDTO.setName(city.getName());
            cityDTO.setPostCode(city.getPostCode());
            target.add(cityDTO);
        }
    }
}
