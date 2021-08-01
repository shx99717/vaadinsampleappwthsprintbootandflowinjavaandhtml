package com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.service;

import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.data.entity.SampleAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleAddressRepository extends JpaRepository<SampleAddress, Integer> {

}