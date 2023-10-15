package com.ntt.testproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Сущность, представляющая филиал компании.
 * Содержит информацию о наименовании филиала, его почтовом адресе, генеральном директоре и связанной компании.
 */
@Getter
@Setter
@Entity(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address postalAddress;

    @ManyToOne
    @JoinColumn(name = "ceo_id", nullable = false)
    private Person ceo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
