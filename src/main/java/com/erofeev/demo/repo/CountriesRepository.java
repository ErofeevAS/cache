package com.erofeev.demo.repo;

import com.erofeev.demo.repo.model.Country;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {
    List<Country> getAllBy();

    @Cacheable(cacheNames = "countriesCache", key = "#name")
    Country getFirstByName(String name);

//    Country update(String name, Long population);
}
