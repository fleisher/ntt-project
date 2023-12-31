package com.ntt.testproject.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO (Data Transfer Object) для сущности Company.
 * Представляет собой объект передачи данных между слоями приложения без логики.
 */
@Data
public class CompanyDto {
    private Long id;
    private String fullName;
    private String shortName;
    private String inn;
    private String ogrn;
    private AddressDto postalAddress;
    private AddressDto legalAddress;
    private PersonDto ceo;
    private List<BranchDto> branches;
}
