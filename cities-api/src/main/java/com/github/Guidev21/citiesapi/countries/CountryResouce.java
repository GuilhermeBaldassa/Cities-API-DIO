package com.github.Guidev21.citiesapi.countries;

import com.github.Guidev21.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")

public class CountryResouce {
    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> Countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping
    public Country getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        return optional.get();
    }
}

