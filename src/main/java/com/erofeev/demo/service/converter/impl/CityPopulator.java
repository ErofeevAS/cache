package com.erofeev.demo.service.converter.impl;

import com.erofeev.demo.repo.model.City;
import com.erofeev.demo.service.converter.Populator;
import com.erofeev.demo.service.model.CityDTO;
import org.springframework.stereotype.Component;

@Component
public class CityPopulator implements Populator<City, CityDTO> {

    @Override
    public void populate(City source, CityDTO target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPostCode(source.getPostCode());
    }
}
