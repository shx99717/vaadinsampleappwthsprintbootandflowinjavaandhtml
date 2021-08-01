package com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.service;

import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.entity.SamplePerson;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Integer> {

}