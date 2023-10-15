package com.ntt.testproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Сущность, представляющая адрес.
 * Содержит информацию о почтовом индексе, стране, городе, улице, доме и офисе.
 */
@Getter
@Setter
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false)
    private String building;

    @Column(name = "office")
    private String office;
}

