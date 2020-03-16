package com.erofeev.demo.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO implements Serializable {
    private static final long serialVersionUID = 5517244812959569957L;
    private Long id;
    private String name;
    private Long population;
    private PresidentDTO president;
    private List<CityDTO> cities;
}
