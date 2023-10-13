package com.ntt.testproject.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String fullName;
    private String shortName;
    private String inn;
    private String ogrn;
    private String postalAddress;
    private String legalAddress;
    private String ceoName;
}
