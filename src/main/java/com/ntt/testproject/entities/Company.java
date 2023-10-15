package com.ntt.testproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Сущность, представляющая компанию.
 * Содержит информацию о полном и кратком наименованиях компании, ИНН, ОГРН, юридическом и почтовом адресах,
 * генеральном директоре и связанных с ней филиалах.
 */
@Getter
@Setter
@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "inn")
    private String inn;

    @Column(name = "ogrn")
    private String ogrn;

    @ManyToOne
    private Address legalAddress;

    @ManyToOne
    private Address postalAddress;

    @ManyToOne
    private Person ceo;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Branch> branches;
}
