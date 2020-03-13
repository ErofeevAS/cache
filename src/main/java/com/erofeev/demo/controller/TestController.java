package com.erofeev.demo.controller;

import com.erofeev.demo.repo.model.Country;
import com.erofeev.demo.service.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class TestController {

    private CountryServiceImpl countryService;

    public TestController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public List<RequestMethod> getOptions() {
        List<RequestMethod> methods = new ArrayList<>();
        methods.add(RequestMethod.DELETE);
        methods.add(RequestMethod.GET);
        methods.add(RequestMethod.POST);
        return methods;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{name}")
    public Country getCountry(@PathVariable String name) {
        return countryService.getCountry(name);
    }

    @PostMapping
    public HttpStatus updateCountry(@RequestBody Country country) {
//        countryService.update(country);
        return HttpStatus.OK;
    }
}
