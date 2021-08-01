package com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.service;

import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.entity.SamplePerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.time.LocalDate;

@Service
public class SamplePersonService extends CrudService<SamplePerson, Integer> {

    private SamplePersonRepository repository;

    public SamplePersonService(@Autowired SamplePersonRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SamplePersonRepository getRepository() {
        return repository;
    }

}
