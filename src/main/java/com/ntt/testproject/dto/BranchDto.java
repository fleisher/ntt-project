package com.ntt.testproject.dto;

import lombok.Data;

/**
 * DTO (Data Transfer Object) для сущности Branch.
 * Представляет собой объект передачи данных между слоями приложения без логики.
 */
@Data
public class BranchDto {
    private Long id;
    private String name;
    private AddressDto postalAddress;
    private PersonDto ceo;
}
