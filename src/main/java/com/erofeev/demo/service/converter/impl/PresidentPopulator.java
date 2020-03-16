package com.erofeev.demo.service.converter.impl;

import com.erofeev.demo.repo.model.President;
import com.erofeev.demo.service.converter.Populator;
import com.erofeev.demo.service.model.PresidentDTO;
import org.springframework.stereotype.Component;

@Component
public class PresidentPopulator implements Populator<President, PresidentDTO> {
    @Override
    public void populate(President source, PresidentDTO target) {
        target.setId(source.getId());
        target.setAge(source.getAge());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
    }
}
